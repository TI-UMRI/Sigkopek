package id.iwanbazz.dev.sigkopek;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Indi Winona on 9/6/2016.
 */
public class AlertDialogManager {

    public void showAlertDialog (Context context, String title, String message, Boolean status){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        if (status != null)
            alert.setIcon((status)?R.drawable.ic_place:R.drawable.fasum);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.create().show();
    }
}
