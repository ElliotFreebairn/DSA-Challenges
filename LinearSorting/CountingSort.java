public class CountingSort {

  public static void main(String[] args) {
    int[] arr = {3, 0, 4, 1, 3, 4, 1, 4};
    int[] outputArr = new int[arr.length];

    CountingSort.countingSort(arr, outputArr, 4);
    for(int num : outputArr) {
      System.out.print(num + " ");
    }
  }

  public static void countingSort(int[] inputArr, int[] outputArr, int k) {
    int[] countArr = new int[k + 1];  

    for(int j = 0; j < inputArr.length; j++) {
      countArr[inputArr[j]] = countArr[inputArr[j]] + 1;
    }
    
    for(int i = 1; i <= k; i++) {
      countArr[i] = countArr[i] + countArr[i - 1];
    }
    
    for(int j = inputArr.length - 1; j >= 0; j--) {
      outputArr[countArr[inputArr[j]] - 1] = inputArr[j];
      countArr[inputArr[j]] -= 1;
    }
  }  
}
