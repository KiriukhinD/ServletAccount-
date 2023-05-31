package org.example.AlgoritmFromBook;

public class BubbleSort {
    private long[] array;
    private int nElement;

    public BubbleSort(int value) {
        array = new long[value];
        nElement = 0;
    }

    public long getArrayValue(int index) {
        return array[index];
    }

    public void insert(int value) {
        array[nElement] = value;
        nElement++;
    }

    public int getElement() {
        return nElement;
    }

    public long[] getArray() {
        return array;
    }

    public void findBin(int searchValue) {
        int low = 0;
        int upper = nElement - 1;
        int sum;

        while (true) {

            sum = (low + upper) / 2;

            if (array[sum] == searchValue) {
                System.out.println("I am find element " + sum);
            }
            if (array[sum] < searchValue) {
                sum = low + sum;
            } else if (array[sum] > searchValue) {
                sum = upper - sum;
            }
        }
    }
  public void bubbleSort(){
        int out,in;
        for(out = nElement -1 ;out>1;out--){
               for (in = 0 ;in<out;in++){
                if(array[in]>array[in+1]){
                     swap(in,in+1);
                }
               }
        }
  }
  private void swap(int one,int two){
        long temp = array[one];
        array[one]=array[two];
        array[two]=temp;
  }

}
