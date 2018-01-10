import React from 'react'

import Header from '../common/template/Header'
import MovieList from './MovieList'

export default props => (
  <div>
    <Header name={props.name} small={props.small} />
    <MovieList cine={props.cine} />
  </div>
)