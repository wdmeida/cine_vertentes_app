const webpack = require('webpack')
const ExtractTextPlugin = require('extract-text-webpack-plugin')
const UglifyJSPlugin = require('uglifyjs-webpack-plugin')

module.exports = {
  entry: './src/index.jsx',
  output: {
    path: __dirname + '/public',
    filename: './bundle.js'
  },
  devServer: {
    port: 4200,
    contentBase: './public',
    overlay: {
      errors: true,
      warnings: true
    }
  },
  resolve: {
    extensions: ['.js', '.jsx'],
    alias: {
      modules: __dirname + '/node_modules',
      bootstrap: 'modules/bootstrap/dist/js/bootstrap.min.js',
      jquery: 'modules/jquery/dist/jquery.min.js'
    }
  },
  module: {
    rules: [
      {
        test: /.js[x]?$/,
        exclude: /node_modules/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: [
                'es2015',
                'react'
              ],
              plugins: [
                'transform-object-rest-spread'
              ]
            }
          }
        ]
      }, {
        test: /\.s[ac]ss|.css$/,
        use: ExtractTextPlugin.extract({
          use: [
            { loader: 'css-loader' }, 
            { loader: 'sass-loader' }
          ],
          fallback: 'style-loader'
        })
      }, {
        test: /\.(jpe?g|png|gif|svg)/,
        use: [
          {
            loader: 'url-loader',
            query: {
              limit: 5000,
              name: '[name].[hash:8].[ext]'
            }
          }, {
            loader: 'image-webpack-loader',
            query: {
              mozjpeg: {
                quality: 65
              }
            }
          }
        ]
      }, {
        test: /\.woff|.woff2|.ttf|.eot|.svg*.*$/,
        use: [
          {
            loader: 'file-loader'
          }
        ]
      }
    ]
  },
  plugins: [
    new ExtractTextPlugin('styles.css'),
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery'
    }),
    new UglifyJSPlugin({
      test: /\.js[x]$/i,
      exclude: /node_modules/,
      sourceMap :true
    })
  ]
}