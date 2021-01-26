import React from 'react';
import { Link } from 'react-router-dom'
const NavBar = () => (
    
            <nav className="navbar navbar-light bg-light">
                <ul>
                    <li>
                        <Link to="/" > Home </Link>
                     
                        <Link to="/article-list" > Artile-List </Link>
                    
                        <Link to="/about" > About </Link>
                    </li>
                </ul>
            </nav>

);
export default NavBar;

