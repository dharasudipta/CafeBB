import React, { Component } from 'react'
import Authentication from './Authentication.js'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import UserData from '../API/UserData.js'

class SignupComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            values:'',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.signUpClicked = this.signUpClicked.bind(this)
        this.validate = this.validate.bind(this)
    }

    signUpClicked(values) {
        Authentication.RequestInterceptor()
        UserData.executeCreateUser({ 
            fullName:values.fullName,
            contactNumber :values.mobile,
            userName: values.username,
            password: values.password,
            role :values.role,
            storeId:"test1",
            employeeId:"test2"
            })
            this.props.history.push(`/login`)
       
    }
    validate(values)
    {
        let error={}
        if(!values.fullName){
            error.fullName="Enter Full Name"
        }
        else if(!values.mobile){
            error.mobile="Enter Mobile No."
        }
        else if(!values.username){
            error.username="Enter Username"
        }
        else if(!values.password){
            error.password="Enter Password"
        }
        else if(!values.role ){
            error.role="Enter Role "
        }
        else if(values.role!=="ADMIN" && values.role!=="STAFF" && values.role!=="MANAGER" ){
            error.role="Enter Valid Role "
        }
        return error
        
    }
    
    render() {
       return(
           <div>
               <h1>Sign Up</h1>
               <div>
                   <Formik 
                   initialValues={{ fullName:'',mobile :'',username: '',password: '',role :'',storeId:'',employeeId:''}}
                   onSubmit={this.signUpClicked}
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
                                   <ErrorMessage name="username" component="div" className="alert alert-warning" />
                                   <ErrorMessage name="password" component="div" className="alert alert-warning" />
                                   <ErrorMessage name="role" component="div" className="alert alert-warning" />
                                   {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                                   
                                   <fieldset >
                                       <label><strong>Full Name: </strong></label>
                                       <Field type="text" name="fullName" placeholder="Full Name" />
                                   </fieldset>
                                   <fieldset>
                                       <label><strong>Mobile No.:</strong></label>
                                       <Field type="text" name="mobile" placeholder="Mobile Number" ></Field>
                                   </fieldset>
                                   <fieldset >
                                       <label><strong> User Name: </strong></label>
                                       <Field type="text" name="username" placeholder="Username" />
                                   </fieldset>
                                   <fieldset>
                                       <label><strong>Password:</strong></label>
                                       <Field type="password" name="password" placeholder="Password" ></Field>
                                   </fieldset>
                                   <fieldset>
                                   <label><strong>Role:</strong></label>
                                   <Field type="text" name="role" placeholder="Role"/>
                                   </fieldset>
                                   <button className="btn btn-success" type="submit">SignUp</button>
                               </Form>
                           )
                       }

                   </Formik><br/><br/>
                   <div className="alert alert-warning">*NOTE :Type "Admin" or "Manager" or "Staff" in the field of Role</div>
               </div>
           </div>
       )
    }
}

export default SignupComponent