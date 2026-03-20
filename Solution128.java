import java.util.HashSet;
import java.util.Scanner;

public class Solution128{

    public static int longestConsecutive(int[] nums){

        if(nums.length == 0 ) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array size :");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++) {
           arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutive(arr));
        sc.close();
    }
}