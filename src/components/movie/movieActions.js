import axios from 'axios'

import {
  GET_MOVIES,
  SET_EMPTY_LIST
} from './types'

const URL = 'https://cinevertentes.herokuapp.com/api/v1'

export function getMovies(cine) {
  return dispatch => {
    dispatch({ type: SET_EMPTY_LIST })
    const request = axios.get(`${URL}/${cine}/movies`)
    dispatch({ type: GET_MOVIES, payload: request }) 
  }
}