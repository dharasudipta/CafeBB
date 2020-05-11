import React,{Component} from 'react';
import UserService from './components/UserService.jsx'
import './App.css';
import './bootstrap.css';


class App extends Component {
  render(){
    return(
        <div className="App">
        <UserService/>
        </div>
        
      );
  }
}



export default App;
