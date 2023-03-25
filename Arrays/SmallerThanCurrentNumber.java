/*

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100


Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]

Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
*/

package Arrays;

public class SmallerThanCurrentNumber {
    
    public static void main(String[] args) {
        int arr[]= {8,1,2,2,3};
        FindSmallerThanCurrentNumber(arr);
    }

    public static void FindSmallerThanCurrentNumber(int nums[]) {
        
        int temp[] = new int[101];
        int n = nums.length;

        for(int i=0;i<n; i++){
            temp[nums[i]] +=1;
        }

        for(int i=1;i<100;i++){
            temp[i] +=temp[i-1];
        }
        for(int i=0; i<n;i++){
            if(nums[i]==0){
                nums[i]=0;
            }
            else{
                nums[i] = temp[nums[i]-1];
            }
        }
        for (int e : nums) {
            System.out.print(e + " ");
        }

    }
}
