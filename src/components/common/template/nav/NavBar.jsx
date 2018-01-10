import React, { Component } from 'react'

import { NavLink } from 'react-router-dom'

export default props => (
  <nav className='navbar navbar-inverse'>
    <div className='container-fluid'>
      <div className='navbar-header'>
        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-cine" aria-expanded="false">
          <span className="sr-only">Toggle navigation</span>
          <span className="icon-bar"></span>
          <span className="icon-bar"></span>
          <span className="icon-bar"></span>
        </button>
        <NavLink to='/' className='navbar-brand'>
          <i className='fa fa-film'></i> CineVertentes
        </NavLink>
      </div>

      <div id="navbar-cine" className='collapse navbar-collapse'>
        <ul className='nav navbar-nav'>
          <li>
            <NavLink to="/">Início</NavLink>
          </li>
          <li>
            <NavLink to="/cinegloria">Cine Glória</NavLink>
          </li>
<<<<<<< HEAD
=======
          <li>
            <NavLink to="/cineplaza">Cine Plaza</NavLink>          
          </li>
>>>>>>> 5ce2e53426b8791847e0e3a281b751e0434d61d1
        </ul>
      </div>
    </div>
  </nav>
)