package assignment3;

import java.util.Scanner;

public class asik3 {
//  TASK 1
    public static String isAnagram(String word1, String word2){
        if (word1.length() != word2.length()) return "NO";

        Sorting sort = new Sorting();

        char[] arrayWord1 = sort.StrBubleSort(word1.toLowerCase().toCharArray());
        char[] arrayWord2 = sort.StrBubleSort(word2.toLowerCase().toCharArray());

        boolean same = true;

        for(int i = 0; i < arrayWord1.length; i++){
            if( arrayWord1[i] != arrayWord2[i] ){
                same = false;
                break;
            }
        }

        if(same) return "YES";
        return "NO";
    }


//  TASK 2
    public static int kSmallestNum(int size, int[] array, int k){
        Sorting sort = new Sorting();

        sort.IntBubleSort(array);

        return array[k-1];

    }


//  TASK 3
    public static int FindMedian(int size, int[] array){
        Sorting sort = new Sorting();

        sort.IntBubleSort(array);

        if( size % 2 == 1 ){
            return array[size/2];
        }

        return array[((size/2) + ((size/2) - 1)) / 2 ];
    }


//  TASK 4
    public static void displayOptimalCapacity(int[] weights, int days) {
        int answer = Search.findMinimumCapacity(weights, days);
        System.out.println("Minimum capacity required: " + answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+-+- T1) let's check are your words Anagram! -+-+");
        System.out.print("Enter your first word: ");
        String word1 = sc.next();
        System.out.print("Enter your second word: ");
        String word2 = sc.next();

        System.out.print("\nAnswer: ");
        System.out.print(isAnagram(word1, word2));
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+");



        System.out.println("+-+- T2) Let's find kth smallest number from an array -+-+");
        System.out.print("Please enter SIZE of an array: ");
        int sizeT2 = sc.nextInt();
        System.out.print("Please enter an array: ");
        int[] arrayT2 = new int[sizeT2];
        for(int i = 0; i < sizeT2; i++){
            arrayT2[i] = sc.nextInt();
        }
        System.out.print("Please enter your K: ");
        int k = sc.nextInt();

        System.out.print("\nAnswer: ");
        System.out.print(kSmallestNum(sizeT2, arrayT2, k));
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+");



        System.out.println("+-+- T3) Let's find Median value of an array -+-+");
        System.out.print("Please enter SIZE of an array: ");
        int sizeT3 = sc.nextInt();
        System.out.print("Please enter an array: ");
        int[] arrayT3 = new int[sizeT3];
        for(int i = 0; i < sizeT3; i++){
            arrayT3[i] = sc.nextInt();
        }
        System.out.print("\nAnswer: ");
        System.out.print(FindMedian(sizeT3, arrayT3));
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+");



       System.out.println("+-+- T4) Optimal Shipping Capacity -+-+");
       System.out.print("Enter the package weights: ");
       String weightsLine = sc.nextLine();
       String[] parts = weightsLine.split(" ");
       int[] weights = new int[parts.length];
       for (int i = 0; i < parts.length; i++) {
           weights[i] = Integer.parseInt(parts[i]);
       }

       System.out.print("Enter number of days: ");
       int days = sc.nextInt();

       displayOptimalCapacity(weights, days);
       System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
}