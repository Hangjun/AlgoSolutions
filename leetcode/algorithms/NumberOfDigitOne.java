/*
 * Given an integer n, count the total number of digit 1 appearing 
 * in all non-negative integers less than or equal to n.

 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 
 * 10, 11, 12, 13.
 */
public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        while (i <= n) {
            int a = (int) (n / i);
            int b = (int) (n % i);
            count += (a + 8) / 10 * i + (a % 10 == 1 ? 1 : 0) * (b + 1);
            i *= 10;
        }
        return count;
    }


    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        int last = 0;
        while (i <= n) {
            int index = (int) (n / i) % 10;
            count += index * last;
            if (index > 1)
                count += i;
            else if (index == 1)
                count += n % i + 1;
            last = (int) (last * 10 + i);
            i *= 10;
        }
        return count;
    }

}
