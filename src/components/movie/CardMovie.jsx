import React from 'react'

import ReactPlayer from 'react-player'

import PropTypes from 'prop-types'
import { withStyles } from 'material-ui/styles'
import Card, { 
  CardActions,
  CardContent,
  CardMedia
 } from 'material-ui/Card'
import Button from 'material-ui/Button'
import Typography from 'material-ui/Typography'

import Grid from '../common/layout/grid'

const styles = {
  card: {
    maxWidth: 380,
    height: 450,
    marginBottom: 20
  },
  media: {
    height: 200,
    width: 120,
    margin: 15,
    float: 'right'
  },
  movieContent: {
    position: 'absolute',
    bottom: 0,
    marginBottom: 15 
  }
}

const CardMovie = props => {
  const classes = props.classes

  return (
    <Grid cols='12 6 4 4'>
      <Card className={classes.card}>
        <CardMedia
          className={classes.media}
          image={props.cover}
          title={props.name}
        />
        <CardContent>
          <Typography type='headline' component='h2'>
            {props.name}
          </Typography>
          <Typography component='p'>
            <strong>Gênero: </strong> {props.genre}
          </Typography>
          <Typography component='p'>
            <strong>Exibição: </strong> {props.exibition}
          </Typography>
          <Typography component='p'>
            <strong>Datas: </strong> {props.week_exibition} 
          </Typography>
          <Typography component='p'>
            <strong>Duração: </strong> {props.duration}
          </Typography>
          <Typography component='p'>
            <strong>Classificação: </strong> {props.classification}
          </Typography>              
        </CardContent>
        <CardContent className={classes.movieContent}>
          <Typography type='headline' component='h2'>
            Trailer:
          </Typography>
          <ReactPlayer 
            url={props.trailer} 
            controls 
            width='100%' 
            height='150px' 
          />          
        </CardContent>
      </Card>
    </Grid>
  )
}

CardMovie.propTypes = {
  classes: PropTypes.object.isRequired
}

export default withStyles(styles)(CardMovie)