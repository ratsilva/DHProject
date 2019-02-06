package br.com.doghero.dhproject.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.doghero.dhproject.Activity.MainActivity;
import br.com.doghero.dhproject.Adapter.HeroesAdapter;
import br.com.doghero.dhproject.Adapter.HeroesFavAdapter;
import br.com.doghero.dhproject.MyHeroes;
import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.Object.JsonReaderHero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.api.ApiAnswer;

public class HeroesFragment extends Fragment {

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

    /*
        Elementos auxiliares de execução
     */

    private View    rootView;
    private Context ctx;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Define o fragment que será visualizado
        rootView = inflater.inflate(R.layout.fragment_heroes, container, false);

        // Popula as lists de Heros
        populateListHeroes();

        // Instancia as listviews e define os adapters
        defineListView();

        return rootView;
    }

    private void defineListView(){

        // Instancia as listviews
        listViewHeroes = (ListView) rootView.findViewById(R.id.content_heroes_list1);
        listViewFavHeroes = (ListView) rootView.findViewById(R.id.content_heroes_list2);

        // Instancia os adapters
        adapterHeroes = new HeroesAdapter(MainActivity.ctx, listHeroes);
        adapterFavHeroes = new HeroesFavAdapter(MainActivity.ctx, listFavHeroes);

        // Associa as listviews com seus respectivos adapters
        listViewHeroes.setAdapter(adapterHeroes);
        listViewFavHeroes.setAdapter(adapterFavHeroes);

        // Define dinamicamente a altura das listviews
        // Isso é usado para melhorar a navegação do usuário, umas vez que temos 2 listviews dentro de 1 scrollview
        setDynamicHeight(listViewHeroes);
        setDynamicHeight(listViewFavHeroes);

    }

    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }

        int height = 0;
        int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.UNSPECIFIED);
        int count = adapter.getCount();
        View listItem = adapter.getView(0, null, listView);

        if (listItem == null) {
            return;
        }

        listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
        height = count * listItem.getMeasuredHeight();

        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height;

        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    private void populateListHeroes(){

        // Leitura da API de Herois
        String myHeroes = ApiAnswer.getMyHeroes();

        // Utilização da biblioteca GSON para deserialize das informações
        JsonReaderHero jrh = MyHeroes.build(myHeroes);

        // Aramzena informações nas listas
        listHeroes = jrh.recents;
        listFavHeroes = jrh.favorites;

    }

}
