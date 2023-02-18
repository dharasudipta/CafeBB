import React, {Component} from 'react'
import Authentication from './Authentication.js'
import {ErrorMessage, Field, Form, Formik} from 'formik';
import UserData from '../API/UserData.js';


class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            userName: '',
            password: '',
            isValid: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.loginClicked = this.loginClicked.bind(this)
        this.validate = this.validate.bind(this)
        this.login = this.login.bind(this)

    }

    login(result, res, values) {

        if (result.data) {
            Authentication.successfullyLoggedIn(
                res.data.userId,
                res.data.fullName,
                res.data.contactNumber,
                res.data.userName,
                res.data.password,
                res.data.role
            )
            this.setState({showSuccessMessage: true})
            this.setState({hasLoginFailed: false})
            this.props.history.push(`/welcome/${values.userName}`)

        } else {
            this.setState({showSuccessMessage: false})
            this.setState({hasLoginFailed: true})
        }

    }

    loginClicked(values) {

        UserData.executeGetValidityOfUser({
            userName: values.userName,
            password: values.password
        })
            .then(result => UserData.executeGetUserById(values.userName, result.data)
                .then((res) => this.login(result, res, values)))
    }

    componentDidMount() {
        Authentication.RequestInterceptor()

    }

    validate(values) {
        let error = {}
        if (!values.userName) {
            error.userName = "Enter userName"
        } else if (!values.password) {
            error.password = "Enter Password"
        }

        return error
    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div>
                    <Formik
                        initialValues={{userName: '', password: ''}}
                        onSubmit={this.loginClicked}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialization={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="userName" component="div" className="alert alert-warning"/>
                                    <ErrorMessage name="password" component="div" className="alert alert-warning"/>
                                    {this.state.hasLoginFailed &&
                                        <div className="alert alert-warning">Invalid Credentials</div>}

                                    <fieldset>
                                        <label><strong> User Name: </strong></label>
                                        <Field type="text" name="userName" placeholder="userName"/>
                                    </fieldset>
                                    <fieldset>
                                        <label><strong>Password::</strong></label>
                                        <Field type="password" name="password" placeholder="Password"></Field>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Login</button>
                                </Form>
                            )
                        }

                    </Formik>
                </div>
            </div>
        )
    }
}

export default LoginComponent