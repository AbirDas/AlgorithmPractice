package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {

	public static void main(String[] args) {
		// The Gray code sequence for n = 3 bit numbers is: [000, 001, 011, 010, 110, 111, 101, 100].

	}

	public List<Integer> grayCodeItrative(int n) {
		List<Integer> result = new ArrayList();
		result.add(0);

		for (int i = 0; i < n; i++) {
			int prev = result.size();
			int mask = 1 << i;
			for (int j = prev - 1; j >= 0; j--) {
				result.add(mask + result.get(j));
			}
		}
		return result;
	}

	public List<Integer> grayCodeBackTracing(int n) {
		List<Integer> result = new ArrayList();
		result.add(0);
		Set<Integer> ittr = new HashSet();
		ittr.add(0);
		grayHelper(result, ittr, n);
		return result;
	}

	private boolean grayHelper(List<Integer> result, Set<Integer> ittr, int n) {
		if (result.size() == (1 << n))
			return true;

		int curr = result.get(result.size() - 1);

		for (int i = 0; i < n; i++) {
			int next = curr ^ (1 << i);
			if (!ittr.contains(next)) {
				ittr.add(next);
				result.add(next);

				if (grayHelper(result, ittr, n))
					return true;

				ittr.remove(next);
				result.remove(next);
			}
		}
		return false;
	}

}
