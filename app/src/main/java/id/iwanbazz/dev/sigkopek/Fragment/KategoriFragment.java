package id.iwanbazz.dev.sigkopek.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import id.iwanbazz.dev.sigkopek.R;
import id.iwanbazz.dev.sigkopek.SubKategori.SubFasum;
import id.iwanbazz.dev.sigkopek.SubKategori.SubKesehatan;
import id.iwanbazz.dev.sigkopek.SubKategori.SubPemerintahan;
import id.iwanbazz.dev.sigkopek.SubKategori.SubPendidikan;


public class KategoriFragment extends Fragment implements ImageButton.OnClickListener {


    public KategoriFragment() {
        // Required empty public constructor
    }

    DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
    int screenHeight = displaymetrics.heightPixels;
    int screenWidth = displaymetrics.widthPixels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kategori, container, false);


        //Activity rootView;
        ImageButton button1, button2, button3, button4;
        ImageView pem, kes, pend, fas;

        button1 = (ImageButton) view.findViewById(R.id.buttonPem);
        button1.setOnClickListener(this);
        button2 = (ImageButton) view.findViewById(R.id.buttonKes);
        button2.setOnClickListener(this);
        button3 = (ImageButton) view.findViewById(R.id.buttonPend);
        button3.setOnClickListener(this);
        button4 = (ImageButton) view.findViewById(R.id.buttonFasum);
        button4.setOnClickListener(this);

        pem = (ImageView) view.findViewById(R.id.pem);
        pend = (ImageView) view.findViewById(R.id.kes);
        kes = (ImageView) view.findViewById(R.id.pend);
        fas = (ImageView) view.findViewById(R.id.fas);

        int imgHeight = (int) (screenHeight* 0.25);
        int imgWidth = (int) (screenWidth* 0.25);
        pem.getLayoutParams().height = imgHeight;
        pem.getLayoutParams().width = imgWidth;
        pend.getLayoutParams().height = imgHeight;
        pend.getLayoutParams().width = imgWidth;
        kes.getLayoutParams().height = imgHeight;
        kes.getLayoutParams().width = imgWidth;
        fas.getLayoutParams().height = imgHeight;
        fas.getLayoutParams().width = imgWidth;

        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked

        //int id = item.getItemId();



            switch (v.getId()){
                case R.id.buttonPem:

                //SubKategori = new SubKategoriFragment();

                //fragmentTransaction.replace(R.id.fragment_contain, SubKategori);
                //fragmentTransaction.addToBackStack(null);

                //fragmentTransaction.commit();
                Intent intent;
                /// intent = new Intent((getParentFragment().getActivity()), subKategori.class);
                intent = new Intent(getActivity(), SubPemerintahan.class);
                getActivity().startActivity(intent);
                // Toast.makeText(getContext(),"coba",Toast.LENGTH_SHORT).show();

                    break;
                //   case R.id.textView_settings:
                //     switchFragment(SettingsFragment.TAG);

                case R.id.buttonKes:
                    Intent intent2;
                    /// intent = new Intent((getParentFragment().getActivity()), subKategori.class);
                    intent2 = new Intent(getActivity(), SubKesehatan.class);
                    getActivity().startActivity(intent2);
                    break;

                case R.id.buttonPend:
                    Intent intent3 = new Intent(getActivity(), SubPendidikan.class);
                    getActivity().startActivity(intent3);
                    break;

                case R.id.buttonFasum:
                    Intent intent4 = new Intent(getActivity(), SubFasum.class);
                    getActivity().startActivity(intent4);
                    break;

        }
    }
}

