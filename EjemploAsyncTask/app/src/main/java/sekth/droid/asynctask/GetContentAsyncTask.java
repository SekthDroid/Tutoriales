package sekth.droid.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by SekthDroid on 29/10/15.
 */
public class GetContentAsyncTask extends AsyncTask<Void, Void, String[]> {
    private String[] SYSTEMS = {"Ubuntu", "Android", "iOS", "Windows", "Mac OSX",
            "Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix"};

    public interface OnLoadFinishedListener{
        void onFinish(String[] data);
    }

    private Context context;
    private OnLoadFinishedListener listener;
    private ProgressDialog pDialog;

    public GetContentAsyncTask(Context context, OnLoadFinishedListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.i("AsyncTask PreExecute", "Entra en PreExecute");
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Cargando Lista");
        pDialog.setCancelable(true);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.show();
    }

    @Override
    protected String[] doInBackground(Void... arg0) {
        // Simulate an internet request
        try{
            Thread.sleep(2000);
        }catch(Exception ex){
            ex.printStackTrace();
            return new String[]{};
        }

        return SYSTEMS;
    }

    @Override
    protected void onPostExecute(String[] result) {
        super.onPostExecute(result);
        pDialog.dismiss();
        if (listener != null){
            listener.onFinish(result);
        }
    }

}