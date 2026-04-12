import java.util.Scanner;

// 1
public static int nSequenceSum(int n){
    if ( n == 0 ) { return 0; }

    return n*n + nSequenceSum(n-1);
}
// Big-O notation is O(n)
// Explanation: function calls itself n times.



// 2
public static int Nsum( int[] array, int n ){
    if  ( n == 0 ) { return 0; }

    return array[n-1] + Nsum(array, n-1);
}
// Big-O notation is O(n)
// Explanation: function call itself n times and array access n times so n + n = n



// 3
public static int n_of_b(int b, int n){
    if  ( n == 0 ) { return 1; }

    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= b;
    }

    return result + n_of_b(b, n-1);
}
// Big-O notation is O(n^2)
// Explanation: function calls itself n times and loop executes n times to and they are nested so: n * n = n^2



// 4
public static void reverseSequence(int n, Scanner sc){
    if ( n == 0 ) { return; }

    int number = sc.nextInt();
    reverseSequence(n - 1, sc);
    System.out.print(number + " ");
}
// Big-O notation is O(n)
// Explanation: because function calls itself n times and inputing and dispalying the data is 1 so n + 1 + 1 = n





public static void main(String[] args) {
    System.out.println(nSequenceSum(4));




    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println(Nsum(array, 10));



    System.out.println(n_of_b(4,3));



    Scanner sc = new Scanner(System.in);
    reverseSequence(sc.nextInt(), sc);

}


