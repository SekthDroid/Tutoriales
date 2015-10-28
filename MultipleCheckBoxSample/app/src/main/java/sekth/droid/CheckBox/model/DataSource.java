package sekth.droid.CheckBox.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SekthDroid on 28/10/15.
 */
public class DataSource {
    public static List<Item> getStubData(int quantity) {
        List<Item> items = new ArrayList<>(quantity);
        String name = "Item %s";
        String detail = "Detalles del %d";
        for (int i = 1; i <= quantity; i++){
            Item newItem = new Item(i, buildDataWith(name, i), buildDataWith(detail, i));
            items.add(newItem);
        }
        return items;
    }

    private static String buildDataWith(String name, int i) {
        return String.format(name, i);
    }
}
