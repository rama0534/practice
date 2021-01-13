import React, { Component } from 'react';
import Like  from "./common/like"
import { getMovies } from '../fakeMovieService';

class Movies extends Component {
    state = { 
        movies: getMovies()
     };
     heandleDelete = (movie) => {
          const movies = this.state.movies.filter(m => m._id !== movie._id) ;
          this.setState({movies}); 
     }
     handleLike = (movie) => {
         const movies = [...this.state.movies];
         const index = movies.indexOf(movie);
         movies[index] = {...movies[index]};
         movies[index].liked = !movies[index].liked;
         this.setState({ movies });
     };
    render() { 
        const {length: count} = this.state.movies;
        if (count === 0) return <p>There are no movies to display.</p>
        return (
            <React.Fragment>
            <p>Showing {count} movie(s) in the database.</p>
            <table className="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Genre</th>
                        <th >NumberInStock</th>
                        <th>DailyRentalRate</th>
                        <th></th>
                    </tr> 
                </thead>
                <tbody>
                    {this.state.movies.map(movie => (
                    <tr key={movie._id}>
                        <td>{movie.title}</td>
                        <td>{movie.genre.name}</td>
                        <td>{movie.numberInStock}</td>
                        <td>{movie.dailyRentalRate}</td>
                        <td>  <Like liked={movie.liked} onClick={() => this.handleLike(movie)}/> </td>
                         {/* <td><i className="fa fa-heart"  /></td>  */}
                        <td><button onClick={() => this.heandleDelete(movie)} className="btn btn-danger btn-sm">Delete</button></td>
                    </tr>) )}
                    
                </tbody>
            </table></React.Fragment>
        );
    }
}
 
export default Movies;