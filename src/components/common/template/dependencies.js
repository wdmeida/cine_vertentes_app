import 'modules/jquery/dist/jquery.min.js'
import 'modules/bootstrap/dist/js/bootstrap.min.js'
import 'typeface-roboto'

import 'modules/bootstrap/dist/css/bootstrap.min.css'
import 'modules/font-awesome/css/font-awesome.min.css'

import './custom.scss'

// Close the navbar mobile after user click.
$(document).on('click','.navbar-collapse.in',function(e) {
  if( $(e.target).is('a') && $(e.target).attr('class') != 'dropdown-toggle' ) {
      $(this).collapse('hide');
  }
});
