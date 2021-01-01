import React, {Component} from 'react'
import propTypes, { array } from 'prop-types'
import {Book} from './Book'
import {Hiring} from './Hiring'
import {NotHiring} from './NotHiring'

class Library extends React.Component{
    static defaultProps = {
      books: [
        {title:"ABX", author:"xyz", page:"100" }
      ]
    }

    state = { 
      open: true,
      freeBookMark: true,
      hiring: false,
      data: [],
      loading: false
    }

    componentDidMount() {
      this.setState({loading: true})
      fetch('https://hplussport.com/api/products/order/price/sort/asc/qty/1')
      .then(data => data.json())
      .then(data => this.setState({data, loading: false}))
    }

    componentDidUpdate(){
      console.log("The component just updates")
    }

    toggleOpenClosed = () => {
      this.setState(prevState => ({
        open: !prevState.open
      }))
    }

    render(){
      const {books} = this.props
      return(
      <div>
        {this.state.hiring ? <Hiring/> : <NotHiring/>}
        {this.state.loading 
          ? "loading" :
          <div>
            {this.state.data.map(product =>{
              return (
                <div key={product.id}>
                  <h3>Library Products</h3>
                  <h4>{product.name}</h4>
                  <img src={product.image} height={100}/> 
                  </div>
              )
            })}
            </div>
        }
        <h1>The Library is {this.state.open ? 'open' : 'closed'}</h1>
        <button onClick={this.toggleOpenClosed}>Change</button>
        { books.map(
          (book, i) => 
                <Book 
                    key={i} title={book.title} 
                    author={book.author} 
                    page={book.page}
                    freeBookMark={this.state.freeBookMark}
                />) 
        }
      </div>
    )
    }
  }
  
  
  Library.propTypes = {
    books: propTypes.array
  }
  Book.propTypes = {
    title: propTypes.string,
    author: propTypes.string,
    page: propTypes.number,
    freeBookMark: propTypes.bool
  }

export default Library