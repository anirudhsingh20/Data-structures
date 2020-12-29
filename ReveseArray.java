// Program to reverse an Array


import java.util.Scanner;

class ReverseArray {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array (greater than 0): ");
        int length = sc.nextInt();

        int[] array = new int[length];

        System.out.println("Enter the integer values in the array: ");

        for(int i=0; i<array.length; i++) {
            array[i] = sc.nextInt();
        }

        int[] result = new int[array.length];

        for(int i=0, j=array.length - 1; i<array.length; i++, j-- ) {
            result[j] = array[i];
        }

        System.out.println("\nReversed array is : ");

        for(int e : result){
            System.out.println(e);
        }
        sc.close();
    }
}