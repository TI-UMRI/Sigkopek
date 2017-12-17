package id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.iwanbazz.dev.sigkopek.Model.ModelData;
import id.iwanbazz.dev.sigkopek.Model.PetaAdapter;
import id.iwanbazz.dev.sigkopek.R;
import id.iwanbazz.dev.sigkopek.SubKategori.Detail;

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
 * Created by Anisah Denis on 8/23/2016.
 */
public class Data_Kelurahan extends AppCompatActivity {

    ListView listView;

    public  static String no = "no";
    public  static String nama = "nama";
    public  static String alamat = "alamat";
    public  static String notelp = "notelp";
    public  static String lat = "lat" ;
    public  static String lng = "lng";
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data);

        listView = (ListView)findViewById(R.id.listView1);

        new JSONTask().execute("http://sipkopas.pasuruankota.go.id/json/datapetakel.php");
    }
    public  class JSONTask extends AsyncTask<String, String, List<ModelData>> {
        List<ModelData> Listdata1 = new ArrayList<>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Data_Kelurahan.this);
            pDialog.setMessage("loading data .......");
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

                // StringBuffer finalBuffer = new StringBuffer();
                for (int i = 0; i<parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    ModelData data1 = new ModelData();


                    data1.setNo(finalObject.getString("no"));
                    data1.setNama(finalObject.getString("nama"));
                    data1.setAlamat(finalObject.getString("alamat"));
                    data1.setNotelp(finalObject.getString("notelp"));
                    data1.setLat(finalObject.getString("lat"));
                    data1.setLng(finalObject.getString("lng"));


                    // finalBuffer.append(id_1 + " - " + nama + " - "  + latitude + " - " + longitude + " \n");
                    Listdata1.add(data1);
                }
                //return finalBuffer.toString();
                //       return buffer.toString();
                return  Listdata1;

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
        protected  void onPostExecute (List<ModelData> result) {
            super.onPostExecute(result);
            final PetaAdapter petaAdapter = new PetaAdapter(getApplicationContext(), R.layout.row_data, result);
            listView.setAdapter(petaAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                                                    Intent in = new Intent(getApplicationContext(), Detail.class);
                                                    ModelData listdetail = Listdata1.get(position);

                                                    in.putExtra("no", listdetail.getNo());
                                                    in.putExtra("nama", listdetail.getNama());
                                                    in.putExtra("alamat", listdetail.getAlamat());
                                                    in.putExtra("notelp", listdetail.getNotelp());
                                                    in.putExtra("lat", listdetail.getLat());
                                                    in.putExtra("lng", listdetail.getLng());

                                                    startActivity(in);
                                                }
                                            }
            );


        }

    }



}