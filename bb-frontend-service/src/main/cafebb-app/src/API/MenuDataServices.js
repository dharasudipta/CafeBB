import axios from 'axios'

class MenuDataServices{
    executeGetAllMenu(name){
        //console.log("Executed")
        return axios.get(`http://localhost:9002/users/${name}/menus`)
    }
    executeGetMenu(name,id){
        //console.log("Executed")
        return axios.get(`http://localhost:9002/users/${name}/menus/${id}`)
    }
    executeGetIdCounter(){
        //console.log("Executed")
        return axios.get(`http://localhost:9002/getIdCounter`)
    }
    executeGetEnableStatus(username,id){
        //console.log("Executed")
        return axios.get(`http://localhost:9002/users/${username}/menus/${id}/getEnableStatus`)
    }
    executeCreateMenu(name,menu){
        //console.log("Executed")
        return axios.post(`http://localhost:9002/users/${name}/menus`,menu);
    }
    executeEnableStatus(name,id,menu){
        //console.log("Executed")
        return axios.put(`http://localhost:9002/users/${name}/menus/${id}`,menu);
    }

}
 export default new MenuDataServices()