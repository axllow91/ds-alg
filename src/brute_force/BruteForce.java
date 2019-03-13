package brute_force;

public class BruteForce {
    public static final int search(String text, String pattern) {
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        for(int i = 0; i < lengthOfText - lengthOfPattern; i++) {
            int j;
            for(j = 0; j < lengthOfPattern; j++) {
                if(text.charAt(i + j) != pattern.charAt(j)) {
                    break; // they are not matching
                }
            }

            // all correctors are matching
            if(j == lengthOfPattern) return i;
        }

        // return length of the text if nothing was found
        return lengthOfText;
    }

    public static void main(String[] args) {
        String text = "My name is awesomeness";
        String pattern = "named";

        System.out.println(search(text, pattern));
    }
}
