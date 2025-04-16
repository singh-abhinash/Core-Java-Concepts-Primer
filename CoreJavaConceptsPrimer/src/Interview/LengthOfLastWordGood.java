package Interview;

public class LengthOfLastWordGood {

	public static void main(String[] args) {
        String input1 = "Hello World";
        System.out.println(lengthOfLastWord(input1)); // Output: 5

        String input2 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(input2)); // Output: 4

        String input3 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(input3)); // Output: 6
    }

    public static int lengthOfLastWord(String s) {
        boolean isFirstCharFound = false;
        int lengthOfLastWord = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lengthOfLastWord++;
                isFirstCharFound = true;
            } else if (isFirstCharFound) {
                break;
            }
        }
        return lengthOfLastWord;
    }
}
