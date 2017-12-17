package id.iwanbazz.dev.sigkopek.SubKategori;

/**
 * Created by Anisah Denis on 9/30/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.Cari;
import id.iwanbazz.dev.sigkopek.R;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Anisah Denis on 9/25/2016.
 */
public class DetailCari extends AppCompatActivity {
    public TextView nama;
    public TextView jenis;
    public TextView alamat;
    public TextView latv;
    public TextView lngv;

    public double lat;
    public double lng;
    public GoogleMap mMap;
    // private String url = "http://sipkopas.pasuruankota.go.id/json/datapetakel.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cari);

        // display google
        /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);*/


        jenis = (TextView) findViewById(R.id.viewjenis);
        nama = (TextView) findViewById(R.id.viewnama);
        alamat = (TextView) findViewById(R.id.viewalamat);
        latv = (TextView) findViewById(R.id.viewlat);
        lngv = (TextView) findViewById(R.id.viewlng);

        //mengambil intent
        Intent i = getIntent();
        //menampilkan nilai hasil parsing dari intent

        jenis.setText("jenis : "+String.valueOf(i.getStringExtra(Cari.jenis)));
        nama.setText("nama :  "+String.valueOf(i.getStringExtra(Cari.nama)));
        alamat.setText("alamat  :  "+String.valueOf(i.getStringExtra(Cari.alamat)));
        latv.setText("latitude  :  " + (i.getStringExtra(String.valueOf(Cari.lat))));
        lngv.setText("longitude :  "+(i.getStringExtra(String.valueOf(Cari.lng))));

    }

}

