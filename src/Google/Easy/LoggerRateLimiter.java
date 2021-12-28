package Google.Easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

	public static void main(String[] args) {
		/*
		 * ["Logger","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage",
		 * "shouldPrintMessage","shouldPrintMessage","shouldPrintMessage"]
		 * [[],[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]
		 */
	}

	class Logger {

		Map<String, Integer> messageQueue;

		public Logger() {
			messageQueue = new HashMap<String, Integer>();
		}

		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!messageQueue.containsKey(message)) {
				messageQueue.put(message, timestamp);
				return true;
			}

			int oldTimestamp = messageQueue.get(message);
			if ((timestamp - oldTimestamp) >= 10) {
				messageQueue.put(message, timestamp);
				return true;
			}

			return false;
		}
	}

	/**
	 * Your Logger object will be instantiated and called as such: Logger obj = new
	 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */

}
