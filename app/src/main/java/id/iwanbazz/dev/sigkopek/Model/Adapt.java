package id.iwanbazz.dev.sigkopek.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import id.iwanbazz.dev.sigkopek.R;

import java.util.List;

public class Adapt extends ArrayAdapter {

    private List<ModelData> model_datapetakelList;
    private int resource ;
    private LayoutInflater inflater;


    public Adapt(Context context, int resource, List <ModelData>objects) {
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

        TextView vnama, valamat, vjenis, vlat, vlng ;

        vjenis = (TextView) convertView.findViewById(R.id.hasiljenis);
        vnama = (TextView) convertView.findViewById(R.id.hasilnama);
        valamat = (TextView) convertView.findViewById(R.id.hasilalamat);
        vlat = (TextView) convertView.findViewById(R.id.hasillat);
        vlng = (TextView) convertView.findViewById(R.id.hasillng);

        vjenis.setText(model_datapetakelList.get(position).getJenis());
        vnama.setText(model_datapetakelList.get(position).getNama());
        valamat.setText(model_datapetakelList.get(position).getAlamat());
        vlat.setText( model_datapetakelList.get(position).getLat());
        vlng.setText( model_datapetakelList.get(position).getLng());

        return convertView;

    }
}