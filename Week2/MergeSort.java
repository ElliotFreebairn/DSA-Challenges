
public class MergeSort {
  public static void main(String[] args) {
    int[] unsorted = {5, 10, 1 , 7, 100, 50, 23 ,32};
    MergeSort.sort(unsorted, 0, unsorted.length - 1);
    for(int i = 0; i < unsorted.length; i++) {
      System.out.println(unsorted[i]);
    }
  }

  public static void sort(int[] a, int l, int r) {
    if(l < r) {
      int middle = (l + r) / 2;
      sort(a, l, middle);
      sort(a, middle + 1, r);
      merge(a, l, middle, r);
    }
  }

  public static void merge(int[] a, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int[] leftA = new int[n1 + 1];
    int[] rightA = new int[n2 + 1];

    for(int i = 0; i < n1; i++)
      leftA[i] = a[l + i];
  
    for(int j = 0; j < n2; j++)
      rightA[j] = a[m + 1 + j];

    leftA[n1] = Integer.MAX_VALUE;
    rightA[n2] = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;
    for(int k = l; k <= r; k++) {
      if(leftA[i] <= rightA[j]) {
        a[k] = leftA[i];
        i = i + 1;
      } else {
        a[k] = rightA[j];
        j = j + 1;
      }
    }
  }
}
