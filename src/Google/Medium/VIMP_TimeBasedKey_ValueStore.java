package Google.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VIMP_TimeBasedKey_ValueStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TimeMap {

		Map<String, TreeMap<Integer, String>> map;

		public TimeMap() {
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			map.putIfAbsent(key, new TreeMap<Integer, String>());
			map.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			if (!map.containsKey(key))
				return "";
			Integer time = map.get(key).floorKey(timestamp);
			return time != null ? map.get(key).get(time) : "";
		}
	}

	/**
	 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
	 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
	 * obj.get(key,timestamp);
	 */

	/*********************************Binary search************************************/

	/*class TimeMap{
		Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

		public void set(String key, String value, int timestamp) {
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(new Pair<>(timestamp, value)); // Timestamps are strictly increasing -> sorted
		}

		public String get(String key, int timestamp) {
			if (!map.containsKey(key))
				return "";
			return binarySearch(map.get(key), timestamp);
		}

		String binarySearch(List<Pair<Integer, String>> L, int timestamp) {
			int left = 0, right = L.size();
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (L.get(mid).getKey() <= timestamp)
					left = mid + 1;
				else
					right = mid;
			}
			return right == 0 ? "" : L.get(right - 1).getValue();
		}
	}*/
}
