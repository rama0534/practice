import React from 'react';

const NavBar = ({totalCounters, activeCounters}) => {
    console.log("Nav - Rendered"); 
    return ( 
            <nav className="navbar navbar-light bg-light">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">
                          Navbar{" "}
                        <span className="badge badge-pill badge-secondary">Total: {totalCounters}</span>
                        <span className="badge badge-pill badge-secondary">Active: {activeCounters}</span>
                        </a>
                </div>
            </nav>
         );
}
 
export default NavBar;