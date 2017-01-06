package activities.cineplaza.ifsudestemg.br.cineplazaapp.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.dao.MovieDAO;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.model.Movie;

/**
 * Created by wagner on 07/09/16.
 */
public class ProcessResponseJSON {
    private String respost;
    private String weekProgramation;
    private List<Movie> movies;

    public ProcessResponseJSON(String respost) {
        this.respost = respost;
    }

    //Verifica se a resposta o código da resposta.
    public boolean isValidRespost(){
        try {
            JSONObject json = new JSONObject(this.respost);
            int cod = json.getInt("cod");
            this.weekProgramation = json.getString("week");
            return ((cod == 200) ? true : false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }//isValidRespost

    //Obtém todas as informações dos filmes recebidas na consulta.
    public List<Movie> getAllMovies(){
        try {
            JSONObject json = new JSONObject(this.respost);
            this.movies = new ArrayList<>();
            JSONArray jsonMovies = json.getJSONArray("movies");
            for(int position = 0; position < jsonMovies.length(); position++){
                JSONObject j = jsonMovies.getJSONObject(position);
                Movie movie = writeInfoMovie(j);
                this.movies.add(movie);
            }
            return movies;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Salva as informações do filme em um objeto.
    private Movie writeInfoMovie(JSONObject json) throws JSONException{
        Movie movie = new Movie();
        movie.setName(json.getString("name"));
        movie.setCover(json.getString("cover"));
        movie.setTrailer(json.getString("trailer"));
        movie.setGenre(json.getString("genre"));
        movie.setClassification(json.getString("classification"));
        movie.setDuration(json.getString("duration"));
        movie.setExibition(json.getString("exibition"));
        movie.setWeek(weekProgramation);
        return movie;
    }

    public String getWeekProgramation() {
        return weekProgramation;
    }

}//class ProcessResponseJSON
