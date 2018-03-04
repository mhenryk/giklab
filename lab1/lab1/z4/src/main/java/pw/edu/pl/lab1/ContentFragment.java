package pw.edu.pl.lab1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContentFragment extends Fragment {

    private Toolbar toolbar;
    private EditText latitudeEditText;
    private EditText longituteEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        Button button = view.findViewById(R.id.button1);
        latitudeEditText = view.findViewById(R.id.latitude);
        longituteEditText = view.findViewById(R.id.longitude);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (latitudeEditText.length() > 0 && longituteEditText.length() > 0) {
                    try {
                        double latitude = readLatitude();
                        double longitude = readLongitude();
                        openGoogleMapsExternalApp(latitude, longitude);
                    } catch (NumberFormatException parseException) {
                        parseException.printStackTrace();
                    }
                } else {
                    Toast.makeText(getContext(), "Zle wspolrzedne", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setHasOptionsMenu(true);
        return view;
    }

    private void openGoogleMapsInBrowser(double latitude, double longitude) {
        Uri googleMapsUri = Uri.parse("https://www.google.com/maps/@?api=1&map_action=map&center=" + latitude + "," +
                longitude + "&zoom=12");
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setData(googleMapsUri);
        if (viewIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(viewIntent);
        } else {
            Toast.makeText(getContext(), "Brak aplikacji do map", Toast.LENGTH_SHORT).show();
        }
    }

    private void openGoogleMapsExternalApp(double latitude, double longitude) {
        //zgodnie z https://developers.google.com/maps/documentation/urls/android-intents
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            openGoogleMapsInBrowser(latitude, longitude);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();

        //metoda 1
//        if (activity instanceof ToolbarOwner1) {
//            ((ToolbarOwner1) activity).setText("Tytul z fragmentu 1");
//        }

        //metoda 2
        if (activity instanceof ToolbarOwner2) {
            toolbar = ((ToolbarOwner2) activity).getToolbar();
            if (toolbar != null)
                toolbar.setTitle("Tytul z fragmentu 2");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                shareCoords();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareCoords() {
        if (latitudeEditText.length() > 0 && longituteEditText.length() > 0) {
            try {
                double latitude = readLatitude();
                double longitude = readLongitude();
                String shareText = "Oto wybrane wspolrzedne: " + latitude + ", " + longitude;
                shareText(shareText);

            } catch (NumberFormatException e) {
                Toast.makeText(latitudeEditText.getContext(), "Zle wspolrzedne", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void shareText(String shareText) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private double readLongitude() throws NumberFormatException {
        return Double.parseDouble(longituteEditText.getText().toString());
    }

    private double readLatitude() throws NumberFormatException {
        return Double.parseDouble(latitudeEditText.getText().toString());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //metoda 2
        toolbar = null; //ważne!
    }
}
