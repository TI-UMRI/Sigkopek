package id.iwanbazz.dev.sigkopek.SubKategori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.R;
import id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview.Data_Sekolah;

public class SubPendidikan extends AppCompatActivity {

    String [] SUBpendidikan = new String []{
            "SD / MI",
            "SLTP",
            "SLTA",
            "Perguruan Tinggi"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pendidikan);

        ListView LvKategori = (ListView) findViewById(R.id.pendidikan);
        ArrayAdapter adapter = new ArrayAdapter(SubPendidikan.this, android.R.layout.simple_list_item_1, SUBpendidikan);


        LvKategori.setAdapter(adapter);

        LvKategori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView) view).getText().toString();
                String item2 = ((TextView) view).getText().toString();

                switch (position) {
                    case 0:
                        Intent i = new Intent(SubPendidikan.this, Data_Sekolah.class);
                        i.putExtra("sd", item);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i2 = new Intent(SubPendidikan.this, Data_Sekolah.class);
                        i2.putExtra("smp", item2);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(SubPendidikan.this, Data_Sekolah.class);
                        i3.putExtra("sma", item2);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(SubPendidikan.this, Data_Sekolah.class);
                        i4.putExtra("pt", item2);
                        startActivity(i4);
                        break;
                }
            }
        });

    }
}
