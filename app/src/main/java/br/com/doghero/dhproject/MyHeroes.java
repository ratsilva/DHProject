package br.com.doghero.dhproject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import br.com.doghero.dhproject.Object.Hero;
import br.com.doghero.dhproject.Object.JsonReaderHero;

public class MyHeroes {

    //you can use Gson lib
    public static JsonReaderHero build(String json) {

        // Cria objeto GSON
        Gson parseGson = new Gson();

        // Cria o tipo de collection que o GSON precisa ler
        Type listType = new TypeToken<ArrayList<Hero>>(){}.getType();

        // Executa o parse do JSON para a classe JsonReaderHero
        JsonReaderHero readerHeroJson = parseGson.fromJson(json, JsonReaderHero.class);

        return readerHeroJson;

    }

}
