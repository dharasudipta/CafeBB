import axios from 'axios'

class UserData{
    // executeGetAllMenu(name){
    //     //console.log("Executed")
    //     return axios.get(`http://localhost:9002/users/${name}/menus`)
    // }

    
    executeGetUserByPassword(username,password){
        //console.log("Executed")
        return axios.get(`http://localhost:9003/getUserByPassword/${username}/${password}`);
    }
    executeGetUserById(name,id){
        //console.log("Executed")
        return axios.get(`http://localhost:9003/getUser/${name}/${id}`);
    }
    executeGetAllUserDetailsExceptThis(name,id){
        //console.log("Executed")
        return axios.get(`http://localhost:9003/${name}/users/${id}`)
    }
    executeGetAllUserDetails(name){
        //console.log("Executed")
        return axios.get(`http://localhost:9003/${name}/users`)
    }
    executeGetValidityOfUser(name,password){
        //console.log("Executed")
        return axios.get(`http://localhost:9003/users/${name}/user/${password}`);
    }
    executeCreateUser(menu){
        //console.log("Executed")
        return axios.post(`http://localhost:9003/signup`,menu);
    }
    executeDeleteUser(username,id){
        //console.log("Executed")
        return axios.delete(`http://localhost:9003/deleteUser/${username}/user/${id}`);
    }
    executeUpdateUser(name,id,user){
        //console.log("Executed")
        return axios.put(`http://localhost:9003/usersUpdate/${name}/${id}`,user);
    }
    // executeGetIdCounter(){
    //     //console.log("Executed")
    //     return axios.get(`http://localhost:9002/getIdCounter`)
    // }
    // executeGetEnableStatus(username,id){
    //     //console.log("Executed")
    //     return axios.get(`http://localhost:9002/users/${username}/menus/${id}/getEnableStatus`)
    // }
    // executeCreateMenu(name,menu){
    //     //console.log("Executed")
    //     return axios.post(`http://localhost:9002/users/${name}/menus`,menu);
    // }
    // executeEnableStatus(name,id,menu){
    //     //console.log("Executed")
    //     return axios.put(`http://localhost:9002/users/${name}/menus/${id}`,menu);
    // }

}
 export default new UserData()