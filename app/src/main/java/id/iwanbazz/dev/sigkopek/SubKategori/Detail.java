package id.iwanbazz.dev.sigkopek.SubKategori;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.R;
import id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview.Data_Kelurahan;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Anisah Denis on 9/25/2016.
 */
public class Detail extends AppCompatActivity implements OnMapReadyCallback {
    public TextView nama;
    public TextView no;
    public TextView alamat;
    public TextView notelp;
    public TextView lat;
    public TextView lng, lng3;
    public String lat2, lng2, nama2;
    public GoogleMap mMap;
    Intent i;
    Location location;
   double latitude;
    double longitude;

   // private String url = "http://sipkopas.pasuruankota.go.id/json/datapetakel.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

       // display google
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

        no = (TextView) findViewById(R.id.textView2);
        nama = (TextView) findViewById(R.id.textView3);
        alamat = (TextView) findViewById(R.id.textView4);
        notelp = (TextView) findViewById(R.id.textView5);
        lat = (TextView) findViewById(R.id.textView6);
        lng = (TextView) findViewById(R.id.textView7);

        lng3 = (TextView) findViewById(R.id.textView8);
        //mengambil intent
         i = getIntent();
       // Intent intent = getIntent();
      //  String markerTitle = i.getExtras().getString("nama");
        //menampilkan nilai hasil parsing dari intent

        no.setText("id : "+String.valueOf(i.getStringExtra(Data_Kelurahan.no)));
        nama.setText("nama :  "+String.valueOf(i.getStringExtra(Data_Kelurahan.nama)));
        alamat.setText("alamat  :  " + String.valueOf(i.getStringExtra(Data_Kelurahan.alamat)));
        notelp.setText("nomor telepon  :  "+(i.getStringExtra(Data_Kelurahan.notelp)));
        lat.setText((i.getStringExtra(String.valueOf(Data_Kelurahan.lat))));
        lng.setText((i.getStringExtra(String.valueOf(Data_Kelurahan.lng))));

//mengubah data text menjadi string
        lat2 = lat.getText().toString();
        lng2 = lng.getText().toString();
        nama2 = nama.getText().toString();
        try {
            latitude = Double.parseDouble(lat2.toString());
            longitude = Double.parseDouble(lng2.toString());
            Log.v("lat", "ready for calculation");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


       this.mMap = googleMap;



        // Add a marker in Sydney and move the camera
        LatLng pas = new LatLng(latitude,longitude);
         //LatLng pas = new LatLng(-7.64280732732681, 112.892977148294);
        mMap.addMarker(new MarkerOptions().position(pas).title(nama2));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pas, 14));
    }
}
