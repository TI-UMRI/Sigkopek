package id.iwanbazz.dev.sigkopek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import id.iwanbazz.dev.sigkopek.Model.ModelData;
import id.iwanbazz.dev.sigkopek.SubKategori.Detail;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    public Double Latitude;
    public Double Longitude;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    private Context _context;
    AlertDialogManager alert = new AlertDialogManager();
    ArrayList<HashMap<String, String>> location;
    String lat,lng, nama;
    List<ModelData> Listdata1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        cekInternet();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

       new  ArrayList<HashMap<String, String>>();
      //  String url = "http://sipkopas.pasuruankota.go.id/json/LatPetakel.php";
        String url = "http://sigkopek.pekanbarukota.go.id/json/datapetakel.php";


        try {
            // JSONArray data = new JSONArray(getHttpGet(url));
            JSONObject jsonObject = new JSONObject(getHttpGet(url));
            JSONArray data = jsonObject.getJSONArray("datapetakel");
            // JSONArray data2 = jsonObject.getJSONArray("datapetapkm");

            location = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;
            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                ModelData data1 = new ModelData();


                data1.setNo(c.getString("no"));
                data1.setNama(c.getString("nama"));
                data1.setAlamat(c.getString("alamat"));
                data1.setNotelp(c.getString("notelp"));
                data1.setLat(c.getString("lat"));
                data1.setLng(c.getString("lng"));
                Listdata1.add(data1);


                map = new HashMap<String, String>();
                //  String no = c.getString("no").trim();
                 lat = c.getString("lat").trim();
                 lng = c.getString("lng").trim();
                 nama = c.getString("nama").trim();


                //   map.put("no", no);
                map.put("nama", nama);
                map.put("lat", lat);
                map.put("lng", lng);
                location.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public static String getHttpGet(String url) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
       this.mMap = googleMap;

        // Add a marker in Sydney and move the camera
      /*  LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        for (int i = 0; i < location.size(); i++) {
            Latitude = Double.parseDouble(location.get(i).get("lat"));
            Longitude = Double.parseDouble(location.get(i).get("lng"));
            String name = location.get(i).get("nama");
            MarkerOptions marker = new MarkerOptions().position(new LatLng(Latitude, Longitude)).snippet("kelurahan").title(name);
            googleMap.addMarker(marker);
            LatLng pas = new LatLng(-7.64280732732681, 112.892977148294);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pas, 14));
            Log.d("onMapReady:", location.get(i).get("lat"));

            final int finalI = i;
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                    Intent in = new Intent(getApplicationContext(), Detail.class);
                   // ModelData listdetail = Listdata1.get(position);
                    String title = marker.getTitle();
                  //  String lat = location.get(finalI).get("lat");
                    in.putExtra("nama", title);
                    in.putExtra("lat", lat);
                   // in.putExtra("lng", lng);
                    //in.putExtra("nama", listdetail.getNama());
                    //in.putExtra("alamat", listdetail.getAlamat());
                    //in.putExtra("notelp", listdetail.getNotelp());
                    //in.putExtra("lat", listdetail.getLat());
                    //in.putExtra("lng", listdetail.getLng());
                    startActivity(in);
                }
            });
            }

        }

    public void cekInternet() {
        cd = new ConnectionDetector(getApplicationContext());
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            Toast.makeText(getApplicationContext(), " anda memiliki koneksi internet", Toast.LENGTH_SHORT).show();
            //  String url = "http://sipkopas.pasuruankota.go.id/json/LatPetakel.php";
        } else {
            alert.showAlertDialog(MapsActivity2.this, "peringatan", "cek koneksi internet.", false);
        }
    }
}
