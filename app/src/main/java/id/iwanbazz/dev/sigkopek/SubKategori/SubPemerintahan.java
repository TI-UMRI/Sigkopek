package id.iwanbazz.dev.sigkopek.SubKategori;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.R;
import id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview.Data_Kelurahan;
import id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview.Data_Skpd;

public class SubPemerintahan extends AppCompatActivity {

        String[] SUBpemerintahan = new String[]{
            "Badan",
            "Dinas",
            "Kantor",
            "Kelurahan",
            "kecamatan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pemerintahan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView LvKategori = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter(SubPemerintahan.this, android.R.layout.simple_list_item_1, SUBpemerintahan);


        LvKategori.setAdapter(adapter);


        LvKategori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String badan = ((TextView)view).getText().toString();
                String dinas = ((TextView)view).getText().toString();
                String kantor = ((TextView)view).getText().toString();
                String kelurahan = ((TextView)view).getText().toString();
                String kecamatan = ((TextView)view).getText().toString();

                switch (position){
                    case 0 :
                        Intent in =  new Intent(SubPemerintahan.this, Data_Skpd.class);
                        in.putExtra("badan", badan);
                        startActivity(in);
                        break;
                    case 1 :
                        Intent in1 =  new Intent(SubPemerintahan.this, Data_Skpd.class);
                        in1.putExtra("dinas", dinas);
                        startActivity(in1);
                        break;
                    case 2 :
                        Intent in2 =  new Intent(SubPemerintahan.this, Data_Skpd.class);
                        in2.putExtra("kantor", kantor);
                        startActivity(in2);
                        break;
                    case 3 :
                        Intent in3 =  new Intent(SubPemerintahan.this, Data_Kelurahan.class);
                        in3.putExtra("kelurahan", kelurahan);
                        startActivity(in3);
                        break;
                    case 4 :
                        Intent in4 =  new Intent(SubPemerintahan.this, Data_Skpd.class);
                        in4.putExtra("kecamatan", kecamatan);
                        startActivity(in4);
                        break;

                }


            }
        });


    }
}

