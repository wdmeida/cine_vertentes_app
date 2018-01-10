import { combineReducers } from 'redux'
import movieReducer from '../movie/movieReducer'

const rootReducer = combineReducers({
  movie: movieReducer
})

export default rootReducer