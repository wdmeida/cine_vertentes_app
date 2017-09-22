import { 
  GET_MOVIES,
  SET_EMPTY_LIST 
} from './types'

const INITIAL_STATE = { list: [], loadData: false }

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case GET_MOVIES:
      return { ...state, list: action.payload.data.movies, loadData: true }
    case SET_EMPTY_LIST:
      return { ...state, list: [], loadData: false }
    default:
      return state
  }
}