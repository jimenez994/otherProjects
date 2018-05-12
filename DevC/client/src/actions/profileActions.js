import axios from 'axios';

import { GET_PROFILE, PROFILE_LOADING, GET_ERRORS, CLEAR_CURRENT_PROFILE } from './types';
var IdKey = null;
// get current profile
export const getCurrentProfile = () => dispatch => {
    dispatch(setProfileLoading());
    if(localStorage.IdKey){
        IdKey = localStorage.IdKey;
        axios.get(`http://localhost:8080/p/portfolio/${IdKey}`)
            .then( res => {
                if(res.data.success){
                    dispatch({
                    type: GET_PROFILE,
                    payload: res.data
                    });
                }else if(res.data.noProfile){
                    dispatch({
                        type: GET_PROFILE,
                        payload: {}
                    });
                }else{
                    dispatch({
                        type: GET_ERRORS,
                        payload: null
                    }); 
                }
            })
            .catch(err => console.log(err))
    }
}
// Create Profile
export const createProfile = (profileData, history) => dispatch => {
    if(localStorage.IdKey){
        IdKey = localStorage.IdKey;
         axios.post(`http://localhost:8080/p/new/${IdKey}`, profileData)
            .then(res => {
                if(res.data.success){
                    history.push("/dashboard");
                }else{
                    dispatch({
                        type: GET_ERRORS,
                        payload: res.data
                    }); 
                }
            })
            .catch(err => console.log(err))
    }
}
   

// profile loading 
export const setProfileLoading = () => {
    return{
        type: PROFILE_LOADING
    }
}
// profile clear 
export const clearCurrentProfile = () => {
    return{
        type: CLEAR_CURRENT_PROFILE
    }
}