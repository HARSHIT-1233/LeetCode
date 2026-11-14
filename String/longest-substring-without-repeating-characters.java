
import java.util.*;

class Main {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {

            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Length of longest substring: "
                + lengthOfLongestSubstring(s));

        sc.close();
    }
}
