package org.example.AlgoritmFromBook;

import java.util.HashMap;
import java.util.Map;

public class BubbleSortMain {
    private String name;
    int count = 0;

    public BubbleSortMain(String name) {
        this.name = name;
    }

    public void recurs() {

        if (count == 100) {
            System.out.println("Return : []");
            return;
        } else {
            System.out.println(count + " i am recurs");
            count++;
            recurs();
        }
    }

    @Override
    public String toString() {
        return " name  = " + name;
    }

    public static void main(String[] args) {
        BubbleSortMain bubbleSortMainOne = new BubbleSortMain("lola");
        BubbleSortMain bubbleSortMainTwo = new BubbleSortMain("greg");
        Map<String, BubbleSortMain> map = new HashMap<>();
        map.put("1989780873", bubbleSortMainOne);
        map.put("1480010240", bubbleSortMainTwo);

        System.out.println(map.get("1989780873"));
        System.out.println(map.get("1480010240"));

    }
}
