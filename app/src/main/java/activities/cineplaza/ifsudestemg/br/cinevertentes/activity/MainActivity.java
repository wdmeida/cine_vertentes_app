package activities.cineplaza.ifsudestemg.br.cinevertentes.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import activities.cineplaza.ifsudestemg.br.cinevertentes.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        //Define e ativa a barra de ferramentas.
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
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
    }//onOptionsItemSelected()

    private void listarFilmes(){
        Intent listarFilmesIntent = new Intent(MainActivity.this, ListaFilmesActivity.class);
        startActivity(listarFilmesIntent);
    }

    //Valida e executa a opção escolhida no menu.
    @Override
    public void onDrawerItemSelected(View view, int position) {
        switch (position){
            case 0: break;
            case 1: listarFilmes(); break;
        }
    }//onDrawerItemSelected()
}//class MainActivity
