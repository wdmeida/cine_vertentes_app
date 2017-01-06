package activities.cineplaza.ifsudestemg.br.cineplazaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.model.Movie;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.persistence.CreateDatabase;

/**
 * Created by wagner on 08/09/16.
 */
public class MovieDAO {
    private SQLiteDatabase sqLiteDatabase;
    private CreateDatabase database;
    private String[] columns = {CreateDatabase.COLUMN_ID,
                                CreateDatabase.COLUMN_NAME,
                                CreateDatabase.COLUMN_GENRE,
                                CreateDatabase.COLUMN_TRAILER,
                                CreateDatabase.COLUMN_WEEK,
                                CreateDatabase.COLUMN_COVER,
                                CreateDatabase.COLUMN_DURATION,
                                CreateDatabase.COLUMN_EXIBITION,
                                CreateDatabase.COLUMN_CLASSIFICATION };

    public MovieDAO(Context context) {
        database = new CreateDatabase(context);
    }

    //Insere um novo registro no banco de dados.
    public long insert(Movie movie){
        ContentValues values = new ContentValues();

        values.put(CreateDatabase.COLUMN_NAME, movie.getName());
        values.put(CreateDatabase.COLUMN_GENRE, movie.getGenre());
        values.put(CreateDatabase.COLUMN_TRAILER, movie.getTrailer());
        values.put(CreateDatabase.COLUMN_COVER, movie.getCover());
        values.put(CreateDatabase.COLUMN_DURATION, movie.getDuration());
        values.put(CreateDatabase.COLUMN_EXIBITION, movie.getExibition());
        values.put(CreateDatabase.COLUMN_CLASSIFICATION, movie.getClassification());
        values.put(CreateDatabase.COLUMN_WEEK, movie.getWeek());

        sqLiteDatabase = database.getWritableDatabase();

        long result = sqLiteDatabase.insert(CreateDatabase.TABLE_MOVIE, null, values);
        database.close();

        return result;
    }//insert()

    //Obtém todos os filmes salvos no banco.
    public List<Movie> getAll(){
        sqLiteDatabase = database.getReadableDatabase();
        List<Movie> movies = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(CreateDatabase.TABLE_MOVIE, columns, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                Movie movie = new Movie();
                movie.setId(cursor.getLong(cursor.getColumnIndex(CreateDatabase.COLUMN_ID)));
                movie.setName(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_NAME)));
                movie.setGenre(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_GENRE)));
                movie.setDuration(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_DURATION)));
                movie.setCover(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_COVER)));
                movie.setClassification(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_CLASSIFICATION)));
                movie.setExibition(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_EXIBITION)));
                movie.setTrailer(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_TRAILER)));
                movie.setWeek(cursor.getString(cursor.getColumnIndex(CreateDatabase.COLUMN_WEEK)));

                movies.add(movie);
            }while (cursor.moveToNext());
        }
        database.close();
        return movies;
    }//getAll()

    //Apaga todos os registros da tabela movies.
    public void deleteAll(){
        sqLiteDatabase = database.getWritableDatabase();
        sqLiteDatabase.delete(CreateDatabase.TABLE_MOVIE, null, null);
    }//deleteAll()
}//class MovieDAO
