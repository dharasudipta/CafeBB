import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import LoginComponent from './LoginComponent.jsx'
import SignupComponent from './SignupComponent.jsx'
import HeaderComponent from './HeaderComponent.jsx'
import FooterComponent from './FooterComponent.jsx'
import WelcomeComponent from './WelcomeComponent.jsx'
import LogoutComponent from './LogoutComponent.jsx'
import HomeComponent from './HomeComponent.jsx'
import MenuComponent from './MenuComponent.jsx'
import UserDetailsComponent from './UserDetailsComponent.jsx'
import AuthenticatedRoute from './AuthenticatedRoute.jsx'
import UserUpdateComponent from './UserUpdateComponent.jsx'

class UserService extends Component {
    render() {
        return (
            <div className="UserService">
                <Router>
                    <>
                        <HeaderComponent/>
                        <Switch>
                            <Route path="/" exact component={HomeComponent}/>
                            <Route path="/login" component={LoginComponent}/>
                            <Route path="/signup" component={SignupComponent}/>
                           <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                           <AuthenticatedRoute path="/usersUpdate/:id" component={UserUpdateComponent}/>
                           <AuthenticatedRoute path="/userDetails" component={UserDetailsComponent}/>
                           <AuthenticatedRoute path="/logout" component={LogoutComponent}/>
                           <AuthenticatedRoute path="/menu" component={MenuComponent}/>
                           <Route path="/home" component={HomeComponent}/>

                           <Route component={ErrorComponent}/>
                         </Switch>
                        <FooterComponent/>
                    </>
                </Router>
            </div>
        )
    }
}

function ErrorComponent(){
    return(
        <div><h1>Error</h1></div>
    )
}






export default UserService