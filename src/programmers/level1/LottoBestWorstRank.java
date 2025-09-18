package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmers - 로또 최고/최저 순위(Lv.1)
 *
 * [문제]
 * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
 * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
 * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
 * 알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다.
 * 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
 *
 * 당첨 번호	31	10	45	1	6	19	결과
 * 최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
 * 최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
 *
 * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
 * 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 *
 * [문제 풀이]
 * - 로또에서 당첨번호 몇개가 있는지 확인
 * - 0이 있는 경우 최고점은 모두 맞았을 때, 최저점은 모두 틀렸을 때
 * - 0이 없는 경우는 최고/최저점은 동일
 */
public class LottoBestWorstRank {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, winNums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        int[] answer = new int[2];

        // 오름차순 정렬 -> 0이 있는 경우 첫번째 인덱스 값은 무조건 0
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int result = 0;
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    result++;
                }
            }
        }

        Arrays.fill(answer, map.getOrDefault(result,6));

        if(lottos[0] == 0) {
            int cnt = 0;
            for(int i=0; i<lottos.length; i++) {
                if(lottos[i] == 0) {
                    cnt++;
                }else {
                    break;
                }
            }

            answer[0] = map.getOrDefault((result+cnt), 6);
        }

        return answer;
    }
}
