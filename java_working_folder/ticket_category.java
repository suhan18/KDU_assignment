import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class ticket_category {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList<String> category_arr = new ArrayList<>();
        HashSet<String> category_set = new HashSet<>();
        HashMap<String, Integer> category_map = new HashMap<>();
        System.out.println("Enter the categories");
        for (int i = 0; i < 10; i++) {
            String str = obj.nextLine();
            category_arr.add(str);
            category_set.add(str);

            if (category_map.containsKey(str)) {
                category_map.put(str, category_map.get(str) + 1);
            } else {
                category_map.put(str, 1);
            }
        }
        System.out.println("ArrayList: " + category_arr);
        System.out.println("HashSet: " + category_set);
        System.out.println("HashMap: " + category_map);
        obj.close();
    }
}
