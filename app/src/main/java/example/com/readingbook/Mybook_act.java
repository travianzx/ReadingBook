package example.com.readingbook;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Mybook_act extends AppCompatActivity {

    private ListView mListView;
    public final static String EXTRA_MESSAGE = "Message from MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybook_act);
        mListView = (ListView) findViewById(R.id.book_list_view);


        final String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        System.out.println(values.length);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            Intent i = new Intent(getApplicationContext(), reading_book_Activity.class);

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //Toast.makeText(Mybook_act.this, "" + position, Toast.LENGTH_SHORT).show();
                //Toast.makeText(Mybook_act.this, values[position], Toast.LENGTH_SHORT).show();
                i.putExtra(EXTRA_MESSAGE, values[position]);
                startActivity(i);

            }

        });

    }



}
