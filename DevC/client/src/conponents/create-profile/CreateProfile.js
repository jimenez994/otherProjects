import React, { Component } from 'react';
import { connect } from "react-redux";
import PropTypes from 'prop-types';

class CreateProfile extends Component {
    constructor(props){
        super(prop);
        this.state = { 
            displaySocialInputs: false,
            handle:'',
            
        }
    }
  render() {
    return (
      <div>
        
      </div>
    )
  }
}
export default  connect(null)(CreateProfile);
