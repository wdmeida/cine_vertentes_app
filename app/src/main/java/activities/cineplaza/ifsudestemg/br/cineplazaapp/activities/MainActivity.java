package activities.cineplaza.ifsudestemg.br.cineplazaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define o ButterKnife como gerenciador das views da activity.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        //Define e ativa a barra de ferramentas.
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infla o menu para poder adicionar os itens ao mesmo.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }//onCreateOptionsMenu()

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Obtèm o identificador do item que foi selecionado.
        int id = item.getItemId();

        if (id == R.id.action_settings) return true;

        return super.onOptionsItemSelected(item);
    }
}//class MainActivity
