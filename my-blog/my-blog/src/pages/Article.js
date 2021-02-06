import React, {useState, useEffect} from 'react';
import articleContent from './article-content';
import UpvotesSection from '../components/UpvotesSection';
import AddCommentForm from '../components/AddCommentForm'
import CommentsList from '../components/CommentsList'
import ArticlesList from '../components/ArticleList';
import PageNotFound from './PageNotFound';
const ArticlePage = ({ match }) => {
    const name = match.params.name;
    const article = articleContent.find(article => article.name === name);
    const [articleInfo, setArticleInfo] = useState({upvotes: 0, comments:[]});
    useEffect(() => {
      const fetchData = async() => {
        const result = await fetch(`/api/articles/${name}`);
        const body = await result.json();
        setArticleInfo(body);

      }
      fetchData();
      // setArticleInfo({upvotes: Math.ceil(Math.random()*10)});
    },[name]);
    if(!article) return <PageNotFound/>
    const otherArticles = articleContent.filter(article => article.name !== name)
    return (
        <>
        <h1> {article.title} </h1>
        <UpvotesSection articleName={name} upvotes={articleInfo.upvotes} setArticleInfo={setArticleInfo}></UpvotesSection>
        {article.content.map((paragrph, key) => (<p key={key}>{paragrph}</p>))}
        <CommentsList comments={articleInfo.comments}/>
        <AddCommentForm articleName={name} setArticleInfo={setArticleInfo}/>
        <h3>Other Articles</h3>
        <ArticlesList articles={otherArticles}/>
        </>
      )
}
 
export default ArticlePage;