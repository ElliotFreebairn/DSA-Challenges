
public class RadixSort {

  public static void main(String[] args) {
    int[] nums = {100, 23, 102, 1, 20, 56, 40, 11};
    int testNum = 301;
    RadixSort.radixSort(nums);
  }

  public static void radixSort(int[] arr) {
    int largestNum = getLargestNum(arr);
    int digitLength = String.valueOf(largestNum).length();
    int[] outputArr = new int[arr.length];

    for(int i = 0; i < digitLength; i++) {
      countingSort(arr, outputArr, i);

      System.arraycopy(outputArr, 0, arr, 0, arr.length);
      displayArr(outputArr);
    }
  }

  private static int getDigit(int num, int digitX) {
    return (num / (int)Math.pow(10, digitX)) % 10;
  }

  private static int getLargestNumAtDigit(int[] arr, int exp) {
    int largestNum = 0;
    for(int i = 0; i < arr.length; i++) {
      if(getDigit(arr[i], exp) > largestNum) {
        largestNum = getDigit(arr[i], exp);
      }
    }
    return largestNum;
  }

  private static void displayArr(int[] inputArr) {
    for(int num : inputArr) {
      System.out.print(num + "   ");
    }
    System.out.println();
  }

  public static void countingSort(int[] inputArr, int[] outputArr, int exp) {
    int[] countArr = new int[10]; // digits 0 - 9

    for(int j = 0; j < inputArr.length; j++) { 
      countArr[getDigit(inputArr[j], exp)]++;
    }
    
    for(int i = 1; i < 10; i++) {
      countArr[i] += countArr[i - 1];
    }
    
    for(int j = inputArr.length - 1; j >= 0; j--) {
      int digit = getDigit(inputArr[j], exp);
      outputArr[countArr[digit] - 1] = inputArr[j];
      countArr[digit]--;
    }
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

  //private static int[] truncatedArr(int[] inputArr, int exp) {
  //  int[] outputArr = new int[inputArr.length];
  //  for(int i = 0; i < inputArr.length; i++) {
  //    outputArr[i] = getDigit(inputArr[i], exp);
  //  }
  //  return outputArr;
  //}

  //private static int[] getEqualDigitLength(int[] inputArr, int maxLength) {
  //  int[] outputArr = new int[inputArr.length];

  //  for(int i = 0; i < inputArr.length; i++) {
  //    if(getNumLength(inputArr[i]) < maxLength) {
  //      String numAsString = String.valueOf(inputArr[i]);
  //      numAsString = addZeros(numAsString, maxLength - numAsString.length());
  //      outputArr[i] = Integer.valueOf(numAsString);
  //    } else {
  //      outputArr[i] = inputArr[i];
  //    }
  //  }

  //  return outputArr;
  //}
  
  //private static int getNumLength(int num) {
  //  return String.valueOf(num).length();
  //}

  //private static String addZeros(String num, int count) {
  //  String zerosAndNum = null;
  //  for(int i = 0; i < count; i++) {
  //    zerosAndNum += "0";
  //  }
  //  return zerosAndNum + num;
  //}

  //private static String[] getArrAsStr(int[] arr) {
  //  String[] outputArr = new String[arr.length];
  //  for(int i = 0; i < arr.length; i++) {
  //    outputArr[i] = String.valueOf(arr[i]);
  //  }
  //  return outputArr;
  //}

  // Counting sort especially for radix sort
 }
