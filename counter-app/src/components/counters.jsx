import React, { Component } from 'react';
import Counter from './counter'

class Counters extends Component {
    state = {  
        counters: [
            {id:1, value: 4},
            {id:2, value: 0},
            {id:3, value: 0},
            {id:4, value: 0},

        ]
    };
    handleDelete = () => {
        console.log('Event Handler called');
    };
    render() { 
        return ( <div>
                     {this.state.counters.map(counter => (
                     <Counter key={Counter.id} onDelete={this.handleDelete} value={counter.value}>
                         </Counter>))}
                 </div> );
    }
}
 
export default Counters;