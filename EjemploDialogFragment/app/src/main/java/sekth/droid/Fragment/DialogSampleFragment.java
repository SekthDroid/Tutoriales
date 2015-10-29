package sekth.droid.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogSampleFragment extends DialogFragment {
    private static final String TAG = DialogSampleFragment.class.getSimpleName();

    private OnDialogSampleListener listener;

    public static DialogSampleFragment createDialog(String title) {
        DialogSampleFragment fragment = new DialogSampleFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.listener = (OnDialogSampleListener) activity;
        }catch (ClassCastException ex){
            Log.e(TAG, "Your activity does not implements the OnDialogSampleListener interface");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_launcher)
                .setTitle(title)
                .setPositiveButton(android.R.string.ok, positiveListener)
                .setNegativeButton(android.R.string.cancel, negativeListener)
                .create();
    }

    private DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (listener != null){
                listener.onPositiveClick();
            }
        }
    };

    private DialogInterface.OnClickListener negativeListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (listener != null){
                listener.onNegativeClick();
            }
        }
    };

    public interface OnDialogSampleListener{
        void onPositiveClick();
        void onNegativeClick();
    }
}
