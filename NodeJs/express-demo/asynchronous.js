const func = require("joi/lib/types/func");

console.log('before');

/* Callback approach */
// getUser(1, (user) => { 
//     getRepositories(user.githubusername, (repos) => {
//         getCommits(repos[0], (commits) => {
//             console.log(commits);
//         })
//     })
// });

/* Promise approach */
// getUser(1)
//     .then(user => getRepositories(user.githubusername))
//     .then(repos => getCommits(repos[0]))
//     .then(commits => console.log('commits', commits))
//     .catch( err => console.error('Error', err.message));

/* Async and Await approach */
async function displayCommits(){
    try{
        const user = await getUser(1);
        const repos = await getRepositories(user.githubusername);
        const commits = await getCommits(repos[0]);
        console.log(commits);
    }
    catch(err){
        console.log('Error', err.message);
    }
}

displayCommits();
console.log('after');

function getUser(id) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("reading from a databse.....");
            resolve({ id: id, githubusername: "rama"});
        }, 2000);
    });
}

function getRepositories(username) {
    return new Promise ((resolve, reject) => {
        setTimeout(() => {
            console.log('calling from repository....');
            resolve(['repo1', 'repo2', 'repo3']);
            // reject(new Error('Could not get repos'));
        }, 2000);
    });
}

function getCommits(repo){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Calling getCommit...");
            resolve(['commit']);
        },2000)
    })
}


