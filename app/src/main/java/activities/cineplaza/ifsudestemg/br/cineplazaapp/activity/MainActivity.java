package activities.cineplaza.ifsudestemg.br.cineplazaapp.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    public void onDrawerItemSelected(View view, int position) { }//onDrawerItemSelected()
}//class MainActivity
