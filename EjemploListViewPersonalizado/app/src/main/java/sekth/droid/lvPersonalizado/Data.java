package sekth.droid.lvPersonalizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SekthDroid on 26/10/15.
 */
public class Data {

    public static List<Item> generateItems(int quantity){
        Random random = new Random();
        List<Item> items = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            long id = random.nextInt(100);
            String nombre = "Cliente numero: " + id;
            items.add(new Item(id, nombre));
        }
        return items;
    }
}
