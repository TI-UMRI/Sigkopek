package id.iwanbazz.dev.sigkopek;

/**
 * Created by Anisah Denis on 9/30/2016.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import id.iwanbazz.dev.sigkopek.Model.Adapt;
import id.iwanbazz.dev.sigkopek.Model.ModelData;
import id.iwanbazz.dev.sigkopek.SubKategori.DetailCari;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Indi Winona on 9/30/2016.
 */

public class Cari extends AppCompatActivity {


    ListView listView;
    public  static String jenis = "jenis";
    public  static String nama = "nama";
    public  static String alamat = "alamat";
    public  static String lat = "lat";
    public  static String lng = "lng";
    private EditText editTextId;
    private Button buttonGet;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari);

        listView = (ListView)findViewById(R.id.listViewResult);
        editTextId = (EditText) findViewById(R.id.editCari);
        buttonGet = (Button) findViewById(R.id.cari);
        changeText();
    }

    public void changeText(){

        final Button buttonGet = (Button) findViewById(R.id.cari);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d(TAG, "onClick: Button has been pressed");
                //editTextId.setText("The large text has been changed");
                new Cari.JSONTask().execute("http://192.168.1.15/Data/retrieve.php?nama="+editTextId.getText().toString().trim());
            }
        });

        //new Cari.JSONTask().execute("http://sipkopas.pasuruankota.go.id/json/retrieve.php?kec=");
    }


    public  class JSONTask extends AsyncTask<String, String, List<ModelData>> {
        List<ModelData> Listdata1 = new ArrayList<>();
        @Override
        //Menampilkan progress dialog
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(Cari.this);
            pDialog.setMessage("Tunggu ya ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected List<ModelData> doInBackground(String... params){
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("datapetakel");

                //Bundle data = getIntent().getExtras() ;

                for (int i = 0; i<parentArray.length(); i++){
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    ModelData data1 = new ModelData();

                    data1.setJenis(finalObject.getString("jenis"));
                    data1.setNama(finalObject.getString("nama"));
                    data1.setAlamat(finalObject.getString("alamat"));
                    data1.setLat(finalObject.getString("lat"));
                    data1.setLng(finalObject.getString("lng"));

                    Listdata1.add(data1);

                    return  Listdata1;
                }

            }catch (MalformedInputException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null){
                    connection.disconnect();
                }
                try {
                    if (reader != null){
                        reader.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected  void onPostExecute (List<ModelData> result){
            super.onPostExecute(result);
            Adapt petaAdapter = new Adapt(getApplicationContext(), R.layout.cari_row_data, result);
            listView.setAdapter(petaAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String kode_ang = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                    Intent in = new Intent(getApplicationContext(), DetailCari.class);
                    ModelData listdetail = Listdata1.get(position);
                    in.putExtra("jenis", listdetail.getJenis());
                    in.putExtra("nama", listdetail.getNama());
                    in.putExtra("alamat", listdetail.getAlamat());
                    in.putExtra("lat", listdetail.getLat());
                    in.putExtra("lng", listdetail.getLng());

                    startActivity(in);
                }
            });

        }
    }


}