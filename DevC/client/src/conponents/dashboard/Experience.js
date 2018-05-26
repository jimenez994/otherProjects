import React, { Component } from 'react';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import { withRouter } from 'react-router-dom';

class Experience extends Component {
  render() {
      const experience = this.props.experience.map(exp => (
        <tr key={exp.id}>
            <td>{exp.company}</td>
            <td>{exp.title}</td>
            <td>{exp.startFrom} - {exp.toEnd}</td>
            <td> <button className="btn btn-danger">Delete</button></td>
        </tr>
      ));
      console.log(this.props.experience)
    return (
      <div>
        <h4 className="mb-4">Experience Credentials</h4>
        <table className="table">
            <thead>
                <tr>Company</tr>
                <tr>Title</tr>
                <tr>Years</tr>
                <tr></tr>                
            </thead>
            <tbody>
                {experience}
            </tbody>
        </table>
      </div>
    )
  }
}
export default  connect(null)(withRouter(Experience));
