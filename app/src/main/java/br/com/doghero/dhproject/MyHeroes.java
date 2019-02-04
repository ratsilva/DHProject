package br.com.doghero.dhproject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.doghero.dhproject.Object.Hero;

public class MyHeroes {

    //you can use Gson lib
    public static List<Hero> build(String json) {

        ArrayList<Hero> myHeroes = new ArrayList<Hero>();

        Type type = new TypeToken<List<Hero>>() {}.getType();


        Gson parseGson = new Gson();
        List<Hero> fromJson = parseGson.fromJson(json, type);

        return fromJson;

        /*
        {
            "is_superhero": false,
            "user": {
                "first_name": "Gustavo",
                "image_url": "https://doghero-uploads-dev.s3.amazonaws.com/uploads/photo/433367/sq135_147 6480114177_736191_avatar.jpg"
            },
            "address_neighborhood": "Vila Mariana",
            "price": 45
         }
         */

    }

}
