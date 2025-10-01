package programmers.level1;

import java.util.Arrays;

/**
 * Programmers - 다트게임(Lv.1)
 *
 * [문제]
 * 다트 게임의 점수 계산 로직은 아래와 같다.
 *
 * 1. 다트 게임은 총 3번의 기회로 구성된다.
 * 2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 * 3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 * 4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 * 5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 * 6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 * 7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 * 8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 * 9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 * 10. 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 *
 * [풀이]
 * - 주어진 문자열을 왼쪽 -> 오른쪽으로 순차적으로 읽어서 다트게임을 3단계로 나눔
 * - 영역별 계산을 해서 배열에 라운드별로 점수 담기
 *
 * - 스타상을 받은 경우 기존에 합계(answer)에 2배를 해주고 현재 점수를 더할때 한번 더 2배를 해준다
 * - 아차상을 받은 경우 현재 점수를 더할때 -1을 곱한다
 *
 *
 */
public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        int[] round = new int[3];
        int idx=-1;

        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(Character.isDigit(c)) {

                idx++;
                    round[idx] = c-'0';
                    if(c-'0' == 1 && (i+1 < dartResult.length())) {
                        char next = dartResult.charAt(i+1);
                        if(next-'0' == 0) {
                            round[idx] = 10;
                            i++;
                        }
                    }
            } else {
                if(c == 'D' || c == 'T') {
                    int pow = c == 'D' ? 2 : 3;
                    round[idx] = (int)Math.pow(round[idx],pow);
                }else if(c == '#') {
                    round[idx] *= (-1);
                }else if(c == '*') {
                    round[idx] *= 2;
                    if(idx != 0) {
                        // 이전 점수 2배
                        round[idx-1] *= 2;
                    }
                }
            }

        }

        answer = Arrays.stream(round).sum();

        return answer;
    }
}
