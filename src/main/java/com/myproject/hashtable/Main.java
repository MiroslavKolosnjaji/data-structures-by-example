package hashtable;

import java.util.*;

/**
 * @author Miroslav Kološnjaji
 */
public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(1, "Mark");
        table.put(6, "John");
        table.put(12, "Anne");
        table.put(18, "Josephine");
        table.put(16, "Saquil");
        table.put(5, "Jamila");
        table.remove(16);
        System.out.println(table);
        System.out.println(table.get(5));

    }

    public static void findFirstNonrepeatedChar(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char[] characters = input.toCharArray();
        for (Character ch : characters) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                Integer x = map.get(ch);
                map.replace(ch, x + 1);
            }
        }

        int index = 0;

        for (var ch : characters){

            if(map.get(ch) == 1){
                System.out.println(ch);
                break;
            }

//            for (var item : map.entrySet()) {
//                if (ch == item.getKey() && item.getValue() == 1) {
//                    System.out.println(item);
//                    return;
//                }
//            }
        }



    }

    public static void findFirstRepeatedChar(String input){
        Set<Character> set= new HashSet<>();
        for (Character ch : input.toCharArray()){
            if(set.contains(ch)){
                System.out.println(ch);
                break;
            }
            set.add(ch);
        }
    }
}
