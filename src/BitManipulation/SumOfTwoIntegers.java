package BitManipulation;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		/*
		 * If one has to compute the sum: While carry is nonzero: y != 0: Current answer
		 * without carry is XOR of x and y: answer = x^y. Current carry is left-shifted
		 * AND of x and y: carry = (x & y) << 1. Job is done, prepare the next loop: x =
		 * answer, y = carry. Return x * sign.
		 * 
		 * If one has to compute the difference: While borrow is nonzero: y != 0:
		 * Current answer without borrow is XOR of x and y: answer = x^y. Current borrow
		 * is left-shifted AND of NOT x and y: borrow = ((~x) & y) << 1. Job is done,
		 * prepare the next loop: x = answer, y = borrow. Return x * sign.
		 */
	}

	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		}

		if (a < b)
			getSum(b, a);
		int sign = (a > 0) ? 1 : -1;

		int x = Math.abs(a);
		int y = Math.abs(b);

		if (a * b > 0) {
			while (y != 0) {
				int ans = x ^ y;
				int carry = (x & y) << 1;
				x = ans;
				y = carry;
			}
		} else {
			while (y != 0) {
				int ans = x ^ y;
				int carry = (~x & y) << 1;
				x = ans;
				y = carry;
			}
		}

		return x * sign;
	}
	
	
	public int getSumPureBitOperation(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        
        return a;
    }

}
