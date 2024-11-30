package arrays;

/**
 * @author Miroslav Kološnjaji
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.insert(5);
        arrayList.insert(2);
        arrayList.insert(3);
        System.out.println(arrayList);
        arrayList.insert(3);
        arrayList.insert(7);
        System.out.println(arrayList);
        arrayList.removeAt(1);
        System.out.println(arrayList);
        arrayList.removeAt(2);
        System.out.println(arrayList);
    }
}
