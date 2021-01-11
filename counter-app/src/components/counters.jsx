import React, { Component } from 'react';
import Counter from './counter'

class Counters extends Component {
     render() { 
        console.log("Counters - Rendered");
        const {onReset, onDelete, onIncrement, counters} = this.props;
        return ( <div>
             <button className="btn btn-primary btn-sm m-2" onClick={this.props.onReset}>Reset</button>
                     {this.props.counters.map(counter => (
                     <Counter 
                     key={counter.id} 
                     onDelete={this.props.onDelete}
                     onIncrement={this.props.onIncrement}
                     onDecrement={this.props.onDecrement}
                      counter={counter}
                      >
                         </Counter>))}
                 </div> );
    }
}
 
export default Counters;