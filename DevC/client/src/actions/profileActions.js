import axios from 'axios';

import { GET_PROFILE, PROFILE_LOADING, GET_ERRORS, CLEAR_CURRENT_PROFILE } from './types';

// get current profile
export const getCurrentProfile = () => dispatch => {
    dispatch(setProfileLoading());
    var IdKey = null
    if(localStorage.IdKey){
        IdKey = localStorage.IdKey;
        console.count(IdKey+"****************");
    }
    axios.get(`http://localhost:8080/p/portfolio/${IdKey}`)
        .then( res => {
                console.log(res + "*********1");
            
            if(res.data.noProfile){
                console.log(res.data + "*********2");
                
                console.log(res.data.noProfile + "*********2");
                dispatch({
                    type: GET_ERRORS,
                    payload: {}
                });
            }else{
                dispatch({
                    type: GET_PROFILE,
                    payload: res.data
                })
            }
        })
        .catch(err => console.log(err))
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