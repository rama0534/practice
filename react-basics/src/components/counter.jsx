import React, { Component } from 'react';

class Counter extends Component {
    state = {  
        count: 0
        
    };
    styles = {
        fontSize: 30,
        fontWeight: 'bold'
    };
     
    render() { 
        return (
        <div>
        <span style = {this.styles} className="badge badge-primary m-2">{this.formatCount()}</span>
    
        <button style = {{ fontSize: 20}} type="button" class="btn btn-secondary btn-lg m-2" >Increment</button>
        </div>);
    }
    formatCount() {
        const { count } = this.state;
         return  count === 0 ? 'Zero' :  count; 
    }
}
 
export default Counter;