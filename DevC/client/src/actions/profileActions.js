import axios from 'axios';

import { GET_PROFILE, PROFILE_LOADING, GET_ERRORS } from './types';

// get current profile
export const getCurrentProfile = () => dispatch => {
    dispatch(setProfileLoading());
    axios.get("http://localhost:8080/p/portfolio")
        .then( res => {
            if(res.data.noProfile){
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
}

// profile loading 
export const setProfileLoading = () => {
    return{
        type: PROFILE_LOADING
    }
}