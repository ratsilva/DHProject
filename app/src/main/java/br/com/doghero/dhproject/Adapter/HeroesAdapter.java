package br.com.doghero.dhproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.doghero.dhproject.Object.Hero;

public class HeroesAdapter extends ArrayAdapter<Integer> {

    private Context                 mContext		;
    private HeroViewHolder[] 		cardsTag		;
    private HeroViewHolder 			cardVH			;
    private static ArrayList<Hero>   listHero		;

    public HeroesAdapter(Context context, ArrayList<Hero> listHero, int resource) {
        super(context, resource);

        mContext 					= context;
        cardsTag 					= new HeroViewHolder[listHero.size()];

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;



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

