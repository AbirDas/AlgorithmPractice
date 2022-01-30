package Google.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VIMP_EmployeeImportance {

	public static void main(String[] args) {
		/*
		Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
		Output: 11
		Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
		They both have an importance value of 3.
		Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
		*/
	}

	class Solution {
		Map<Integer, Employee> eMap;

		public int getImportance(List<Employee> employees, int id) {
			eMap = new HashMap<>();
			for (Employee e : employees)
				eMap.put(e.id, e);

			return dfs(id, new HashSet<Integer>());
		}

		private int dfs(int id, Set<Integer> set) {
			if (set.contains(id))
				return 0;
			int count = 0;
			set.add(id);
			Employee e = eMap.get(id);
			count = e.importance;

			for (Integer sub : e.subordinates) {
				count += dfs(sub, set);
			}
			return count;
		}
	}

	// Definition for Employee.
	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

}
