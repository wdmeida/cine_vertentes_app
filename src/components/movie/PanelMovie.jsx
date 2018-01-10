import React from 'react'
import ReactPlayer from 'react-player'

import Divider from 'material-ui/Divider'
import Item from './Item'

import Grid from '../common/layout/grid'

export default props => (
  <div className='panel panel-default'>
    <div className='panel-heading'>
      <h3 className='panel-title'>
        <strong>{props.name}</strong>
      </h3>
    </div>
    <div className='panel-body'>
      <Grid cols='12 3 2'>
        <div className='thumbnail'>
          <img src={props.cover} alt={props.name}/>
        </div>
      </Grid>
      <Grid cols='12 5 6'>
        <Item title='Gênero:' description={props.genre}/>
        <Divider />
        <Item title='Exibição:' description={props.exibition}/>
        <Divider />
        <Item title='Datas:' description={props.week_exibition}/>
        <Divider />
        <Item title='Duração:' description={props.duration}/>
        <Divider />
        <Item title='Classificação:' description={props.classification}/>
      </Grid>
      <Grid cols='12 4 4'>
        <ReactPlayer url={props.trailer} controls width='100%' height='230px' className='embed-responsive-item' />
      </Grid>
    </div>
  </div>
)