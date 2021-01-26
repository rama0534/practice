import './App.css';
import HomePage from './pages/Homepage';
import About from './pages/About';
import ArticleListPage from './pages/ArticleListPage';
import PageNotFound from './pages/PageNotFound';
import NavBar from "./NavBar";
import {
  BrowserRouter as Router,
  Route,
  Switch,
} from 'react-router-dom'
import ArticlePage from './pages/Article';

function App() {
  return (
    <Router>
    <div className="App">
      <NavBar/> 
      <div id="page-body">
        <Switch>
        <Route path="/" component={HomePage} exact/>
        <Route path="/article-list" component={ArticleListPage} exact/>
        <Route path="/about" component={About} exact/>
        <Route path="/article/:name" component={ArticlePage} exact/>
        <Route component={PageNotFound}/>
        </Switch>
      </div>
    </div>
    </Router>
  );
}

export default App;
