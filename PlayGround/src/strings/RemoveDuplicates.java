package strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    String removeDups(String str) {
        // code here
        StringBuilder result = new StringBuilder();

        Set<Character> visitedSet = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!visitedSet.contains(ch)) {
                visitedSet.add(ch);
                result.append(ch);
            }
        }

        return result.toString();

    }
}
