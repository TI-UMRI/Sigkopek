package id.iwanbazz.dev.sigkopek.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import id.iwanbazz.dev.sigkopek.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PengaduanFragment extends Fragment implements View.OnClickListener {


    Button butKrim;
    EditText eNama, ePesan, eHp;
    ProgressDialog pdialog = null;
    Context context = null;
    ImageView sip;

    DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
    int screenHeight = displaymetrics.heightPixels;
    int screenWidth = displaymetrics.widthPixels;



    public PengaduanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.pengaduan, container, false);

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(getActivity(), "Screen switched to Landscape mode", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "Screen switched to Portrait mode", Toast.LENGTH_SHORT).show();


        sip = (ImageView) view.findViewById(R.id.logo);
        int imgHeight = (int) (screenHeight* 0.15);
        int imgWidth = (int) (screenWidth* 0.15);
        sip.getLayoutParams().height = imgHeight;
        sip.getLayoutParams().width = imgWidth;

        butKrim =(Button)view.findViewById(R.id.buttonSend);
        eHp =(EditText)view.findViewById(R.id.tlp);
        eNama =(EditText)view.findViewById(R.id.nama);
        ePesan =(EditText)view.findViewById(R.id.pesan);
        butKrim.setOnClickListener(this);

        return view;

    }
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"pde@pasuruankota.go.id"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Pengaduan dari "+ eNama.getText());
                i.putExtra(Intent.EXTRA_TEXT, "Nama : "+ eNama.getText()+"\nNo. Telp / Hp : "+eHp.getText()+"\nPesan Pengaduan : "+ePesan.getText());
                try {
                    startActivity(Intent.createChooser(i, "Pilih Email Client..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "Tidak ada email client yang terinstall. Silahkan install terlebih dahulu", Toast.LENGTH_SHORT).show();
                }

    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {


            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            Toast.makeText(getActivity(), "Pesan Anda Terkirim\nTerima Kasih", Toast.LENGTH_LONG).show();

        }
    }
}
