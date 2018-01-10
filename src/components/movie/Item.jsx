import React from 'react'
import PropTypes from 'prop-types'

import Typography from 'material-ui/Typography'
import { withStyles } from 'material-ui/styles'
import 'typeface-roboto'

import Grid from '../common/layout/grid'
import Row from '../common/layout/row'

const styles = {
  divStyle: {
    marginTop: 10,
    marginBottom: 10
  }
}

const Item = props => { 
  const classes = props.classes

  return (
    <div className={classes.divStyle}>
      <Row>
        <Grid cols='6 4 4 3'>
          <Typography gutterBottom>
            <strong>{props.title}</strong>
          </Typography>
        </Grid>
        <Grid cols='6 8 8 9'>
          <Typography gutterBottom>
          {props.description}
          </Typography>
        </Grid>
      </Row>
    </div>
  )
}

Item.propTypes = {
  classes: PropTypes.object.isRequired
}

export default withStyles(styles)(Item)

