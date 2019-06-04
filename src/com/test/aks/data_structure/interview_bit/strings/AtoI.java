package com.test.aks.data_structure.interview_bit.strings;

/**
 * We only need to handle four cases:
 *
 * 1.Discards all leading whitespaces
 *
 * 2.Sign of the number
 *
 * 3.Overflow
 *
 * 4.Invalid input
 *
 * Detecting overflow gets tricky. You need to detect overflow before the number is about to overflow.
 *
 * So:
 *
 * If the number is positive and the current number is greater than MAX_INT/10, and you are about to append a digit, then certainly your number will overflow.
 *
 * If the current number = MAX_INT / 10, then based on the last digit, we can detect if the number will overflow.
 */

/**
 * 1. null or empty string
 * 2. white spaces
 * 3. +/- sign
 * 4. calculate real value
 * 5. handle min & max
 */

public class AtoI {

    static int createAtoiRecursive(String str) {
        /**
         * New implementation
         */
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        /**
         * Here, we are subtracting '0' from the char at index 'i'
         * coz lets assume str.charAt(i) = 1 - whose ASCII value is 49
         * so to get the exact value 1 as ouput you need to subtract ASCII value of '0' i.e. 48 from 49.
         *
         * Hence, 49 - 48 = 1 (in programming it will be like str.charAt(i) - '0')
         */
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        String str = "  -00123   ";
        int res = createAtoiRecursive(str);
        System.out.println(res);
    }
}
