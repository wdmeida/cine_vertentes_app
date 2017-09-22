import React from 'react'

export default props => (
  <header className='page-header'>
    <h2><strong>{props.name}</strong> <small>{props.small}</small> </h2>
  </header>
)