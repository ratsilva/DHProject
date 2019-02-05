package br.com.doghero.dhproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.images.ImageHelper;

public class HeroesFavAdapter extends ArrayAdapter<Hero> {

    private Context                 mContext		;
    private HeroViewHolder[] 		cardsTag		;
    private HeroViewHolder 			cardVH			;
    private static List<Hero>       listHero		;
    private ImageHelper             imgHelper       ;

    public HeroesFavAdapter(Context context, List<Hero> listHero_) {
        super(context, 0, listHero_);

        mContext 					= context;
        cardsTag 					= new HeroViewHolder[listHero_.size()];
        listHero                    = listHero_;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Hero hero = listHero.get(position);

        if(view!=null) {
            if(view.getTag() != cardsTag[position])		view = null;
        }

        if(view==null){

            cardVH = new HeroViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.card_heroes, parent, false);

            cardVH.userFoto 	    = (ImageView) view.findViewById(R.id.card_heroes_userfoto);
            cardVH.userSuperHero 	= (ImageView) view.findViewById(R.id.card_heroes_usersuperhero);
            cardVH.userNome 	    = (TextView) view.findViewById(R.id.card_heroes_usernome);
            cardVH.userBairro 	    = (TextView) view.findViewById(R.id.card_heroes_userbairro);
            cardVH.userPreco 	    = (TextView) view.findViewById(R.id.card_heroes_userpreco);
            cardVH.btnFavoritar 	= (ImageButton) view.findViewById(R.id.card_heroes_btnfavoritar);
            cardVH.btnConversar 	= (Button) view.findViewById(R.id.card_heroes_btnconversar);
            cardVH.btnReservar 	    = (Button) view.findViewById(R.id.card_heroes_btnreservar);

            view.setTag(cardVH);
            cardsTag[position] = cardVH;

        }
        else cardVH = (HeroViewHolder) view.getTag();

        cardVH.userNome	    .setText(hero.getUser().getFirst_name());
        cardVH.userBairro	.setText(hero.getAddress_neighborhood());
        cardVH.userPreco	.setText(String.valueOf(hero.getPrice()).replace(".0",""));
        cardVH.btnFavoritar .setTag(R.drawable.icon_like_border_vector_gray_battleship);
        imgHelper.loadImage(mContext, hero.getUser().getImage_url(), R.drawable.progress_image, cardVH.userFoto);

        if(hero.isIs_superhero()){
            cardVH.userSuperHero.setVisibility(View.VISIBLE);
        }else{
            cardVH.userSuperHero.setVisibility(View.GONE);
        }

        cardVH.btnFavoritar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            HeroViewHolder vv = cardsTag[position];

            Integer resource = (Integer) vv.btnFavoritar.getTag();

                if(resource == R.drawable.icon_like_border_vector_gray_battleship){
                    vv.btnFavoritar.setImageResource(R.drawable.icon_like_filled_vector_red);
                    vv.btnFavoritar.setTag(R.drawable.icon_like_filled_vector_red);
                }else {
                    vv.btnFavoritar.setImageResource(R.drawable.icon_like_border_vector_gray_battleship);
                    vv.btnFavoritar.setTag(R.drawable.icon_like_border_vector_gray_battleship);
                }

                cardsTag[position] = vv;

            }
        });


        return view;

    }


    static class HeroViewHolder	{

        View        view			;

        ImageView   userFoto        ;
        ImageView   userSuperHero   ;
        TextView    userNome        ;
        TextView    userBairro      ;
        TextView    userPreco       ;
        ImageButton btnFavoritar    ;
        Button      btnConversar    ;
        Button      btnReservar     ;

    }

}

