import React, { Component } from 'react'
//import AuthenticationService from './AuthenticationService.js'


class FooterComponent extends Component {
    render() {
       // const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        //console.log(isUserLoggedIn);

        return (
            <footer className="footer">
                <span className="text-muted"> All Rights Reserved @CafeBB

                </span>
            </footer>
        )
    }
}

export default FooterComponent