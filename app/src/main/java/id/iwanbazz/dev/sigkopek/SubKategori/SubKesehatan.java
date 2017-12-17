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
import id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview.Data_Pkm;

public class SubKesehatan extends AppCompatActivity {

    String [] SUBkesehatan = new String []{
            "Pkm Induk",
            "PUSTU",
            "UPK",
            "AKPER",
            "RSUD"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_kesehatan);


        ListView LvKategori = (ListView)findViewById(R.id.kesehatan);
        ArrayAdapter adapter = new ArrayAdapter(SubKesehatan.this, android.R.layout.simple_list_item_1, SUBkesehatan);


        LvKategori.setAdapter(adapter);

        LvKategori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String PkmInduk = ((TextView) view).getText().toString();
                String PUSTU = ((TextView) view).getText().toString();
                String UPK = ((TextView) view).getText().toString();
                String AKPER = ((TextView) view).getText().toString();
                String RSUD = ((TextView) view).getText().toString();

                switch (position) {
                    case 0:
                        Intent in = new Intent(SubKesehatan.this, Data_Pkm.class);
                        in.putExtra("Pkm Induk", PkmInduk);
                        startActivity(in);
                        break;
                    case 1:
                        Intent in1 = new Intent(SubKesehatan.this, Data_Pkm.class);
                        in1.putExtra("PUSTU", PUSTU);
                        startActivity(in1);
                        break;
                    case 2:
                        Intent in2 = new Intent(SubKesehatan.this, Data_Pkm.class);
                        in2.putExtra("UPK", UPK);
                        startActivity(in2);
                        break;
                    case 3:
                        Intent in3 = new Intent(SubKesehatan.this, Data_Pkm.class);
                        in3.putExtra("AKPER", AKPER);
                        startActivity(in3);
                        break;
                    case 4:
                        Intent in4 = new Intent(SubKesehatan.this, Data_Pkm.class);
                        in4.putExtra("RSUD", RSUD);
                        startActivity(in4);
                        break;

                }


            }
        });

    }
}
