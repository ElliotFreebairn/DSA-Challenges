
public class InsertionSort {
  public static void main(String[] args) {
    int arr[] = {15, 23, 6, 1, 0, 58, 15, 20, 100};
    int n = arr.length;
    
    InsertionSort obj = new InsertionSort();
    obj.sort(arr);

    for(int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    System.out.println();
  }

  public void sort(int arr[]) {
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
}
