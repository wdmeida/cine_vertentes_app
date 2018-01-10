import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import ReactLoading from 'react-loading'

import Row from '../common/layout/row'
import PanelMovie from './PanelMovie'

import CardMovie from './CardMovie'

import { getMovies } from './movieActions'

import { withRouter } from 'react-router-dom'

import './movieListCustom.scss'

class MovieList extends Component {
  
  constructor(props) {
    super(props)
  }

  componentWillMount() {
    this.props.getMovies(this.props.cine)
  }

  renderRows() {
    const list = this.props.list || []

    return list.map((movie, index) => (
        <CardMovie
          key={index}
          {...movie}
        />
    ))
  }

  render() {
     if (!this.props.loadData) {
       return <ReactLoading type='cylon' color='#FFF' />
     } 
    return (
      <div>
        {this.renderRows()}
      </div>
      )
  }
}

const mapStateToProps = state => ({ list: state.movie.list, loadData: state.movie.loadData })
const mapDispatchToProps = (dispatch) => bindActionCreators({
  getMovies
}, dispatch)

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(MovieList))