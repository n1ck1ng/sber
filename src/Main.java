import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(bracket("()()()(") == 6);
        System.out.println(bracket("()))))((((") == 2);
        System.out.println(bracket("(()()())") == 8);
        System.out.println(bracket("(()") == 2);
        System.out.println(bracket(")()())") == 4);
        System.out.println(bracket(")(()())") == 6);
        System.out.println(bracket(")(") == 0);
        System.out.println(bracket("))))))))(((()))))") == 8);
        System.out.println(bracket("))))))))") == 0);
        System.out.println(bracket("(((((") == 0);
        System.out.println(bracket("((((())()()-)))") == 14);
        System.out.println(bracket("") == -1);
        System.out.println(bracket(null) == -1);
    }

    public static int bracket(String str) {

        if (str == null || str.isBlank()) {
            return -1;
        }

        Deque<Character> stack = new LinkedList<>();
        int countPairs = 0;

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(' -> stack.add(c);
                case ')' -> {
                    if (!stack.isEmpty() && stack.getLast() == '(') {
                        stack.poll();
                        countPairs += 2;
                    }
                }
                default -> {
                    System.out.println("INFO    String contains NOT a bracket: " + c);
                }
            }
        }
        return countPairs;
    }
}
