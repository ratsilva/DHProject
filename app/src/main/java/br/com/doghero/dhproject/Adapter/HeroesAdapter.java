package br.com.doghero.dhproject.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.images.ImageHelper;

public class HeroesAdapter extends ArrayAdapter<Hero> {

    private Context                 mContext		;
    //private HeroViewHolder[] 		cardsTag		;
    private HeroViewHolder 			cardVH			;
    private static ArrayList<Hero>  listHero		;
    private ImageHelper             imgHelper       ;

    public HeroesAdapter(Context context, ArrayList<Hero> listHero, int resource) {
        super(context, 0, listHero);

        //mContext 					= context;
        //cardsTag 					= new HeroViewHolder[listHero.size()];
        //this.listHero               = listHero;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        Hero hero = getItem(position);


        Log.v("ADAPTER", "Hero nome: " + hero.getFirst_name());

        if(view!=null) {
            view = null;
        }

        if(view==null){

            cardVH = new HeroViewHolder();

            view = LayoutInflater.from(getContext()).inflate(R.layout.card_heroes, parent, false);

            cardVH.userFoto 	    = (ImageView) view.findViewById(R.id.card_heroes_userfoto);
            //cardVH.userSuperHero 	= (ImageView) view.findViewById(R.id.card_heroes_userfoto);
            cardVH.userNome 	    = (TextView) view.findViewById(R.id.card_heroes_usernome);
            cardVH.userBairro 	    = (TextView) view.findViewById(R.id.card_heroes_userbairro);
            cardVH.userPreco 	    = (TextView) view.findViewById(R.id.card_heroes_userpreco);
            cardVH.btnFavoritar 	= (Button) view.findViewById(R.id.card_heroes_btnfavoritar);
            cardVH.btnConversar 	= (Button) view.findViewById(R.id.card_heroes_btnconversar);
            cardVH.btnReservar 	    = (Button) view.findViewById(R.id.card_heroes_btnreservar);


            view.setTag(cardVH);

        }
        else cardVH = (HeroViewHolder) view.getTag();

        cardVH.userNome	    .setText(hero.getFirst_name());
        cardVH.userBairro	.setText(hero.getAddress_neighborhood());
        cardVH.userPreco	.setText("" + hero.getPrice());
        //imgHelper.loadImage(getContext(), hero.getImage_url(), R.drawable.progress_image, cardVH.userFoto);

        return view;

    }


    static class HeroViewHolder	{

        View        view			;

        ImageView   userFoto        ;
        ImageView   userSuperHero   ;
        TextView    userNome        ;
        TextView    userBairro      ;
        TextView    userPreco       ;
        Button      btnFavoritar    ;
        Button      btnConversar    ;
        Button      btnReservar     ;

    }

}

