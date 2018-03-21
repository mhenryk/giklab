package lab3.pw.edu.pl.lab4;

import android.net.Uri;
import android.util.Log;

import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;

public class GeoServerUrlTileProvider extends UrlTileProvider {

    private final String baseUrl;
    private final String store;
    private final String layer;

    public GeoServerUrlTileProvider(String baseUrl, String store, String layer, int width, int height) {
        super(width, height);
        this.baseUrl = baseUrl;
        this.store = store;
        this.layer = layer;
    }


    @Override
    public URL getTileUrl(int x, int y, int zoom) {
        Uri uri = new Uri.Builder()
                .encodedPath(baseUrl)
                .appendEncodedPath("gmaps")
                .appendQueryParameter("layers", "$store:$layer")
                .appendQueryParameter("x", String.valueOf(x))
                .appendQueryParameter("y", String.valueOf(y))
                .appendQueryParameter("zoom", String.valueOf(zoom))
                .build();


        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}