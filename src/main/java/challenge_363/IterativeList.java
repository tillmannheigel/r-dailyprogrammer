package challenge_363;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

public class IterativeList {

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("src/main.java.challenge_363/enable1.txt");
        BufferedReader buffer = new BufferedReader(reader);
        Iterative iterative = new Iterative();
        buffer.lines()
                .map(line -> Collections.singletonMap(line, iterative.check(line)))
                .filter(entry -> entry.containsValue(false))
                .forEach(entry -> System.out.println(entry));

        reader = new FileReader("src/main.java.challenge_363/enable1.txt");
        buffer = new BufferedReader(reader);

        long count = buffer.lines()
                .map(line -> Collections.singletonMap(line, iterative.check(line)))
                .filter(entry -> entry.containsValue(false))
                .count();
        System.out.println("There are " + count + " exceptions!");
    }
}
