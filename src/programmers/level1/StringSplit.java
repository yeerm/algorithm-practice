package programmers.level1;

/**
 * Programmers - 문자열 나누기(Lv.1)
 *
 * [문제]
 * 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
 *
 * 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
 * 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
 * s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
 * 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
 * 문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
 *
 * [문제 풀이]
 * - 문자열 -> 문자로 분리
 * - x글자들 담을 문자열, x가 아닌 글자를 담을 문자열
 * - 횟수 비교 후, 같다면 글자 수 만큼 split
 * - split 할때마다 카운트 (=answer)
 * - 다음 문자열이 존재하면 위 과정 반복
 *
 * [개선]
 * - 반복문을 돌때마다 substring으로 시간 지체됨 ->
 * 문자열을 자르지 않고 한개씩 확인 후 카운트만 하고 마지막에 남은 글자가 있으면 카운트 +1 하는 방식으로 변경
 */
public class StringSplit {
    public static void main(String[] args) {
        String x = "abracadabra";
        System.out.println(solution(x));
    }



    public static int solution(String s) {
        int answer = 0;

        String target = s;
        while(!target.isEmpty()) {
            target = split(target);
            answer++;
        }


        return answer;
    }

    public static String split(String s) {
        char x = s.charAt(0);

        int cntX = 1;
        int cntOther = 0;
        String split = "";

        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == x) {
                cntX ++;
            }else {
                cntOther++;
            }

            if(cntX == cntOther) {
                split = s.substring(i+1);
                //System.out.println(split);
                break;
            }
        }
        return split;
    }

    public static int solution2(String s) {
        int answer = 0;

        char x = 0;
        int cntX = 0;
        int cntY = 0;

        for(int i=0; i<s.length(); i++) {
            if(x == 0 && cntX == 0) {
                x = s.charAt(i);
                cntX++;
            }else {
                char y = s.charAt(i);
                if(x == y) {
                    cntX++;
                }else {
                    cntY++;
                }

                if(cntX == cntY) {
                    answer++;
                    x = 0;
                    cntX = 0;
                    cntY = 0;
                }
            }

        }

        if(cntX != 0 || cntY != 0) answer++;


        return answer;
    }
}
