package example.com.readingbook;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class books {

    public String title;
    public StringBuffer myreadingContent;
    public Bitmap backgroup;
    public int numberOfchapter;
    public String author;
    public String info;

/*    public static ArrayList<books> getRecipesFromFile(String filename, Context context){
        final ArrayList<books> recipeList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("recipes.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray recipes = json.getJSONArray("recipes");

            // Get Recipe objects from data
            for(int i = 0; i < recipes.length(); i++){
                books book = new books();

                book.title = recipes.getJSONObject(i).getString("title");
                book.numberOfchapter = recipes.getJSONObject(i).getString("numberOfchapter");
                book.imageUrl = recipes.getJSONObject(i).getString("image");
                book.instructionUrl = recipes.getJSONObject(i).getString("url");
                book.label = recipes.getJSONObject(i).getString("dietLabel");

                recipeList.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipeList;
    }*/

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }


}
