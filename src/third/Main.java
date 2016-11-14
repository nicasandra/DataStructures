package third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nick on 11/13/2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();

        String fromFile = Util.fromFileToString("date.in");
        System.out.print("The word: ");
        String fromKeyboard = scan.nextLine();

        for (int i = 0, j = 0; i < fromFile.length() && j < fromKeyboard.length(); i++, j++) {
            values.add(fromFile.charAt(i) ^ fromKeyboard.charAt(j));
            if (j == fromKeyboard.length() - 1) {
                j = -1;
            }
        }

        for (Integer val : values) {
            System.out.print(val + " ");
        }

    }
}