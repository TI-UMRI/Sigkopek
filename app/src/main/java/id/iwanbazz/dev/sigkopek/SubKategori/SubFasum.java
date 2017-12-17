package id.iwanbazz.dev.sigkopek.SubKategori;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import id.iwanbazz.dev.sigkopek.R;

public class SubFasum extends AppCompatActivity {

    String [] SUBfu = new String []{
            "Fasilitas Kota",
            "Kuliner dan Kerajinan",
            "Fasilitas Umum"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fasum);

        ListView LvKategori = (ListView)findViewById(R.id.fasum);
        ArrayAdapter adapter = new ArrayAdapter(SubFasum.this, android.R.layout.simple_list_item_1, SUBfu);


        LvKategori.setAdapter(adapter);
    }
}
