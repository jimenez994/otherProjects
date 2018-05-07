import React, { Component } from 'react';
import { BrowserRouter as Router, Route} from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './store';
// layout
import Navbar from "./conponents/layout/Navbar";
import Footer from "./conponents/layout/Footer";
import Landing from "./conponents/layout/Landing";
// auth 
import Register from "./conponents/auth/Register";
import Login from "./conponents/auth/Login";
import './App.css';

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Navbar/>
            <Route exact path="/" component={Landing}/>
            <div className="container">
              <Route exact path="/register" component={Register}/>
              <Route exact path="/login" component={Login}/>
            </div>
            <Footer/>
          </div>
        </Router>
      </Provider>      
    );
  }
}

export default App;
