import React, { Component } from "react";
import axios from "axios";
import classnames from 'classnames';
export default class Register extends Component {
    constructor(){
        super();
        this.state ={
            name: '',
            email: '',
            password: '', 
            errors: {}
        }
        // this binds the from with on chenge in order to use this keyword onChange
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);        
    }
    onChange(e){
        // based on the name of the filds it will update the state name:name, email:eamil, password:password
        this.setState({[e.target.name]:e.target.value});
    }
    onSubmit(e){
        // this takes out the default dehaviour
        e.preventDefault();
        const newUser = {
            name: this.state.name,
            email: this.state.email,
            password: this.state.password
        }
        axios
          .post("http://localhost:8080/user/register", newUser)
          .then(res => {
              if(res.data.success){
                console.log(res.data.success)
            }else{
                this.setState({errors: res.data})
                console.log(this.state.errors)
            }
          })
          .catch(err => console.log(err));
        console.log(newUser)
    }
    render() {
        // this is the same as const errors = this.state.errors
        const { errors } = this.state;
        return (
            <div className="register">
                <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                    <h1 className="display-4 text-center">Sign Up</h1>
                    <p className="lead text-center">Create your DevConnector account</p>
                    <form onSubmit={this.onSubmit}>

                        <div className="form-group">
                        {/* using classname allows to add logic to the inputs if invalid */}
                        <input 
                            type="text" 
                            className={classnames('form-control form-control-lg',{
                            'is-invalid': errors.name
                        })} 
                        placeholder="Name" 
                        name="name" 
                        value={this.state.name} 
                        onChange={this.onChange}/>
                        {/* this shows the error message */}
                        {errors.name && (
                            <div className="invalid-feedback">{errors.name}</div>
                            )}
                        </div>

                        <div className="form-group">
                        <input 
                            type="text" 
                            className={classnames('form-control form-control-lg',{
                                'is-invalid': errors.email
                            })} 
                            placeholder="Email Address" 
                            name="email" 
                            value={this.state.email} 
                            onChange={this.onChange}/>
                            {errors.email && (
                                <div className="invalid-feedback">{errors.email}</div>
                            )}
                        </div>

                        <div className="form-group">
                        <input 
                            type="password" 
                            className={classnames('form-control form-control-lg', {
                                'is-invalid': errors.password
                            })} 
                            placeholder="Password" 
                            name="password" 
                            value={this.state.password} 
                            onChange={this.onChange}/>
                            {errors.password && (
                                <div className="invalid-feedback">{errors.password}</div>
                            )}
                        </div>
                        <input type="submit" className="btn btn-info btn-block mt-4" />
                    </form>
                    </div>
                </div>
                </div>
            </div>
        );
    }
}
