package Google.Medium;

public class IMP_SentenceScreenFitting {

	public static void main(String[] args) {
		String[] str = { "a", "bcd", "e" };
		System.out.println(wordsTyping(str, 3, 6));
		/* a-bcd- 
		 * e-a--- 
		 * bcd-e- 
		 * The character '-' signifies an empty space on the
		 * screen.
		 */
	}

	public static int wordsTyping(String[] sentence, int rows, int cols) {
		StringBuilder sb = new StringBuilder();
		for (String word : sentence) {
			sb.append(word + " ");
		}

		String wholeSentence = sb.toString();
		// String wholeSentence = String.join(" ",sentence) + " ";
		int wholeSentenceLength = wholeSentence.length();
		int totalLength = 0;

		for (int i = 0; i < rows; i++) {
			totalLength += cols;

			if (wholeSentence.charAt(totalLength % wholeSentenceLength) == ' ') {
				++totalLength;
			} else {
				while (totalLength > 0 && wholeSentence.charAt((totalLength - 1) % wholeSentenceLength) != ' ') {
					--totalLength;
				}
				// ++totalLength;
			}
		}
		return totalLength / wholeSentenceLength;
	}

}
