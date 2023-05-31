package org.example.AlgoritmFromBook;

public class AlgoritmTestBook {
    int a ;
    int[] arr;

    public static void main(String[]args){
          AlgoritmTestBook algoritmTestBook = new AlgoritmTestBook();

          algoritmTestBook.arr=new int[10];
        System.out.println(algoritmTestBook.arr[0] = 10);
        System.out.println(algoritmTestBook.arr[1] = 66);
        System.out.println(algoritmTestBook.arr[2] = 88);
        System.out.println(algoritmTestBook.arr[3] = 190);
for(int i  = 0;i<algoritmTestBook.arr.length;i++){
    if(algoritmTestBook.arr[i] != 0){
        System.out.print(algoritmTestBook.arr[i]+" ");
    } else System.err.print(" null ");
}
    }

}
