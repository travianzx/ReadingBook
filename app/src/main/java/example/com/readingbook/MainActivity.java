package example.com.readingbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_INTERNET = 200;
    Button button_act1;
    Button button_act2;
    Button button_act3;
    TextView topText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startWeather();
        button_act1 = (Button) findViewById(R.id.button2);
        button_act1.setOnClickListener( clickButton );

    }


    private View.OnClickListener clickButton = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent act2 = new Intent(MainActivity.this,Mybook_act.class);
            startActivity(act2);

        }

    };


    private void startWeather() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission is already available, start camera preview
            Toast.makeText(MainActivity.this, "startCamera", Toast.LENGTH_SHORT).show();

        } else {
            // Permission is missing and must be requested.
            requestInternetPermission();
        }

    }

    //because some the deveices run Android 6 or even higher version,
    //Check For Permissions need to be implemented at run time.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // BEGIN_INCLUDE(onRequestPermissionsResult)
        if (requestCode == REQUEST_INTERNET) {
            // Request for camera permission.
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start camera preview Activity.
                Toast.makeText(MainActivity.this, "INTERNET access permission was granted", Toast.LENGTH_SHORT).show();
                //startCamera();


            } else {
                // Permission request was denied.
                Toast.makeText(MainActivity.this, "INTERNET access permission was denied", Toast.LENGTH_SHORT).show();

            }


        }
        // END_INCLUDE(onRequestPermissionsResult)

    }

    private void requestInternetPermission() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This permission is important to record audio.")
                .setTitle("Important permission required");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.INTERNET}, REQUEST_INTERNET);
            }
        });
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.INTERNET}, REQUEST_INTERNET);
    }


}

