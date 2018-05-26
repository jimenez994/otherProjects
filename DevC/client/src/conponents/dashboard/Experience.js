import React, { Component } from 'react';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import Moment from 'react-moment';
import { deleteExperience } from '../../actions/profileActions';
class Experience extends Component {
  onDeleteClick(id){
    console.log(id)
    this.props.deleteExperience(id);
  }
  render() {
      const experience = this.props.experience.map(exp => (
        <tr key={exp.id}>
          <td>{exp.company}</td>
          <td>{exp.title}</td>
          <td>
            <Moment format="YYYY/MM/DD">{exp.startFrom}</Moment> - {" "}
            {exp.toEnd === null ? ('Now') : (
              <Moment format="YYYY/MM/DD">{exp.toEnd}</Moment>
            )}
          </td>
          <td>
            {" "}
            <button onClick={this.onDeleteClick.bind(this, exp.id)} className="btn btn-danger">Delete</button>
          </td>
        </tr>
      ));
    return (
      <div>
        <h4 className="mb-4">Experience Credentials</h4>
        <table className="table">
            <thead>
                <tr>
                  <th>Company</th>
                  <th>Title</th>
                  <th>Years</th>
                  <th></th> 
                </tr>               
                {experience}
            </thead>
        </table>
      </div>
    )
  }
}
Experience.propTypes = {
  deleteExperience: PropTypes.func.isRequired
}
export default  connect(null, {deleteExperience})(Experience);
