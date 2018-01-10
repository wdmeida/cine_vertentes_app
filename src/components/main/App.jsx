import React from 'react'
import { 
  BrowserRouter as Router,
  Route 
} from 'react-router-dom'

import '../common/template/dependencies'

<<<<<<< HEAD
=======
import CinePlaza from '../cines/CinePlaza'
>>>>>>> 5ce2e53426b8791847e0e3a281b751e0434d61d1
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
        <Route path='/cinegloria' component={CineGloria} />
      </div>
    </div>
  </Router>
)