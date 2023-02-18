import axios from 'axios'

///user
class UserData {
    // executeGetAllMenu(name){
    //     //console.log("Executed")
    //     return axios.get('http://localhost:9002/users/${name}/menus')
    // }


    executeGetUserByPassword(username, password) {
        //console.log("Executed")
        return axios.get(`http://localhost:9003/user/getUserByPassword/${username}/${password}`);
    }

    executeGetUserById(name, id) {
        console.log("Calling executeGetUserById");
        console.log("name:"+name);
        console.log("id:"+id);
        return axios.get(`http://localhost:9003/user/getUser/${name}/${id}`);
    }

    executeGetAllUserDetailsExceptThis(name, id) {
        //console.log("Executed")
        return axios.get(`http://localhost:9003/user/${name}/users/${id}`)
    }

    executeGetAllUserDetails() {
        //console.log("Executed")
        return axios.get('http://localhost:9003/user/users')
    }

    executeGetValidityOfUser(user) {
        //console.log("Executed")
        return axios.post('http://localhost:9003/user/authUsers', user);
    }

    executeCreateUser(user) {
        //console.log("Executed")
        return axios.post('http://localhost:9003/user/signup', user);
    }

    executeDeleteUser(username, id) {
        //console.log("Executed")
        return axios.delete(`http://localhost:9003/user/deleteUser/${username}/user/${id}`);
    }

    executeUpdateUser(name, id, user) {
        //console.log("Executed")
        return axios.put(`http://localhost:9003/user/usersUpdate/${name}/${id}`, user);
    }

    // executeGetIdCounter(){
    //     //console.log("Executed")
    //     return axios.get('http://localhost:9002/getIdCounter')
    // }
    // executeGetEnableStatus(username,id){
    //     //console.log("Executed")
    //     return axios.get('http://localhost:9002/users/${username}/menus/${id}/getEnableStatus')
    // }
    // executeCreateMenu(name,menu){
    //     //console.log("Executed")
    //     return axios.post('http://localhost:9002/users/${name}/menus',menu);
    // }
    // executeEnableStatus(name,id,menu){
    //     //console.log("Executed")
    //     return axios.put('http://localhost:9002/users/${name}/menus/${id}',menu);
    // }

}

export default new UserData()