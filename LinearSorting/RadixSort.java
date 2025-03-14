
public class RadixSort {

  public static void main(String[] args) {
    int testNum = 301;
    System.out.println(RadixSort.getDigit(testNum, 2));
  }

  public static void radixSort(int[] arr) {
    // Find largest element - digits = iterations
    int largestNum = getLargestNum(arr);
    int digitLength = String.valueOf(largestNum).length();
    // Sort elements based on the unit place digits
    for(int i = 0; i < digitLength; i++) {

    }
  }

  private static int getDigit(int num, int digitX) {
    String numAsString = String.valueOf(num);
    final int numLength = numAsString.length() - digitX - 1;
    if(numLength < 0) {
      return 0;
    }
    char numAsChar = numAsString.charAt(numLength);
    return (Integer.valueOf(String.valueOf(numAsChar)));
  }

  private static int getLargestNum(int[] arr) {
    int largestNum = 0;
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > largestNum) {
        largestNum = arr[i];
      }
    }
    return largestNum;
  }
}
