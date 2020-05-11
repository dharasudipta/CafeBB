import axios from 'axios'
class Authentication {
    successfullyLoggedIn(id,fullName,mobile,username,password,role){
            sessionStorage.setItem('authenticatedUserId',id)   
            sessionStorage.setItem('authenticatedUserFullName',fullName)
           sessionStorage.setItem('authenticatedUserMobile',mobile)
            sessionStorage.setItem('authenticatedUser',username)
            sessionStorage.setItem('authenticatedUserPassword',password)
           sessionStorage.setItem('authenticatedUserRole',role)
             this.RequestInterceptor()
    }
    LoggedInUserId(){
      let x = sessionStorage.getItem('authenticatedUserId')
      if(x===null)
       return null
     return x
   }
    LoggedInUserFullName(){
      let x = sessionStorage.getItem('authenticatedUserFullName')
      if(x==null)
       return ''
     return x
   }
   
   LoggedInUserMobile(){
    let x = sessionStorage.getItem('authenticatedUserMobile')
    if(x==null)
     return ''
   return x
 }

 LoggedInUserName(){
  let x = sessionStorage.getItem('authenticatedUser')
  if(x==null)
   return ''
 return x
}
LoggedInUserPassword(){
  let x = sessionStorage.getItem('authenticatedUserPassword')
  if(x==null)
   return ''
 return x
}

LoggedInUserRole(){
  let x = sessionStorage.getItem('authenticatedUserRole')
  if(x==null)
   return ''
 return x
}
IsRoleAdmin(){
  let x = sessionStorage.getItem('authenticatedUserRole')
  if(x==="Admin")
   return true
 return false
}
IsRoleManager(){
  let x = sessionStorage.getItem('authenticatedUserRole')
  if(x==="Manager")
   return true
 return false
}

  logout(){
        sessionStorage.removeItem('authenticatedUserFullName')
        sessionStorage.removeItem('authenticatedUserMobile')
        sessionStorage.removeItem('authenticatedUser')
        sessionStorage.removeItem('authenticatedUserPassword')
        sessionStorage.removeItem('authenticatedUserRole')
    }

    isLoggedIn(){
       let x = sessionStorage.getItem('authenticatedUser')
       if(x==null)
        return false
      return true
    }

   getbasicauthHeader(){
    let username = "cafeproject"
    let password = "cafe"
    return "Basic " + window.btoa(username + ":" + password)
}

   RequestInterceptor(){
     axios.interceptors.request.use(
       (config)=>{
         //if(this.isLoggedIn()){
          config.headers.authorization=this.getbasicauthHeader()
         //}
         return config
       }
      )
   }
}

export default new Authentication()