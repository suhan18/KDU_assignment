import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class pop_merch {
    public static void main(String[] args) {
        HashMap<String, Integer> item_map = new HashMap<>();
        try {
            Scanner obj = new Scanner(new File("items.csv"));
            while (obj.hasNextLine()) {
                String line = obj.nextLine();
                String[] items = line.split(",");

                for (String item : items) {
                    item = item.trim();
                    if (item_map.containsKey(item)) {
                        item_map.put(item, item_map.get(item) + 1);
                    } else {
                        item_map.put(item, 1);
                    }
                }
            }
            obj.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(item_map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        System.out.println("Top 3 merchandise items:");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
    }
}
