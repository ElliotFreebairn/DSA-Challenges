

public class HeapSort {

  public static void heapsort(int[] arr) {
    System.out.println("------------------------------------ Unsorted Array-----------------------------------------------------\n\n");
    for(int num : arr) {
      System.out.print("|" + num + "| ");
    }
    System.out.println();

    buildMaxHeap(arr); 
    System.out.println("\n\n------------------------------------ Sorted via heap sort ----------------------------------------------\n\n");

    for(int i = arr.length - 1; i >= 1; i--) {
      arr[i] = extractMax(arr, i + 1);
    }

    for(int num : arr) {
      System.out.print("|" + num + "| ");
    }
  }

  private static void buildMaxHeap(int[] arr) {
    for(int i = arr.length / 2 - 1; i >= 0; i--) {
      maxHeapify(arr, i, arr.length);
    }
  }

  private static void maxHeapify(int[] arr, int originalIndex, int arrSize) {
    int leftChild = originalIndex * 2 + 1;
    int rightChild = (originalIndex * 2) + 2;
    int bigIndex = originalIndex;

    if(leftChild < arrSize && arr[leftChild] > arr[bigIndex]) {
      bigIndex = leftChild;
    }
    if(rightChild < arrSize && arr[rightChild] > arr[bigIndex]) {
      bigIndex = rightChild;
    }

    if(bigIndex != originalIndex){
      swap(arr, originalIndex, bigIndex);
      maxHeapify(arr, bigIndex, arrSize);
    }
  }

  private static void swap(int[] arr, int originalIndex, int bigIndex) {
    int tempVal = arr[originalIndex];
    arr[originalIndex] = arr[bigIndex];
    arr[bigIndex] = tempVal;
  }
  
  private static int findMax(int[] arr) {
    return arr[0];
  }

  private static int extractMax(int[] arr, int arrSize) {
    if(arrSize < 0) {
      throw new IndexOutOfBoundsException("arr is of length: " + arr.length + ". Nothing to find");
    } 

    int max = findMax(arr);
    swap(arr, 0, arrSize - 1);
    maxHeapify(arr, 0, arrSize - 1);

    return max;
  }

  public static void main(String[] args) {
    int[] arr = {10, 5, 100, 1, 3, 7, 4, 90, 500, 2, 5, 1000, 200, 6, 9};
    HeapSort.heapsort(arr);
  }
}
