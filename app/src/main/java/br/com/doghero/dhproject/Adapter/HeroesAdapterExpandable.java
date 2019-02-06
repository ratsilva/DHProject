package br.com.doghero.dhproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.images.ImageHelper;

public class HeroesAdapterExpandable extends BaseExpandableListAdapter {

    private Context                                 mContext		;
    private HeroViewHolder[][]                      cardsChildTag	;
    private HeroViewHolder 			                cardVH			;
    private ImageHelper                             imgHelper       ;

    private List<String>                    listDataHeader  ;
    private HashMap<String, List<Hero>>     listDataChild   ;

    public HeroesAdapterExpandable(Context context, List<String> listDataHeader_, HashMap<String, List<Hero>> listChildData_) {

        mContext 					= context;

        int maxvalue = 0;
        for(String s : listChildData_.keySet()){
            if(listChildData_.get(s).size() > maxvalue){
                maxvalue = listChildData_.get(s).size();
            }
        }

        cardsChildTag 				= new HeroViewHolder[listDataHeader_.size()][maxvalue];
        listDataHeader              = listDataHeader_;
        listDataChild               = listChildData_;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.listDataChild.get(this.listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listDataChild.get(this.listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headerTitle = (String) getGroup(i);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_group_header, null);
        }

        ExpandableListView eLV = (ExpandableListView) viewGroup;
        eLV.expandGroup(i);

        TextView lblListHeader = (TextView) view.findViewById(R.id.list_group_header_lbl);
        lblListHeader.setText(headerTitle);

        return view;

    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {

        final Hero atualHero = (Hero) getChild(i, i1);

        if(view!=null) {
            if(view.getTag() != cardsChildTag[i][i1])		view = null;
        }

        if (view == null) {

            cardVH = new HeroViewHolder();

            LayoutInflater infalInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.card_heroes, null);

            cardVH.userFoto 	    = (ImageView) view.findViewById(R.id.card_heroes_userfoto);
            cardVH.userSuperHero 	= (ImageView) view.findViewById(R.id.card_heroes_usersuperhero);
            cardVH.userNome 	    = (TextView) view.findViewById(R.id.card_heroes_usernome);
            cardVH.userBairro 	    = (TextView) view.findViewById(R.id.card_heroes_userbairro);
            cardVH.userPreco 	    = (TextView) view.findViewById(R.id.card_heroes_userpreco);
            cardVH.btnFavoritar 	= (ImageButton) view.findViewById(R.id.card_heroes_btnfavoritar);
            cardVH.btnConversar 	= (Button) view.findViewById(R.id.card_heroes_btnconversar);
            cardVH.btnReservar 	    = (Button) view.findViewById(R.id.card_heroes_btnreservar);

            view.setTag(cardVH);
            cardsChildTag[i][i1] = cardVH;


        }else{
            cardVH = (HeroViewHolder) view.getTag();
        }

        cardVH.userNome	        .setText(atualHero.getUser().getFirst_name());
        cardVH.userBairro	    .setText(atualHero.getAddress_neighborhood());
        cardVH.userPreco	    .setText(String.valueOf(atualHero.getPrice()).replace(".0",""));
        cardVH.btnFavoritar     .setTag(R.drawable.icon_like_border_vector_gray_battleship);
        imgHelper.loadImage(mContext, atualHero.getUser().getImage_url(), R.drawable.progress_image, cardVH.userFoto);

        if(atualHero.isIs_superhero()){
            cardVH.userSuperHero.setVisibility(View.VISIBLE);
        }else{
            cardVH.userSuperHero.setVisibility(View.GONE);
        }

        cardVH.btnFavoritar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                HeroViewHolder vv = cardsChildTag[i][i1];

                Integer resource = (Integer) vv.btnFavoritar.getTag();

                if(resource == R.drawable.icon_like_border_vector_gray_battleship){
                    vv.btnFavoritar.setImageResource(R.drawable.icon_like_filled_vector_red);
                    vv.btnFavoritar.setTag(R.drawable.icon_like_filled_vector_red);
                }else {
                    vv.btnFavoritar.setImageResource(R.drawable.icon_like_border_vector_gray_battleship);
                    vv.btnFavoritar.setTag(R.drawable.icon_like_border_vector_gray_battleship);
                }

                cardsChildTag[i][i1] = vv;
                */

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

