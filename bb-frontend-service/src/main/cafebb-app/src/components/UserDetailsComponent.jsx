import React, { Component } from 'react'
import UserData from '../API/UserData.js'
import Authentication from './Authentication.js'

class UserDetailsComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [],
            message: null
        }
        this.deleteUserClicked = this.deleteUserClicked.bind(this)
        this.updateUserClicked = this.updateUserClicked.bind(this)
        this.refreshUserDetails = this.refreshUserDetails.bind(this)
        this.equals = this.equals.bind(this)
     }

    componentDidMount() {
        this.refreshUserDetails();
    }

    refreshUserDetails() {
        Authentication.RequestInterceptor()
        let username = Authentication.LoggedInUserName()
        UserData.executeGetAllUserDetails(username)
            .then(
                response => {
                    this.setState({ users: response.data })
                }
            )
    }

    deleteUserClicked(id) {
        let username = Authentication.LoggedInUserName()
       // console.log(id + " " + username);
        UserData.executeDeleteUser(username, id)
            .then(
                response => {
                    this.setState({ message: `User Delete Successful` })
                    this.refreshUserDetails()
                }
            )

    }

    updateUserClicked(id) {
        this.props.history.push(`/usersUpdate/${id}`)
    }
    equals(s1){
        let s2 = Authentication.LoggedInUserId()
        if(s1===s2)
         return true
        return false
    }

    render() {
        return(
            <div>
                <h1>List of Users</h1>
                {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
                <div className="container">
                 <table className="table">
                     <thead>
                            <tr>
                                {<th>Role</th>}
                                <th>Name</th>
                                <th>Mobile Number</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                   !( this.equals((user.id).toString()) || "Admin"===user.role ) && 
                                    <tr key={user.id}>
                                    <td>{user.role}</td>
                                    <td>{user.fullName}</td>
                                    <td>{user.mobile}</td>
                                    <td>{<button className="btn btn-success" onClick={() => this.updateUserClicked(user.id)}>Update</button>}</td>
                                    <td>{<button className="btn btn-warning" onClick={() => this.deleteUserClicked(user.id)}>Delete</button>}</td>
                                </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default UserDetailsComponent