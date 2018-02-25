package pw.edu.pl.lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Ekran glowny");

        Button button = findViewById(R.id.button1);
        final EditText latitudeEditText = findViewById(R.id.latitude);
        final EditText longituteEditText = findViewById(R.id.longitude);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (latitudeEditText.length() > 0 && longituteEditText.length() > 0) {
                    try {
                        double latitude = Double.parseDouble(latitudeEditText.getText().toString());
                        double longitude = Double.parseDouble(longituteEditText.getText().toString());
                        openGoogleMapsExternalApp(latitude, longitude);
                    } catch (NumberFormatException parseException) {
                        parseException.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Zle wspolrzedne", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openGoogleMapsInBrowser(double latitude, double longitude) {
        Uri googleMapsUri = Uri.parse("https://www.google.com/maps/@?api=1&map_action=map&center=" + latitude + "," +
                                              longitude + "&zoom=12");
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setData(googleMapsUri);
        if (viewIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(viewIntent);
        } else {
            Toast.makeText(this, "Brak aplikacji do map",Toast.LENGTH_SHORT).show();
        }
    }

    private void openGoogleMapsExternalApp(double latitude, double longitude) {
        //zgodnie z https://developers.google.com/maps/documentation/urls/android-intents
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            openGoogleMapsInBrowser(latitude, longitude);
        }
    }
}
