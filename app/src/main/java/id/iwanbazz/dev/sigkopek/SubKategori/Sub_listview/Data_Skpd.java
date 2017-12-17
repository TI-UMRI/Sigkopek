package id.iwanbazz.dev.sigkopek.SubKategori.Sub_listview;

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
 * Created by Anisah Denis on 9/2/2016.
 */
public class Data_Skpd extends AppCompatActivity {


    ListView listView;
    public  static String no = "no";
    public  static String nama = "nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data);


        listView = (ListView)findViewById(R.id.listView1);
        new JSONTask().execute("http://sipkopas.pasuruankota.go.id/json/dataskpd.php");
       // new JSONTask().execute("http://192.168.1.15/Data/dataskpd.php");

    }
    public  class JSONTask extends AsyncTask<String, String, List<ModelData>> {
        List<ModelData> Listdata1 = new ArrayList<>();
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
                JSONArray parentArray = parentObject.getJSONArray("dataskpd");

             //   List<ModelData> Listdata1 = new ArrayList<>();
                Bundle data = getIntent().getExtras() ;
                // Intent intent =getIntent();
                String badan= data.getString("badan");
                String dinas= data.getString("dinas");
                String kantor= data.getString("kantor");
                String kecamatan= data.getString("kecamatan");


                if (dinas !=null) {
                    for (int i = 0; i<12; i++){
                        JSONObject finalObject = parentArray.getJSONObject(i);
                        ModelData data1 = new ModelData();

                        data1.setNo(finalObject.getString("no"));
                        data1.setNama(finalObject.getString("nama"));
                        data1.setAlamat(finalObject.getString("alamat"));
                        data1.setNotelp(finalObject.getString("notelp"));
                        data1.setLat(finalObject.getString("lat"));
                        data1.setLng(finalObject.getString("lng"));

                        Listdata1.add(data1);
                    }

                    return  Listdata1;

                }else if (badan !=null) {
                    for (int i = 12; i<20; i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);
                        ModelData data1 = new ModelData();

                        data1.setNo(finalObject.getString("no"));
                        data1.setNama(finalObject.getString("nama"));
                        data1.setAlamat(finalObject.getString("alamat"));
                        data1.setNotelp(finalObject.getString("notelp"));
                        data1.setLat(finalObject.getString("lat"));
                        data1.setLng(finalObject.getString("lng"));

                        Listdata1.add(data1);
                    }

                    return  Listdata1;

                }else if (kantor !=null) {
                    for (int i = 20; i < 24; i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);
                        ModelData data1 = new ModelData();

                        data1.setNo(finalObject.getString("no"));
                        data1.setNama(finalObject.getString("nama"));
                        data1.setAlamat(finalObject.getString("alamat"));
                        data1.setNotelp(finalObject.getString("notelp"));
                        data1.setLat(finalObject.getString("lat"));
                        data1.setLng(finalObject.getString("lng"));

                        Listdata1.add(data1);

                    }
                    return Listdata1;
                }else if (kecamatan !=null){
                    for (int i = 20; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);
                        ModelData data1 = new ModelData();

                        data1.setNo(finalObject.getString("no"));
                        data1.setNama(finalObject.getString("nama"));
                        data1.setAlamat(finalObject.getString("alamat"));
                        data1.setNotelp(finalObject.getString("notelp"));
                        data1.setLat(finalObject.getString("lat"));
                        data1.setLng(finalObject.getString("lng"));

                        Listdata1.add(data1);

                    }
                    return Listdata1;
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
        protected  void onPostExecute (List<ModelData> result) {
            super.onPostExecute(result);
            PetaAdapter petaAdapter = new PetaAdapter(getApplicationContext(), R.layout.row_data, result);
            listView.setAdapter(petaAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                                    //String kode_ang = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
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

