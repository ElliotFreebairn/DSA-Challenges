
public class InsertionSort {
  public static void main(String[] args) {
    int arr[] = {15, 23, 6, 1, 0, 58, 15, 20, 100};
    int n = arr.length;
    
    InsertionSort sorting = new InsertionSort();
    sorting.selectionSort(arr);


    for(int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    System.out.println();
  }

  public void insertionSort(int arr[]) {
    int n = arr.length;
    for(int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;

      while(j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j -1;
      }
      arr[j + 1] = key;
    }
  }

  public void selectionSort(int arr[]) {
    int n = arr.length;
    for(int i = 0; i < n; i++) {
      int smallestIndex = i;
      for(int j = i + 1; j < n; j++) {
        System.out.print("i " + i + " j" + j +"\n");
        if(arr[j] < arr[smallestIndex]) {
          System.out.println("arr[j] " + arr[j] + " <  array[i] " + arr[i] + "\n");
          smallestIndex = j;
        }
      }
      if(smallestIndex != -1) {
        System.out.println("smallest val " + arr[smallestIndex] + "\n");
        int tempKey = arr[i];
        arr[i] = arr[smallestIndex];
        arr[smallestIndex] = tempKey;
      }
    }
  }
}
