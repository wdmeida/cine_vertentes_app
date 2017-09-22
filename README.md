# Cine Vertentes PWA

## Projeto

App desenvolvido para listar os filmes em cartas nos cinemas da região dos Campos das Vertentes, na zona da mata de Minas Gerais. O app, lista os filmes em cartaz no [Cine Plaza](https://www.cineplaza.com.br) e [Cine Glória](http://www.cinegloria.com) localizados nas respectivas cidades de Barbacena e São João Del Rey.

O app é um PWA, o que possibilita que o mesmo possa ser instalado em dispositivos móveis e atualmente encontra-se em fase de modificação do layout e adaptação para que possa funcionar completamente offline.

O mesmo pode ser acessado através do link abaixo:

* [Cine Vertentes PWA](http://cine-vertentes-app.firebaseapp.com/) 

## API

O app consome as informações obtidas em uma API desenvolvida em Node JS, através das seguintes URLs:

* [Cine Gloria](https://cinevertentes.herokuapp.com/api/v1/cinegloria/movies)
* [Cine Plaza](https://cinevertentes.herokuapp.com/api/v1/cineplaza/movies)

## APP

O app foi desenvolvido utilizando as seguintes tecnologias:

* [React](https://facebook.github.io/react/)
* [Redux](http://redux.js.org/)
* [Webpack](https://webpack.github.io)
* [Material-UI](https://material-ui-1dab0.firebaseapp.com/)
* [Bootstrap](http://getbootstrap.com/)

## Executando o Projeto

Entre no diretório do app, cine-vertentes-app e instale as dependências:

```$ npm install```

Após intalar as dependências, execute a aplicação com o seguinte comando:

```$ npm run dev```

Abra o navegador, e acesse ```http://localhost:4200``` para abrir a aplicação.
