import java.util.Scanner;
import java.util.Stack;

// 9+3+4*3
// 5+4*5*5
// 5*6/5*4

public class Main_二十四点 {

    static Scanner scanner;

    static char[] op = {'+', '-', '*', '/'};
    static char[] opPriority = {1, 1, 2, 2};

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            int res = f(input);
            if (res == 24) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static int f(String input) {
        char[] inputChars = input.toCharArray();
        Stack<Character> opStack = new Stack<Character>();
        Stack<Integer> intStack = new Stack<Integer>();
        for (char curChar : inputChars) {
            if (isOp(curChar)) {
                if (morePriority(curChar, opStack)) {
                    opStack.push(curChar);
                } else {
                    Integer opInt1 = intStack.pop();
                    Integer opInt2 = intStack.pop();
                    Character opChar = opStack.pop();
                    int calculateRes = calculate(opInt2, opChar, opInt1);
                    intStack.push(calculateRes);
                    opStack.push(curChar);
                }
            } else {
                intStack.add(curChar - '0');
            }
        }
        while (opStack.size() != 0) {
            Integer opInt1 = intStack.pop();
            Integer opInt2 = intStack.pop();
            Character opChar = opStack.pop();
            int calculateRes = calculate(opInt2, opChar, opInt1);
            intStack.push(calculateRes);
        }
        return intStack.pop();
    }

    static int calculate(Integer opInt2, Character opChar, Integer opInt1) {
        String opStr = String.valueOf(op);
        int indexOfOpChar = opStr.indexOf(opChar);
        if (indexOfOpChar == 0) {
            return opInt2 + opInt1;
        }
        if (indexOfOpChar == 1) {
            return opInt2 - opInt1;
        }
        if (indexOfOpChar == 2) {
            return opInt2 * opInt1;
        }
        if (indexOfOpChar == 3) {
            return opInt2 / opInt1;
        }
        return 0;
    }

    static boolean morePriority(Character curOp, Stack<Character> opStack) {
        if (opStack.size() == 0) {
            return true;
        }
        String opStr = String.valueOf(op);
        Character topOp = opStack.pop();
        opStack.push(topOp);
        int indexOfCurOp = opStr.indexOf(curOp);
        int indexOfTopOp = opStr.indexOf(topOp);
        return opPriority[indexOfCurOp] - opPriority[indexOfTopOp] > 0;
    }

    static boolean isOp(char curChar) {
        String opStr = String.valueOf(op);
        return opStr.contains(String.valueOf(curChar));
    }
}
