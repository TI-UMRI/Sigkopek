package id.iwanbazz.dev.sigkopek.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.R;

import java.util.List;

/**
 * Created by Anisah Denis on 9/2/2016.
 */
public class PetaAdapter extends ArrayAdapter {

    private List<ModelData> model_datapetakelList;
    private int resource ;
    private LayoutInflater inflater;


    public PetaAdapter(Context context, int resource, List <ModelData>objects) {
        super(context, resource, objects);
        model_datapetakelList = objects;
        this.resource = resource;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView (int position, View convertView , ViewGroup parent){
        //  return super.getView(position, convertView, parent);
        if (convertView == null){
            convertView =  inflater.inflate(resource, null);
        }

        TextView lv ;

        lv = (TextView) convertView.findViewById(R.id.nama);
        lv.setText(model_datapetakelList.get(position).getNama());

        return convertView;

    }
}
