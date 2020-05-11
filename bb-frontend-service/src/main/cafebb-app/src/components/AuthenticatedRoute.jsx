import React, { Component } from 'react'
import Authentication from './Authentication.js'
import { Route, Redirect } from 'react-router-dom'
class AuthenticatedRoute extends Component{
    render(){
        if(Authentication.isLoggedIn())
         return <Route {...this.props}/>
        return <Redirect to="/login"/>
    }
}
export default AuthenticatedRoute