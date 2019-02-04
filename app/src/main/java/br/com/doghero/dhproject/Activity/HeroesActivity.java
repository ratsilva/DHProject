package br.com.doghero.dhproject.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.com.doghero.dhproject.MyHeroes;
import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.api.ApiAnswer;

public class HeroesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




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

}
