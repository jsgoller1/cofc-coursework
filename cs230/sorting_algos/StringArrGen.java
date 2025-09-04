package sorting_algos;

import java.util.Random;

public class StringArrGen {
    String[] generate(int size) {
        Random rand = new Random();

        // Size and bound will be equal; the array will contain no empty space
        String strings[] = new String[size];
        for (int i = 0; i < size; i++) {
            int string_size = rand.nextInt(10);
            char[] char_arr = new char[string_size];
            for (int j = 0; j < string_size; j++) {
                char_arr[j] = (char) ('a' + rand.nextInt(26));
            }
            strings[i] = new String(char_arr);
        }
        return strings;
    }

    void display(String[] strings) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s ", strings[i]);
        }
        System.out.println();

    }
}
