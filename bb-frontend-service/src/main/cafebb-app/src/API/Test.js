import axios from 'axios'
class Test
{
     execute(){
         //console.log("Executed")
         return axios.get('http://localhost:9999/testing')
     }   
     executeBean(){
        //console.log("Executed")
        return axios.get('http://localhost:9991/menu-bean')
    }

    executePath(name){
        //console.log("Executed")
        return axios.get(`http://localhost:9999/testing/path-var/${name}`)
    }

    executePathRole(name){
        //console.log("Executed")
        return axios.get(`http://localhost:9999/users/${name}/Test`)
    }
    

}

export default new Test()