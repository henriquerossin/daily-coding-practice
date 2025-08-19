package array;

    /*
    LeetCode 2348, Number of Zero-Filled Subarrays
    https://leetcode.com/problems/number-of-zero-filled-subarrays/

    Given an integer array nums, return the number of subarrays filled with 0.
    A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
    Input: nums = [1,3,0,0,2,0,0,4]
    Output: 6
    Explanation:
    There are 4 occurrences of [0] as a subarray.
    There are 2 occurrences of [0,0] as a subarray.
    There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

    Example 2:
    Input: nums = [0,0,0,2,0,0]
    Output: 9
    Explanation:
    There are 5 occurrences of [0] as a subarray.
    There are 3 occurrences of [0,0] as a subarray.
    There is 1 occurrence of [0,0,0] as a subarray.
    There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.

    Example 3:
    Input: nums = [2,10,2019]
    Output: 0
    Explanation: There is no subarray filled with 0. Therefore, we return 0.

    Constraints:
    - 1 <= nums.length <= 105
    - 109 <= nums[i] <= 109
    */

import java.util.Locale;
import java.util.Scanner;

public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        long zeroFilledSubarrays = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {

            if (array[i] == 0) {
                count++;
                zeroFilledSubarrays += count;
            } else {
                count = 0;
            }
        }

        System.out.println(zeroFilledSubarrays);

        sc.close();
    }
}
