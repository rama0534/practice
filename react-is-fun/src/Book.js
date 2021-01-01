import React, {Component} from 'react';
export const Book = ({title='No title provided', author='Anonymous', page='0', freeBookMark='No'}) => {
    return(
      <section>
        <h1>Title: {title}</h1>
        <p>by: {author}</p>
        <p>Pages: {page} pages</p>
        <p>Free Book Mark: {freeBookMark ? 'yes!':'no!'}</p>
      </section>
    )
  }