const request = require('supertest');
const { Genre } = require('../../models/genres-mongo');
const { User } = require('../../models/user');
const mongoose = require('mongoose'); 
let server;

describe('/api/genres', () => {
    beforeEach(() => { server = require('../../index')});
    afterEach( async() => { 
        await Genre.remove({});
        await server.close();
    });
    describe('GET /', () => {
        it('should return all genres', async() => {
            await Genre.collection.insertMany([
                {name: 'genre1'},
                {name: 'genre2'}
            ]);;
            const res = await request(server).get('/api/genres-mongodb'); 
            expect(res.status).toBe(200);
            expect(res.body.length).toBe(2);
            expect(res.body.some(g => g.name === 'genre1')).toBeTruthy();
            expect(res.body.some(g => g.name === 'genre2')).toBeTruthy();
            expect(res.body[0]).toHaveProperty('_id');
            expect(res.body[0]).toHaveProperty('name', 'genre1');
        }); 
    });
    describe('GET/ :id', () => {
        it('should return a genre if valid id is passed', async() => {
            const genre = new Genre({name: 'genre1'});
            await genre.save();
            const res = await request(server).get('/api/genres-mongodb/'+ genre._id);
            // expect(res.status).toBe(200);
            expect(res.body).toHaveProperty('name', genre.name);
        });
        it('should return 404 if invalid id is passed', async() => {
            const genre = new Genre({name: 'genre1'});
            await genre.save();
            const res = await request(server).get('/api/genres-mongodb/1');
            expect(res.status).toBe(404); 
        });
    });
    describe('POST /', () => {
        let token;
        let name;
        const exec = async() =>{
            return await request(server)
                                .post('/api/genres-mongodb')
                                .set('x-auth-token', token)
                                .send({name});
        }
        beforeEach( () => {
            token = new User().generateAuthToken();
            name = 'genre1'
        })
        it('should return 401 if the client not logged into the account...', async() => {
            const res = await request(server).post('/api/genres-mongodb').send({name: 'genre1'});
            expect(res.status).toBe(401);
        });
        it('should return 400 if the genre less than 5 charecters', async() => { 
            name = '1234';
            const res = await exec();
            expect(res.status).toBe(400);
        }); 
        it('should return 400 if the genre less than 50 charecters', async() => { 
            name = new Array(52).join('a');
            const res = await exec();
            expect(res.status).toBe(400);
        });
        it('should save the genre if it is valid', async() => { 
            const res = await exec();
            const genre = await Genre.findOne({name: 'genre1'}); 
            expect(genre).not.toBeNull();
        }); 
        it('should retun the genre if it is valid', async() => { 
            const res = await exec(); 
            expect(res.body).toHaveProperty('_id');
            expect(res.body).toHaveProperty('name');
        });  
    }); 
    describe('DELETE /', () => {
        let genre, token, id;
        const exce = async () => {
             return await request(server)
                            .delete('/api/genres-mongodb/'+id)
                            .set('x-auth-token', token)
                            .send();
        };
        beforeEach(async() => {
            genre = new Genre({name: 'genre1'});
            await genre.save();
            id = genre._id;
            token = new User({ isAdmin: true }).generateAuthToken(); 
        })
        it('shold return 401 if the client is not logged in ', async() => {
            token = '';
            const res = await exce();
            expect(res.status).toBe(401);
        });
        it('should return 403 if the client is not admin', async() => {
            token = new User().generateAuthToken();
            const res = await exce();
            expect(res.status).toBe(403);
        });
        it('should return 404 if id is invalid', async() => {
            id = '';
            const res = await exce();
            expect(res.status).toBe(404);
        } );
        it('should return 404 if the given id was not found', async() => {
            id = mongoose.Types.ObjectId();
            const res = await exce();
            expect(res.status).toBe(404);
        })
        it('should delete genre', async() => {
             await exce();
             const genreInDb = await Genre.findById(id);
             expect(genreInDb).toBeNull();
        });
        it('should return deleted genre', async() => {
            const res = await exce();
            expect(res.body).toHaveProperty('_id', genre._id.toHexString());
            expect(res.body).toHaveProperty('name', genre.name);
        });
    });
    describe('PUT /', () => {
        let id, token, genre, name;
        const exce = async () => {
            return await request(server)
                                    .put('/api/genres-mongodb/'+id)
                                    .set('x-auth-token', token)
                                    .send({name});
        };
        beforeEach(async() => {
            genre = new Genre ({ name: 'genre1'});
            await genre.save();
            id = genre._id;
            token = new User({isAdmin: true}).generateAuthToken();
        });

        it('should return 401 if the client is not loged in', async() => {
            token = '';
            const res = await exce();
            expect(res.status).toBe(401);
        });
        it('should return 403 if the client is not admin', async() => {
            token = new User().generateAuthToken();
            const res = await exce();
            expect(res.status).toBe(403);
        });
        it('should return 404 if id is invalid', async() => {
            id = '';
            const res = await exce();
            expect(res.status).toBe(404);
        } );
        it('should return 404 if the given id was not found', async() => {
            id = mongoose.Types.ObjectId();
            name = "genre2"; 
            const res = await exce();
            expect(res.status).toBe(404);
        });
        it('should return updated genrer if the given input is valid', async() => {
            name = 'genre2';
            res = await exce();
            const newGenre = await Genre.findById(id); 
            expect(newGenre.name).toBe(name);
        })
    });
});