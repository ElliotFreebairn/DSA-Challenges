
public class RadixSort {

  public static void main(String[] args) {
    int[] nums = {100, 23, 102, 40, 11};
    int testNum = 301;
    System.out.println(RadixSort.getDigit(testNum, 2));
    RadixSort.radixSort(nums);
    System.out.println(Integer.valueOf("001"));
  }

  public static void radixSort(int[] arr) {
    // Find largest element - digits = iterations
    int largestNum = getLargestNum(arr);
    int digitLength = String.valueOf(largestNum).length();
    // Sort elements based on the unit place digits
    

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

  private static int[] truncatedArr(int[] inputArr, int exp) {
    int[] outputArr = new int[inputArr.length];
    for(int i = 0; i < inputArr.length; i++) {
      outputArr[i] = getDigit(inputArr[i], exp);
    }
    return outputArr;
  }

  private static int[] getEqualDigitLength(int[] inputArr, int maxLength) {
    int[] outputArr = new int[inputArr.length];

    for(int i = 0; i < inputArr.length; i++) {
      if(getNumLength(inputArr[i]) < maxLength) {
        String numAsString = String.valueOf(inputArr[i]);
        numAsString = addZeros(numAsString, maxLength - numAsString.length());
        outputArr[i] = Integer.valueOf(numAsString);
      } else {
        outputArr[i] = inputArr[i];
      }
    }

    return outputArr;
  }
  
  private static void displayArr(int[] inputArr) {
    for(int num : inputArr) {
      System.out.print(num + "   ");
    }
    System.out.println();
  }

  private static int getNumLength(int num) {
    return String.valueOf(num).length();
  }

  private static String addZeros(String num, int count) {
    String zerosAndNum = null;
    for(int i = 0; i < count; i++) {
      zerosAndNum += "0";
    }
    return zerosAndNum + num;
  }

  // Counting sort especially for radix sort
  public static void countingSort(int[] inputArr, int[] outputArr, int k, int exp) {
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
