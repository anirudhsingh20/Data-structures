package recursion;

class DecreasingIncreasing{
    public static void main(String[] args) {
        printIncreasingDecreasing(10);
    }
    public static void printIncreasingDecreasing(int a){

        if(a == 0 )  return;

        System.out.println(a);
        printIncreasingDecreasing(a-1);
        System.out.println(a);

    }



}
