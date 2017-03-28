package activities.cineplaza.ifsudestemg.br.cinevertentes.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import activities.cineplaza.ifsudestemg.br.cinevertentes.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

    }//onCreate()

    @OnClick(R.id.button_plaza)
    public void folderCinePlaza(){
        Intent cinePlazaIntent = new Intent(MainActivity.this, ListaFilmesActivity.class);
        startActivity(cinePlazaIntent);
    }
}//class MainActivity
