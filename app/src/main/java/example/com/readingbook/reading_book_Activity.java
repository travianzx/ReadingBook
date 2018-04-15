package example.com.readingbook;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class reading_book_Activity extends AppCompatActivity {

    TextView tv;
    ProgressBar pg;
    private void loadText() {

        final Resources resource = getApplicationContext().getResources();
        InputStream in = resource.openRawResource(R.raw.ludingji_4);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuffer sb = new StringBuffer();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
            sb.append(line);
            }
            tv.setText(sb);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_book_);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv = (TextView) findViewById(R.id.textView);
        //tv.setMovementMethod(new ScrollingMovementMethod());
        pg = (ProgressBar) findViewById(R.id.progressBar);

        //setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Mybook_act.EXTRA_MESSAGE);
        tv.setText(message);

        // AsyncTask
        loadText();
        try
        {

            Thread.sleep(0);
            pg.setVisibility(View.INVISIBLE);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }


    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String>
    {


        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }

}
