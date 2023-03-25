// Factorial of a large number 

// hint multiply like old school .....  from right to left and use carry

// store result in res[] in right to left toooo.

package Arrays;

public class FactorialOfLargeNumber {

    public static void fact(int a) {

        int res[] = new int[500];
        res[0] = 1;
        int res_size = 1;

        // fill value in res[] array in right to left and multiply
        for (int i = 2; i<= a; i++ ) {
            res_size = multiply(res,i,res_size);
        }
        // print output from res array from right to left
        for (int i = res_size-1; i>=0 ; i--){
            System.out.print(res[i]);
        }

    }

    public static int multiply(int res[],int x, int res_size) {

        int carry = 0;
        
        for(int i=0;i < res_size; i++) {
            
            int prod = res[i] * x + carry;

            res[i] = prod % 10;

            carry = prod / 10;
        }

        while(carry != 0)
        {
            res[res_size] = carry % 10;
            carry /= 10;
            res_size++;
        }

        return res_size;
    }
    
    public static void main(String args[]) {
        System.out.println("\nFactorial of the number is : \n");
        fact(100);
    }
}

// output 
// Factorial of the number is :

// 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
