import React from 'react';
import ArticleList from '../components/ArticleList';
import articleContent from './article-content';

const ArticlesListPage = () => {
    return (
        <>
        <h1>List of Articles</h1>
        <ArticleList articles={ articleContent }></ArticleList>
        </>
      )
}
 
export default ArticlesListPage;