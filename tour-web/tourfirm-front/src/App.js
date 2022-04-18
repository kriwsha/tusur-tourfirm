import React, {Component} from "react";
import { Route, Routes } from "react-router-dom"
import './App.css';
import Tours from './pages/tours'
import Login from './pages/login'

class App extends Component {
  render() {

    return (
        <div className="App">
            <Routes>
                <Route path='/home' element={ <Tours /> } />
                <Route path='/login' element={ <Login /> } />
            </Routes>
        </div>
    );
  }
}

export default App;
