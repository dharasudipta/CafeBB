import React, {Component} from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import MenuDataServices from '../API/MenuDataServices.js';
import Authentication from './Authentication.js'
import { MDBCol, MDBFormInline, MDBIcon } from 'mdbreact';
import axios from 'axios';


class MenuComponent extends Component{
    
    constructor(props) {
        super(props);
        
        this.state = {
            onclickValue: false,
            searchInput : '',
            newMenuAddButton : '',
            selectedFile: null,
            menuList :
            [

            ]

        };
        
        this.addmenu = this.addmenu.bind(this)
        this.enableMenu = this.enableMenu.bind(this)
        this.SubmitMenu = this.SubmitMenu.bind(this)
        this.plusOrder = this.plusOrder.bind(this)
        this.changeEnableMenu = this.changeEnableMenu.bind(this)
        this.validate = this.validate.bind(this)
        this.renderDivs = this.renderDivs.bind(this)
        this.search = this.search.bind(this)
        this.fileSelectHandler=this.fileSelectHandler.bind(this)
        this.fileUploadHandler=this.fileUploadHandler.bind(this)
    }
    
    // Oder taking plus button
    plusOrder(id){
        console.log(id)

    } 

    // hide/show New menu adding Plus button
    addmenu()
    {
        
        if(this.state.onclickValue)
            this.setState({onclickValue: false})
        else
            this.setState({onclickValue: true})
        
    }

    

    //Menu enable/disable setup
    changeEnableMenu(result,id){
        if(result)
            {
            MenuDataServices.executeEnableStatus(id,{status : false})
            document.getElementById(id).style.opacity="0.4"
            }
            else
            {
                MenuDataServices.executeEnableStatus(id,{status : true})
                document.getElementById(id).style.opacity="1"
            }
            this.componentDidMount()
    }

    // Menu enable/disable
    enableMenu(id)
    {
        
        MenuDataServices.executeGetEnableStatus(id)
        .then(result=>this.changeEnableMenu(result.data,id))
        
    }

    // New Menu adding form validate
    validate(values)
    {
        let error={}
        if(!values.menuName){
            error.menuName="Enter Menu Name"
        }
        else if(!values.menuPrice){
            error.menuPrice="Enter Menu Price"
        }
        else if(isNaN(values.menuPrice)){
            error.menuPrice="Enter Menu Price Properly"
        }

        return error
    }

    //New Menu adding form submit
    SubmitMenu(values)
   {
       MenuDataServices.executeCreateMenu({ 
           menuName: values.menuName,
           menuPrice: values.menuPrice,
           status : true
           })
       this.componentDidMount()
       this.addmenu()
    }
    
    //Menu bar search
    search(event){
        this.setState({searchInput : event.target.value})
    }

    fileSelectHandler(event){
        //console.log(event.target.files[0])
        this.setState({
            selectedFile : event.target.files[0]
        })
            
        
    }

    fileUploadHandler(){
        const fd=new FormData()
        fd.append("image",this.state.selectedFile,this.state.selectedFile.name)
        axios.post('URL',fd,{
            uploadProgress : ProgressEvent =>{
                console.log('Progress : '+Math.round(ProgressEvent.loaded/ProgressEvent.total *100+'%'))
            }
        })
            .then(response=>{console.log(response)})
    }

    componentDidMount(){
        MenuDataServices.executeGetAllMenu() 
         .then(res => this.setState({menuList:res.data}))
         
         if(Authentication.LoggedInUserRole()==="ADMIN" || Authentication.LoggedInUserRole()==="Manager" )
           this.setState({newMenuAddButton : true})
        }

renderDivs(){
        let MenuList = this.state.menuList.filter(
          (response)=> {
              return response.menuName.toLowerCase().indexOf(this.state.searchInput) !== -1;
          }
      )
      const userDetailsHeader=(Authentication.IsRoleAdmin() || Authentication.IsRoleManager());
      let  uiItems = [];
         uiItems.push(
            MenuList.map(
              Mlist =>
              
          
      <div  className='addedmenu'  key={Mlist.menuId} id ={Mlist.menuId} style ={{opacity : Mlist.status ? "1" : "0.4" }} >
      <h3 style={{ height : '20px'}} >{Mlist.menuName} {Mlist.enable && <button className='menuPlus' onClick={()=>{this.plusOrder(Mlist.menuId)}}>+</button>} </h3>
      <hr className='menuline'/><br/>
      
      <h6 style={{display : 'inline-flex'}}> Rs. {Mlist.menuPrice}</h6>
      <label className="switch"  >
      {userDetailsHeader &&<input type="checkbox" defaultChecked={!Mlist.status}  onChange={() => { this.enableMenu(Mlist.menuId); }} ></input>}
      {userDetailsHeader && <span className="slider round"></span>}
          </label>
      </div>
          )
      )
      return uiItems;
  }

    render() {
        
        return (
            <div > 
                <div> <h2>Items</h2></div>

               {/* Search Bar */ }

                <div>
                    <MDBCol md="8" style={{ marginLeft: "275px" }}>
                        <MDBFormInline className="md-form">
                            <MDBIcon icon="search" className="fa fa-search" aria-hidden="true" />
                            <input className="form-control form-control-sm ml-3 w-75" type="text" onChange={this.search} placeholder="Search" aria-label="Search" />
                        </MDBFormInline>
                    </MDBCol>
                </div>

                    <br /><br />
            
                {/* Plus button and Add menu form */ }
                {this.state.newMenuAddButton && <button className='menu' onClick={this.addmenu} onChange={this.forceUpdate} > <h4>+</h4> </button>}
            {/* <div style={{display:"flex",flexDirection: "rowC"}}> */}
                <div className='addmenu'  >
                    {this.state.onclickValue &&

                        <Formik initialValues={{ menuName: '', menuPrice: '' }}
                            onSubmit={this.SubmitMenu}
                            validateOnChange={false}
                            validateOnBlur={false}
                            validate={this.validate}
                            enableReinitialization={true}
                        >
                            {
                                (props) => (
                                    <Form >
                                        <ErrorMessage name="menuName" component="div" className="alert alert-warning" />
                                        <ErrorMessage name="menuPrice" component="div" className="alert alert-warning" />


                                        <fieldset >
                                            <label><strong>Menu Name: </strong></label>
                                            <Field type="text" name="menuName" placeholder="Menu Name" />
                                        </fieldset>
                                        <fieldset>
                                            <label><strong>Menu price:</strong></label>
                                            <Field type="text" name="menuPrice" placeholder="Menu Price" ></Field>
                                        </fieldset>
                                        <fieldset>
                                            <label><strong>Upload Image : </strong></label>
                                            <input type="file" onChange={this.fileSelectHandler}/><br/>
                                            <button onClick={this.fileUploadHandler}>Upload</button>
                                        </fieldset>
                                        <button className="btn btn-success" type="submit" style={{ marginTop: "20px" }}>Submit</button>
                                    </Form>
                                )
                            }
                        </Formik>


                    }


                </div>

                {/* Menu */ }
            
                        <div >{this.renderDivs()}</div>
                        {/* <div style={{position:"relative", marginLeft : "500px",border:"1px solid black"}}><h1>Test</h1></div> 
            </div>*/}
        </div>


        )
    }

    

}
export default MenuComponent