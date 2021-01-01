import React, {Component} from 'react';
import propTypes, { array } from 'prop-types'; 

class FavoriteColorForm extends  Component {
    state = {value: ''}
    newColor = e => 
      this.setState({value: e.target.value})
    submit = e => {
       console.log('New color is'+this.state.value)
      e.preventDefault()
    }
    render() {
      return (
         <form onSubmit={this.submit}>
           <label>  Favorite Color: 
             <input 
                type="color"
                onChange={this.newColor}
                />
           </label>
           <button>Submit</button> 
         </form>
      );
    }

  }