package programmers.level1;

import java.util.Arrays;


/**
 * Programmers - 둘만의 암호(Lv.1)
 *
 * [문제]
 * 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.
 *
 * 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
 * index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
 * skip에 있는 알파벳은 제외하고 건너뜁니다.
 * 예를 들어 s = "aukks", skip = "wbqd", index = 5일 때,
 * a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
 * 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다.
 * 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
 *
 * [문제 풀이]
 * - 문자열을 문자로 분리
 * - 현재 문자에서 index 만큼 뒤로 이동
 * - 이동 후, 문자가 skip에 포함되면 다시 +1 만큼 뒤로 이동
 * - skip에 포함되지 않을때까지 위 과정을 반복
 * - 바꾼 문자는 문자열(=answer)에 누적
 */
public class SecretForTwo {

    public static void main(String[] args) {
//        String s = "aukks";
//        String skip = "wbqd";
        String s = "bcdefg";
        String skip ="azuk";

        int index = 1;

        System.out.println(solution(s, skip, index));
    }


    // 사용할 수 있는 알파벳을 먼저 정리한다.
    // 정리된 알파벳 배열에서 index 만큼 더하여 단어를 만든다.
    public static String solution(String s, String skip, int index) {
        String answer = "";

        char[] alphabet = new char[('z'-'a'+1)];
        alphabet[0] = 'a';

        for(int i=1; i<alphabet.length; i++) {
            alphabet[i] = (char)(alphabet[0] + i);
        }

        // skip 문자를 alphabet  배열에 표시
        for(int i=0; i<skip.length(); i++) {
            alphabet[(skip.charAt(i) - 'a')] = '-';
        }

        System.out.println("ALPHABET IS " + Arrays.toString(alphabet));

        StringBuilder sb = new StringBuilder(s.length());

        /// 문자 단위로 쪼갬
        for(char ch: s.toCharArray()) {
            int start = ch - 'a';
            int move = 0;

            while(move < index) {
                if(start >= alphabet.length-1) {
                    start=-1;
                }

                if(alphabet[++start] != '-') {
                    move++;
                }
            }
            sb.append(alphabet[start]);
        }

        answer = sb.toString();

        return answer;
    }
}
