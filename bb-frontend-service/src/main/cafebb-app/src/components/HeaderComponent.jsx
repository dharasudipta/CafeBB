import React, { Component } from 'react'
import { withRouter } from 'react-router';
import { Link } from 'react-router-dom'
import Authentication from './Authentication.js'


class HeaderComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            
        };
    }
    render() {
        const isLoggedIn = Authentication.isLoggedIn();
        const fullName = Authentication.LoggedInUserFullName();
        const userDetailsHeader=(Authentication.IsRoleAdmin() || Authentication.IsRoleManager());
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><Link className="navbar-brand" to ="/welcome/username" ><h1>CafeBB</h1></Link></div>
                    <ul className="navbar-nav">
                        {isLoggedIn && <li><Link className="nav-link" to="/welcome/username">Home</Link></li>}
                        {isLoggedIn && <li><Link className="nav-link" to="/menu">Menu</Link></li>}
                        {isLoggedIn && userDetailsHeader && <li><Link className="nav-link" to="/userDetails">User Details</Link></li>}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isLoggedIn && <li><Link className="nav-link" to="/signup">SignUp</Link></li>}   
                        {!isLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                         {isLoggedIn && <li><Link className="nav-link" to="/home" onClick={Authentication.logout} >Logout <br/> {fullName}</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(HeaderComponent)



 
