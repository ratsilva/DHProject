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

    /*
        Elementos auxiliares de execução
     */

    public static Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Instancia e define o toolbar da tela
        Toolbar toolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ctx = this;

        // Carrega o fragment de acordo com o desejado
        // Como só temos 1 fragment, estou colocando "0" 'hardcoded'
        carregaFragment(0);

    }

    private void carregaFragment(int position){

        Fragment fragment = null;

        // Define o fragment que será carregado
        // Como só temos 1 fragment, o switch só possui 1 case
        // Se o position passado for inválido, abre o fragment de Heroes como default
        switch (position){
            case 0:
                fragment = new HeroesFragment();
                break;
            default:
                fragment = new HeroesFragment();
                break;
        }

        if (fragment != null) {

            // Carrega o fragment selecionado no FrameLayout
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_activity_fragment, fragment).commit();

        }

    }

}
