import React, { Component } from 'react'
//import HelloWorldService from '../../api/todo/HelloWorldService.js'
//import UserData from '../API/UserData.js'
import Authentication from './Authentication.js'

class WelcomeComponent extends Component {

    constructor(props)
    {
        super(props)
        this.getMsg=this.getMsg.bind(this)
        this.state={
            welcomeMessage : ''
           // backendData : []
        }
        this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this)
         this.handleError = this.handleError.bind(this)
    }

    render() {
        return (
            <>
                <h1>Welcome {Authentication.LoggedInUserFullName()}</h1>
                <div >
                 {/* <button className="btn btn-success" onClick={this.getMsg}>click</button> */}
                </div>
                <div className="container">
                    {this.state.welcomeMessage}
                </div>
                
                {/* <div className="container">
                    Welcome {this.props.match.params.name}.
                    You can manage your todos <Link to="/todos">here</Link>.
                </div>
                <div className="container">
                    Click here to get a customized welcome message.
                    <button onClick={this.retrieveWelcomeMessage}
                        className="btn btn-success">Get Welcome Message</button>
                </div>
                <div className="container">
                    {this.state.welcomeMessage}
                </div> */}

            </>
        )
    }

    getMsg(){
       // console.log("clicked inside getMsg()")
    //    Test.execute()
    //    .then(result => this.handleSuccessfulResponse(result))
     //let username = Authentication.LoggedInUserName()
    //    UserData.executeGetUserById(username,1)
    //    .then(result => this.handleSuccessfulResponse(result))
       //.catch(error => this.handleError(error))

    //    Test.executePath(this.props.match.params.name)
    //         .then(response => this.handleSuccessfulResponse(response))
    //         .catch(error => this.handleError(error))

    // Test.executePathRole(this.props.match.params.name)
    //         .then(result => this.handleSuccessfulResponse(result))
            //.catch(error => this.handleError(error))
    }

    handleSuccessfulResponse(result) {
         console.log("clicked inside handleSuccessfulResponse()")
         console.log(result)
       // this.setState({backendData : result.data})
       // console.log(backendData[1].userRole)
        this.setState({ welcomeMessage: result.data.fullName })

        
    }
    handleError(error) {

        //console.log(error.result)
        let errorMessage =''
        if(error.message)
            errorMessage+=error.message;
        if(error.result && error.result.data)
            errorMessage=error.result.data.message
        
        this.setState({ welcomeMessage: errorMessage })
    }
}


    
    // retrieveWelcomeMessage() {
    //     // HelloWorldService.executeHelloWorldService()
    //     // .then( response => this.handleSuccessfulResponse(response) )

    //     // HelloWorldService.executeHelloWorldBeanService()
    //     // .then( response => this.handleSuccessfulResponse(response) )

    //     HelloWorldService.executeHelloWorldPathVariableService(this.props.match.params.name)
    //         .then(response => this.handleSuccessfulResponse(response))
    //         .catch(error => this.handleError(error))
    // }

    

    // handleError(error) {

    //      console.log(error.response)

    //     let errorMessage = '';

    //     if (error.message)
    //         errorMessage += error.message

    //     if (error.response && error.response.data) {
    //         errorMessage += error.response.data.message
    //     }

    //     this.setState({ welcomeMessage: errorMessage })
//     }

// }


export default WelcomeComponent