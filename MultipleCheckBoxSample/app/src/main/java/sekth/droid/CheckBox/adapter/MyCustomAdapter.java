package sekth.droid.CheckBox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sekth.droid.CheckBox.R;
import sekth.droid.CheckBox.model.Item;

public class MyCustomAdapter extends ArrayAdapter<Item> {
    private final static String TAG = MyCustomAdapter.class.getSimpleName();
    private final LayoutInflater inflater;
    private List<Item> mListaItems;

    static class ViewHolder {
        TextView tvNombre;
        TextView tvDetalle;
        CheckBox chkBox;

        public static ViewHolder generateView(View convertView) {
            ViewHolder holder = new ViewHolder();

            holder.tvNombre = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvDetalle = (TextView) convertView.findViewById(R.id.tv_detail);
            holder.chkBox = (CheckBox) convertView.findViewById(R.id.cb_option);

            return holder;
        }
    }

    public MyCustomAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
        this.mListaItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_row, parent, false);
            holder = ViewHolder.generateView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = mListaItems.get(position);
        bindItemTo(holder, item);

        return convertView;
    }

    private void bindItemTo(ViewHolder holder, Item item) {
        holder.tvNombre.setText(item.getName());
        holder.tvDetalle.setText(item.getDetalles());
        holder.chkBox.setChecked(item.isSelected());
    }

    public void checkItem(int position) {
        Item item = mListaItems.get(position);
        item.setSelected(!item.isSelected());
        this.notifyDataSetChanged();
    }

    public List<Item> getAllChecked() {
        List<Item> mListaCheckedItems = new ArrayList<>();
        for (Item item : mListaItems) {
            if (item.isSelected()) {
                mListaCheckedItems.add(item);
            }
        }
        return mListaCheckedItems;
    }
}
