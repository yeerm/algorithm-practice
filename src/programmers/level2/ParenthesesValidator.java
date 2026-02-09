package programmers.level2;

//괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

//"()()" 또는 "(())()" 는 올바른 괄호입니다.
//")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
//'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.


import java.util.Stack;

public class ParenthesesValidator {
    public static boolean solution(String s) {

        // 열린 괄호면 닫는 괄호가 잘 있는지 확인하는게 중요
        // Stack LIFO(Last In First Out)를 활용
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(')');
            }
            if( c == ')') {
                if (stack.empty()) return false;
                stack.pop();
            }
        }



        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));

    }
}
