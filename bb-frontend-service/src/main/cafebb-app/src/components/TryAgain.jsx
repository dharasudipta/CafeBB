import React, { Component } from 'react'
import { Link } from 'react-router-dom'
class TryAgain extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: 'CafeBB',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        // this.handleUsernameChange = this.handleUsernameChange.bind(this)
        // this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        //console.log(this.state);
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    // handleUsernameChange(event) {
    //     //console.log(event.target.name);
    //     this.setState(
    //         {
    //             [event.target.name]
    //               :event.target.value
    //         }
    //     )
    // }

    // handlePasswordChange(event) {
    //     console.log(event.target.value);
    //     this.setState({password:event.target.value})
    // }

    loginClicked() {
        //in28minutes,dummy
         if(this.state.username==='CafeBB' && this.state.password==='1234'){
        //     AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password)
             this.props.history.push(`/welcome/${this.state.username}`)
        //     //this.setState({showSuccessMessage:true})
        //     //this.setState({hasLoginFailed:false})
         }
         else {
            this.props.history.push("/tryAgain")
        //     this.setState({showSuccessMessage:false})
        //     this.setState({hasLoginFailed:true})
         }

        // AuthenticationService
        // .executeBasicAuthenticationService(this.state.username, this.state.password)
        // .then(() => {
        //     AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password)
        //     this.props.history.push(`/welcome/${this.state.username}`)
        // }).catch( () =>{
        //     this.setState({showSuccessMessage:false})
        //     this.setState({hasLoginFailed:true})
        // })
       
    }

    render() {
        return (
            <div>
                <h4>Invalid usename or password !!!<br></br>Try Again</h4>
                <div className="container">
                    {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
                    User Name: <input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}

export default TryAgain