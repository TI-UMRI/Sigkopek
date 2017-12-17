package id.iwanbazz.dev.sigkopek.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.iwanbazz.dev.sigkopek.Cari;

/**
 * A simple {@link Fragment} subclass.
 */
public class PencarianFragment extends Fragment {


    public PencarianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.cari, container, false);
        Intent intent = new Intent(getActivity(), Cari.class);
        getActivity().startActivity(intent);
        return null;
    }

}
