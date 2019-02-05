package br.com.doghero.dhproject.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.doghero.dhproject.Adapter.HeroesAdapter;
import br.com.doghero.dhproject.MyHeroes;
import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.api.ApiAnswer;

public class HeroesActivity extends AppCompatActivity {

    private ListView listViewHeroes;
    private ListView listViewFavHeroes;
    private HeroesAdapter heroesAdapter;
    private ArrayList<Hero> listHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Carrega as informações dos heróis
        //listHeroes = new ArrayList<>();
        listHeroes = getListHeroes();

        // Instancia as listviews e define o adapter
        defineListView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */

                String myHeroes = ApiAnswer.getMyHeroes();

                System.out.println("JSON: \n" + myHeroes);

                List<Hero> a = MyHeroes.build(myHeroes);

                for (Hero task : a) {
                    System.out.println(task);
                }


            }
        });
    }

    private void defineListView(){

        listViewHeroes = (ListView) findViewById(R.id.content_heroes_list1);
        listViewFavHeroes = (ListView) findViewById(R.id.content_heroes_list2);

        heroesAdapter = new HeroesAdapter(this, listHeroes, android.R.layout.activity_list_item);

        listViewHeroes.setAdapter(heroesAdapter);
        //listViewFavHeroes.setAdapter(heroesAdapter);

    }

    private ArrayList<Hero> getListHeroes(){

        ArrayList<Hero> l = new ArrayList<>();

        l.add(new Hero("Ricardo", "Aruã", 35.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", false));
        //l.add(new Hero("Gustavo", "Vila Mariana", 135.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", false));
        //l.add(new Hero("Talyson", "Pindamonhangaba", 315.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", false));
        //l.add(new Hero("Roberto", "Aruã", 3522.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", false));
        //l.add(new Hero("Soraia", "Aruã", 353.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", false));
        //l.add(new Hero("Alfredo", "Aruã", 35.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", true));
        //l.add(new Hero("Marcela", "Aruã", 3445.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", true));
        //l.add(new Hero("Pedro", "Aruã", 325.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", true));
        l.add(new Hero("Paulo", "Aruã", 315.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", true));
        l.add(new Hero("Carolina", "Aruã", 325.0, "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png", true));

        return l;

    }

}
