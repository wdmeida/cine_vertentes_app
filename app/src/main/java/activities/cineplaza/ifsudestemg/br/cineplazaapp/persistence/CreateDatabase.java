package activities.cineplaza.ifsudestemg.br.cineplazaapp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wagner on 08/09/16.
 */
public class CreateDatabase extends SQLiteOpenHelper {
    public static final String TABLE_MOVIE = "movies";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_EXIBITION = "exibition";
    public static final String COLUMN_COVER = "cover";
    public static final String COLUMN_TRAILER = "trailer";
    public static final String COLUMN_CLASSIFICATION = "classification";
    public static final String COLUMN_WEEK = "week";

    private static final String DATABASE_NAME = "cineplazamovies.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_MOVIE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                                                      + COLUMN_NAME + " TEXT NOT NULL, "
                                                                                      + COLUMN_GENRE + " TEXT NOT NULL, "
                                                                                      + COLUMN_EXIBITION + " TEXT NOT NULL, "
                                                                                      + COLUMN_DURATION + " TEXT NOT NULL, "
                                                                                      + COLUMN_CLASSIFICATION + " TEXT NOT NULL, "
                                                                                      + COLUMN_COVER + " TEXT NOT NULL, "
                                                                                      + COLUMN_TRAILER + " TEXT NOT NULL, "
                                                                                      + COLUMN_WEEK + " TEXT NOT NULL);";

    public CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIE);
        onCreate(sqLiteDatabase);
    }
}
