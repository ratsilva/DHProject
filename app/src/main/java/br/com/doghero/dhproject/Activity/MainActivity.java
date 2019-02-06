package br.com.doghero.dhproject.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import br.com.doghero.dhproject.Fragment.HeroesFragment;
import br.com.doghero.dhproject.R;
public class MainActivity extends AppCompatActivity {

    public static Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ctx = this;
        carregaFragment(0);

    }

    private void carregaFragment(int position){

        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new HeroesFragment();
                break;
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_activity_fragment, fragment).commit();

        }

    }

}
