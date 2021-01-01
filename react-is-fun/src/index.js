  import React, {Component} from 'react';
  import {render} from 'react-dom';
  import Library from './Library'
    

  let bookList = [
    {title:"Half Girl Friend", author:"Bagath", page:"500"},
    {title:"Monk who sold his ferrari", author:"Robin Sharma", page:"659"},
    {title:"Cat's Cradle", author:"Kurt Vonnegut", page:"467"}
  ]

  
  
  
  
  render(<Library books={bookList} />, document.getElementById('root'));
