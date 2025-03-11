

public class QuickSort {
  public static void main(String[] args) {
    int[] unsortedArray = {5, 2, 100, 50, 3, 7, 1, 20, 100, 56, 0};
    QuickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
    QuickSort.displayArr(unsortedArray);
  }

  public static void sort(int[] a, int l, int r) {
    if(l < r) {
      int m = partition(a,l,r);
      sort(a, l, m - 1);
      sort(a, m + 1, r); 
    }
  }
  
  public static int partition(int[] a, int l, int r) {
    int pivot = a[r];
    int i = l;

    for(int j = l; j < r; j++) {
      if(a[j] <= pivot) {
        swap(a, i, j);
        i += 1;
      }
    }
    swap(a, i, r);
    return i;
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void displayArr(int[] a) {
    for(int num : a) {
      System.out.println(num + " ");
    }
  }

  
}
