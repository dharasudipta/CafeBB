import React, {Component} from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import Authentication from './Authentication.js'
import UserData from '../API/UserData.js';


class UserUpdateComponent extends Component{
    constructor(props) {
        super(props);
        
        this.state = {
            id: this.props.match.params.id,
            fullName: '',
            mobile: '',
            role: ''
        };
        this.SubmitUpdate=this.SubmitUpdate.bind(this)
        this.validate=this.validate.bind(this)

    }
    componentDidMount(){
        Authentication.RequestInterceptor()
        let username = Authentication.LoggedInUserName()
       UserData.executeGetUserById(username,this.state.id)
        .then(result=>this.setState({
            fullName: result.data.fullName,
            mobile: result.data.mobile,
            role: result.data.role
        }))
        
    }
    SubmitUpdate(values){
        let username = Authentication.LoggedInUserName()
        let user = {
            id: this.state.id,
            fullName: values.fullName,
            mobile: values.mobile,
            role : values.role
        }
        UserData.executeUpdateUser(username,this.state.id,user).then(()=>this.props.history.push(`/userDetails`))
    }
    validate(values){
        let error={}
        if(!values.fullName){
            error.fullName="Enter Full Name"
        }
        else if(!values.mobile){
            error.mobile="Enter Mobile No."
        }
        else if(!values.role ){
            error.role="Enter Role "
        }
        return error

    }
    render(){
        let {fullName,mobile,role} = this.state
        return(
        <div><div><h2>Update Details</h2></div><br/>
        <div className="container">
            <Formik 
                initialValues={{ fullName,mobile,role }}
                onSubmit={this.SubmitUpdate}
                validateOnChange={false}
                validateOnBlur={false}
                validate={this.validate}
                enableReinitialization={true}
            >
                { 
                    (props) => (
                        <Form >
                            <ErrorMessage name="fullName" component="div" className="alert alert-warning" />
                            <ErrorMessage name="mobile" component="div" className="alert alert-warning" />
                            <ErrorMessage name="role" component="div" className="alert alert-warning" />
                             <fieldset className="form-group">
                                <label><strong>Full Name:</strong></label>
                                <Field type="text" name="fullName" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label><strong>Mobile:</strong></label>
                                <Field type="text" name="mobile" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label><strong>Role:</strong></label>
                                <Field type="text" name="role"  />
                            </fieldset>
                            <button className="btn btn-success" type="submit">Update</button>
                        </Form>
                    )
                }
            </Formik></div><br/><br/>
            <div className="alert alert-warning">*NOTE :Type "Admin" or "Manager" or "Staff" in the field of Role</div>
            </div>
        )
}

}

export default UserUpdateComponent