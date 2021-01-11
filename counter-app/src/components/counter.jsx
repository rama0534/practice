import React, { Component } from 'react';
class Counter extends Component {
    componentDidUpdate(PrevProps, prevState){
        console.log("PrevPros", PrevProps );
        console.log("PrevState", prevState );

    }
    componentWillUnmount(){
        console.log("Component unmounted");
    }
    render() { 
        console.log("Counter - Rendered")
        return (
            <div className="row">
                <div className="col-1">  
                    <span className={this.getBadgeClasses()}>{this.formatCount()}</span>
                </div>
                <div className="col">
                <button 
                onClick={() => this.props.onIncrement(this.props.counter)} 
                className="btn btn-secondary btn-sm  "
                >
                +
                </button>
                <button 
                onClick={() => this.props.onDecrement(this.props.counter)} 
                className="btn btn-secondary btn-sm m-2"  disabled={this.props.counter.value === 0 ? 'disabled' : ''}
                >
                -
                </button>
                <button 
                    onClick={() => this.props.onDelete(this.props.counter.id)} 
                    className="btn btn-danger btn-s m-2"  
                >
                    X
                </button>
                </div>
            </div>
            );
    }
    getBadgeClasses() {
        let classes = "badge badge-";
        classes += this.props.counter.value === 0 ? "warning" : "primary";
        return classes;
    }
    formatCount() {
        const { value: count } = this.props.counter;
        return count === 0 ? "Zero" : count;
    }
    getDecrementBadgeClasses() {
        let classes = "btn btn-secondary btn-sm  ";
        classes += this.props.counter.value === 0 ? "disabled" : "";
        return classes;
    }
}

 
export default Counter;