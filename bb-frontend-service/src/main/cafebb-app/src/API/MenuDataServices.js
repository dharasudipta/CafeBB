import axios from 'axios'

class MenuDataServices{
    executeGetAllMenu(){
        //console.log("Executed")
        return axios.get(`http://localhost:9991/menu/menus`)
    }
    executeGetMenu(id){
        //console.log("Executed")
        return axios.get(`http://localhost:9991/menu/menuById/${id}`)
    }
    // executeGetIdCounter(){
    //     //console.log("Executed")
    //     return axios.get(`http://localhost:9991/getIdCounter`)
    // }

    executeGetEnableStatus(id){
        //console.log("Executed")
        return axios.get(`http://localhost:9991/menu/getEnableStatus/${id}`)
    }
    executeCreateMenu(menu){
        //console.log("Executed")
        return axios.post(`http://localhost:9991/menu/createMenu`,menu);
    }
    executeEnableStatus(id,menu){
        //console.log("Executed")
        return axios.put(`http://localhost:9991/menu/updateMenu/${id}`,menu);
    }

}
 export default new MenuDataServices()
 