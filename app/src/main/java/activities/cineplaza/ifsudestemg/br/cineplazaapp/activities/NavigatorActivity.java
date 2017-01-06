package activities.cineplaza.ifsudestemg.br.cineplazaapp.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.R;

public class NavigatorActivity extends FragmentActivity{
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private List<String> fragments;
    private CharSequence tl;
    private CharSequence tlf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);
        
    }
}
