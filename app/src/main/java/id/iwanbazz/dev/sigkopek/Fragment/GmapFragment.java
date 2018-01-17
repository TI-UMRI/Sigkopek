package id.iwanbazz.dev.sigkopek.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.iwanbazz.dev.sigkopek.MapsActivity2;
import id.iwanbazz.dev.sigkopek.MapsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GmapFragment extends Fragment {

    public GmapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       // View view = inflater.inflate(R.layout.activity_maps,  null);

       Intent intent = new Intent(getActivity(), MapsActivity.class);
        getActivity().startActivity(intent);


        return null;
    }
}



   /* @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // FragmentManager fragmentManager = getChildFragmentManager();
        // MapFragment fragment = (MapFragment)getFragmentManager().findFragmentById(R.id. map2);


        SupportMapFragment supportMapFragment;
        supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map2);
        supportMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng pas = new LatLng(-7.64280732732681,112.892977148294);
        mMap.addMarker(new MarkerOptions().position(pas).title("Gentong Pasuruan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pas, 14));

    }*/
//}

