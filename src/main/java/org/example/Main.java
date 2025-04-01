package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    // is anagram program
    public static boolean isAnagram(String str1, String str2){

        char[] char1 = str1.toLowerCase().toCharArray();
        char[] char2 = str2.toLowerCase().toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1,char2);
    }

    // factorial of given number

    public static int factorial(int number){
        if(number == 0 || number == 1){
            return number;
        }

        return number * factorial(number-1);
    }

    // fabonacci series
    public static void printFabanaciSeries(int number){
        int a = 0;
        int b = 1;
        System.out.print("fabonaci series are" +a +","+b+",");

        for(int i=2;i<=number;i++){
            int c = a + b;
            System.out.print(c +",");
            a = b;
            b = c;
        }
    }

    public static void reverseString(String word){

        StringBuilder sb = new StringBuilder();
        for ( int i= word.length()-1; i >= 0; i--){
            System.out.print(word.charAt(i));
            sb.append(word.charAt(i));
        }
        System.out.println(sb);
        char[] ch1 = word.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(Character ch : ch1){
            charList.add(ch);
        }
        Collections.reverse(charList);
        charList.forEach(System.out::print);
        System.out.println(Arrays.toString(charList.toArray()));
    }

    public static boolean isContainsVowels(String str){
        return str.toLowerCase().matches(".*[aeiou].*");
    }

    public static void vowelOrConsonant(Character ch){
        List<Character> charList = Arrays.asList('a','e','i','o','u');
        if(charList.contains(ch)){
            System.out.println("Character is vowel");
        }else{
            System.out.println("Character is consonant");
        }
    }

    public static void primeNumberPrint(int number){

        int flag = 1;
        for(int i=2; i<=number; i++){
            for(int j=2; j <= i/2; ++j){
                if (i % j == 0){
                    flag = 0;
                    break;
                }
                if(flag == 1){
                    System.out.print(i);
                }
            }

        }
    }

    public static int missingNumber(int[] arr){

        int sum = Arrays.stream(arr).sum();
        int n = arr.length+1;
        int totalSum =  (n * (n+1))/2;
        return totalSum - sum;
    }

    public static void swapTwoNumber(int a, int b){

        System.out.println("Before swap a="+ a +", b="+b);
        a = a+b -(b=a);
        System.out.println("After swap a="+ a +", b="+b);
    }

    public static void removeGivenKeyFromArray(int[] a, int k){
        List<Integer> list= new ArrayList<>();
        for (int j : a) {
            if (j != k) {
                list.add(j);
            }
        }
        System.out.println("New Array"+ Arrays.toString(list.toArray()));
    }

    public static void removeLeadingZeros(String str){
        int count =0;
        //"00000123569"
        for (int i=0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                count++;
            }
        }
        String newString = str.substring(count) + str.substring(0,count);
        System.out.println(newString);
    }

    public static void moveZerosToLast(int[] a){
        int j = 0;
        int length = a.length;
        int[] temp = new int[length];

        for (int k : a) {
            if (k != 0) {
                temp[j] = k;
                j++;
            }
        }
        for(int k= j; k< length;k++){
            temp[k] = 0;
        }

        System.arraycopy(temp, 0, a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static int[] twoSum(int[] arr, int target){

        for(int i=0;i<arr.length;i++){
            for(int j= i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    return new int[]{arr[i], j};
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSumOptimal(int[] arr, int target){
       // int = target= 9    int[] arr = {2, 7, 11, 15};
        Map<Integer, Integer> mapValues = new HashMap<>();
        for(int i=0;i<arr.length;i++){
           int complement = target - arr[i];
            if(mapValues.containsKey(complement)){
                return new int[]{mapValues.get(complement),i};
            }
            mapValues.put(arr[i],i);
        }
        return new int[]{};
    }

    public static int maxProfit(int[] profit){
        //int[] prices = {7, 10, 1, 3, 6, 9, 2};  output: 8
        int maxProfit = 0;
       /* for(int i=0;i< profit.length-1;i++){
            for(int j= i+1; i< profit.length;i++){
                maxProfit = Math.max(maxProfit, profit[j]-profit[i]);
            }
        }*/
        int minorSoFar = profit[0];
        for(int i=1;i<profit.length;i++){
            minorSoFar = Math.min(minorSoFar, profit[i]);
            maxProfit = Math.max(maxProfit, profit[i]-minorSoFar);
        }
        return maxProfit;
    }

    public static int maxSubArraySum(int[] arr){
// int[] arr = {2, 3, -8, 7, -1, 2, 3};  output: 11
        int sum = arr[0];
        int maxEnding = arr[0];
        /*for(int i=0;i<arr.length;i++){
            int currentSum = 0;
            for(int j=i;j<arr.length;j++){
                currentSum = currentSum + arr[i];
                sum = Math.max(sum, currentSum);
            }
        }*/

        for(int i=1;i<arr.length;i++){
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            sum = Math.max(sum, maxEnding);

        }
        return sum;
    }

    public static int[] productOfArraysWithoutSelf(int[] arr){
        int[] finalArr = new int[arr.length];
            finalArr[0] =1;

            for(int i=0 ;i< arr.length; i++) {
                for(int j=0;j< arr.length;j++) {
                  if(i != j){
                      finalArr[i] = finalArr[i] * arr[j];
                  }
               }
            }
        return finalArr;
    }

    public static void sortArraysOf1and2(String[] a){

        int low = 0;
        int high = a.length -1;
        int mid = 0;

        while ( mid <= high){
            if(a[mid].equals("RED")){
                swapArray(a,mid,low);
                low++;
                mid++;
            }else if(a[mid].equals("WHITE")){
                mid++;
            }else{
                swapArray(a,mid,high);
                high--;
            }
        }


    }

    public static void  swapArray(String[] a, int mid, int low){
            String temp = a[mid];
            a[mid] = a[low];
            a[low] = temp;
    }


    public static int minDiff(int[] arr, int num){
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i+num-1 < arr.length;i++){

            int diff = arr[i+num-1]- arr[i];

            if(diff < minDiff)
                minDiff = diff;
        }

        return minDiff;
    }



    public static void main(String[] args) {

     //   Scanner sc = new Scanner(System.in);
     //   String str1 = sc.nextLine();
     //   String str2 = sc.nextLine();
     //   System.out.println("Is " +str2 + " anagram of "+str1+ " "+ isAnagram(str1,str2));

     //   System.out.println("Enter the number value");
     //   int number = sc.nextInt();
     //   System.out.println("factorial of given number is" + factorial(number));
     //   printFabanaciSeries(number);

     //   System.out.println("Enter the String value");
     //   String str1 = sc.nextLine();
     //   reverseString(str1);
     //   System.out.println("Enter the String value");
     //   String str2 = sc.nextLine();
    //    reverseString(str2);



     //   swapTwoNumber(2,5);
      int[] a = {0,  1, 0,1};
     //   removeGivenKeyFromArray(a, 1);

     //   removeLeadingZeros("00000123569");

     //   moveZerosToLast(a);

        String[] colour = {"RED","WHITE","BLUE","RED","WHITE","BLUE"};
        sortArraysOf1and2(colour);
        for (String j : colour) System.out.print(j + " ");

        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> res = spirallyTraverse(mat);
        for (int ele : res) {
            System.out.print(ele + " ");
        }

    }

    private static List<Integer> spirallyTraverse(int[][] mat) {
        List<Integer> list = new ArrayList<>();

        int outer = mat.length;
        int inner = mat[0].length;
        int top=0, bottom = outer-1, left=0, right = inner-1;

        while(  left <= right && top <= bottom ){

            for(int i=left;i<=right;++i){
                list.add(mat[left][i]);
            }
            top++;

            for(int i=top;i<= bottom;++i){
                list.add(mat[i][right]);
            }
            bottom--;

            if(top <= bottom){
                for(int i=right;i>=left;--i){
                    list.add(mat[top][i]);
                }
                right--;
            }

            if(left <= right){
               for(int i=bottom;i >= top; --i){
                   list.add(mat[i][top]);
               }
               left--;
            }
        }

        return list;
    }

    public static List<Integer> spirallyTraverseUsingStream(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;

        int rows = mat.length, cols = mat[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (left <= right && top <= bottom) {
            // Traverse from left to right
            int finalTop = top;
            result.addAll(IntStream.rangeClosed(left, right)
                    .mapToObj(i -> mat[finalTop][i])
                    .toList());
            top++;

            // Traverse from top to bottom
            int finalRight = right;
            result.addAll(IntStream.rangeClosed(top, bottom)
                    .mapToObj(i -> mat[i][finalRight])
                    .toList());
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                int finalRight1 = right;
                int finalLeft = left;
                int finalBottom = bottom;
                result.addAll(IntStream.rangeClosed(left, right)
                        .map(i -> finalRight1 - i + finalLeft)
                        .mapToObj(i -> mat[finalBottom][i])
                        .toList());
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                int finalBottom1 = bottom;
                int finalTop1 = top;
                int finalLeft1 = left;
                result.addAll(IntStream.rangeClosed(top, bottom)
                        .map(i -> finalBottom1 - i + finalTop1)
                        .mapToObj(i -> mat[i][finalLeft1])
                        .toList());
                left++;
            }
        }
        return result;
    }
}



