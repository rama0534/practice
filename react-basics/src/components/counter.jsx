import React, { Component } from 'react';

class Counter extends Component {
    state = {  
        count: 0,
        tags: ['tag1', 'tag2', 'tag3']
        
    };
    styles = {
        fontSize: 20,
        fontWeight: 'bold'
    };
    renderTags(){
        if(this.state.tags.length === 0) return <p>There is no tags!</p>;
        return <ul>{this.state.tags.map(tag => <li key={tag}> {tag} </li>)}</ul>
    }
    handleIncrement = () => {
        // console.log("Increment", this)
        this.setState({count : this.state.count + 1});
    }
    render() { 
        return (
        <div>
        <span style = {this.styles} className={ this.getBadgeClasses() }>{this.formatCount()}</span>
        <button style = {{ fontSize: 20}} type="button" className="btn btn-secondary btn-lg m-2" onClick={this.handleIncrement}>Increment</button>
        {this.renderTags()}
        </div>);
    }
    getBadgeClasses() {
        let classes = "badge m-2 badge-";
        classes += this.state.count === 0 ? "warning" : "primary";
        return classes;
    }

    formatCount() {
        const { count } = this.state;
         return  count === 0 ? 'Zero' :  count; 
    }
}
 
export default Counter;