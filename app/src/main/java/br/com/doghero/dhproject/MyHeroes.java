package br.com.doghero.dhproject;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.Object.JsonReaderHero;

public class MyHeroes {

    //you can use Gson lib
    public static JsonReaderHero build(String json) {

        Gson parseGson = new Gson();
        Type listType = new TypeToken<ArrayList<Hero>>(){}.getType();

        JsonReaderHero readerHeroJson = parseGson.fromJson(json, JsonReaderHero.class);

        return readerHeroJson;

    }

}
