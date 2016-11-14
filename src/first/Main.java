package first;

/**
 * Created by nicasandra on 10/31/2016.
 */
public class Main {
    public static void main(String[] args) {
        Queue<String> list = new Queue<String>();
        list.add("Elem 0");
        list.add("Elem 1");
        list.add("Elem 2");
        list.add("Elem 3");
        list.add("Elem 4");
        System.out.println(list.size());
        System.out.println(list.getFromIndex(3));
        System.out.println(list.toStr());
    }
}
