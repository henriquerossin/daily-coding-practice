package math;

import java.util.Arrays;
import java.util.Scanner;

public class ReorderedPowerOfTwo {

    /*
    LeetCode 869 - Reordered Power of 2
    https://leetcode.com/problems/reordered-power-of-2/

    You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

    Return true if and only if we can do this so that the resulting number is a power of two.

    Example 1:
    Input: n = 1
    Output: true

    Example 2:
    Input: n = 10
    Output: false

    Constraints:
    1 <= n <= 10^9
    */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a number");
        int n = sc.nextInt();

        boolean result = reorderedPowerOf2(n);
        System.out.println(result);

        sc.close();
    }

    public static boolean reorderedPowerOf2(int n) {
        String originalSorted = sortString(Integer.toString(n));

        int power = 1;
        while (power <= 1_000_000_000) {
            String powerSorted = sortString(Integer.toString(power));
            if (powerSorted.equals(originalSorted)) {
                return true;
            }
            power *= 2;
        }

        return false;
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
