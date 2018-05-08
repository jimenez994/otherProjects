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

import setAuthToken from './utils/setAuthToken';
import { setCurrentUser } from './actions/authActions';

// this to check if user is in session
// chaeck for tokem
if(localStorage.IdKey){
  // set auth token header auth
  setAuthToken(localStorage.IdKey);
  // get user info
  // set user and isAithenticated
  store.dispatch(setCurrentUser(localStorage.IdKey))
}

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
