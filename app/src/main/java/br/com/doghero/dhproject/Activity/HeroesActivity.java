package br.com.doghero.dhproject.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import br.com.doghero.dhproject.Adapter.HeroesAdapter;
import br.com.doghero.dhproject.Adapter.HeroesFavAdapter;
import br.com.doghero.dhproject.MyHeroes;
import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.Object.JsonReaderHero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.api.ApiAnswer;

public class HeroesActivity extends AppCompatActivity {

    /*
        Elementos para a listagem de Heróis com quem hospedei
     */

    private ListView listViewHeroes;
    private HeroesAdapter adapterHeroes;
    private List<Hero> listHeroes;

    /*
        Elementos para a listagem de Heróis favoritos
     */

    private ListView listViewFavHeroes;
    private HeroesFavAdapter adapterFavHeroes;
    private List<Hero> listFavHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Popula as lists de Heros
        populateListHeroes();

        // Instancia as listviews e define o adapter
        defineListView();
    }

    private void defineListView(){

        listViewHeroes = (ListView) findViewById(R.id.content_heroes_list1);
        listViewFavHeroes = (ListView) findViewById(R.id.content_heroes_list2);

        adapterHeroes = new HeroesAdapter(this, listHeroes);
        adapterFavHeroes = new HeroesFavAdapter(this, listFavHeroes);

        listViewHeroes.setAdapter(adapterHeroes);
        listViewFavHeroes.setAdapter(adapterFavHeroes);

        setDynamicHeight(listViewHeroes);
        setDynamicHeight(listViewFavHeroes);

    }

    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.UNSPECIFIED);

        int count = adapter.getCount();
        View listItem = adapter.getView(0, null, listView);
        listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
        height = count * listItem.getMeasuredHeight();

        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height;

        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    private void populateListHeroes(){

        String myHeroes = ApiAnswer.getMyHeroes();
        JsonReaderHero jrh = MyHeroes.build(myHeroes);

        listHeroes = jrh.recents;
        listFavHeroes = jrh.favorites;
    }

}
