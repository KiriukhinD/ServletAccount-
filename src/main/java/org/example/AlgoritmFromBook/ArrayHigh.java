package org.example.AlgoritmFromBook;

public class ArrayHigh {
    private long[] a;
    private int nElems;
    private String name;
    public ArrayHigh(int max) {
        a = new long[max];
        nElems = 0;
        name = "lora";
    }
    public void insert(int value) {
        a[nElems] = value;
        nElems++;
    }

    public int findBin(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn; // Элемент найден

            else if (lowerBound > upperBound)
                return nElems; // Элемент не найден
            else // Деление диапазона
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    public boolean find(long searchKey) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] == searchKey) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else return true;
    }



    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else for (int k = j; k < nElems; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
        return true;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayHigh arrayHigh = new ArrayHigh(10);
        ArrayHigh arrayHighTwo = new ArrayHigh(15);
        arrayHigh.insert(1);
        arrayHigh.insert(2);
        arrayHigh.insert(3);
        arrayHighTwo.insert(666);
        arrayHigh.insert(4);
        arrayHigh.insert(5);
        arrayHigh.insert(6);
        arrayHigh.insert(7);
        arrayHigh.insert(8);
        arrayHigh.insert(9);
        arrayHigh.insert(10);

        System.out.println(arrayHigh.findBin(1));
        System.out.println(arrayHigh.hashCode());

    }

}


