package sekth.droid.lvPersonalizado;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Item> items;
    private LayoutInflater mInflater;

    public MyAdapter(Activity activity, List<Item> items) {
        this.items = items;
        this.mInflater = LayoutInflater.from(activity);
    }

    /**
     * Clase ViewHolder
     * Se encarga de guardar la información
     * de cada fila, para poder reciclarla mas tarde
     *
     * @author sekth
     */
    public static class ViewHolder {
        public TextView tvId;
        public TextView tvName;

        public static ViewHolder generateView(View convertView){
            ViewHolder holder = new ViewHolder();
            holder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            return holder;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        if (v == null) {
            // Se infla la View con nuestro layout eprsonalizado
            v = mInflater.inflate(R.layout.row_item, parent, false);

            viewHolder = ViewHolder.generateView(v);

            v.setTag(viewHolder);
        } else {
            // Si ya había sido reciclada, la obtenemos
            viewHolder = (ViewHolder) v.getTag();
        }

        // Establecemos los valores del ID y el Nombre
        final Item item = items.get(position);

        // Si el item existe, establecemos sus valores
        bindItemTo(viewHolder, item);

        // Retornamos la View
        return v;
    }

    private void bindItemTo(ViewHolder viewHolder, Item item) {
        viewHolder.tvId.setText(String.format("Id: %d", item.getId()));
        viewHolder.tvName.setText(item.getName());
    }

    /**
     * Retorna el número de elementos en el adapter
     */
    @Override
    public int getCount() {
        return items.size();
    }

    /**
     * Retorna el item en la posición deseada
     */
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    /**
     * Retorna el ID de nuestro Item
     * en la posición dada
     */
    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

}
