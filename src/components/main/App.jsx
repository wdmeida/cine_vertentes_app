import React from 'react'
import { 
  BrowserRouter as Router,
  Route 
} from 'react-router-dom'

import '../common/template/dependencies'

import CinePlaza from '../cines/CinePlaza'
import CineGloria from '../cines/CineGloria'
import Home from '../home/Home'
import NavBar from '../common/template/nav/NavBar'
import Footer from '../common/template/Footer'

export default props => (
  <Router>
    <div>
      <NavBar />
      <div className='container'>
        <Route exact path='/' component={Home} />      
        <Route path='/cineplaza' component={CinePlaza} />
        <Route path='/cinegloria' component={CineGloria} />
      </div>
    </div>
  </Router>
)