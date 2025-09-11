package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Programmers - 실패율(Lv.1)
 *
 * [문제]
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 *
 * 실패율은 다음과 같이 정의한다.
 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 *
 * [풀이]
 * - 스테이지만큼 반복문을 돌며 실패율을 단계별로 저장한다.
 * - 단계별 실패율을 내림차순으로 정렬한다.
 */
public class FailureRate {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = {4,4,4,4,4};
//        int[] stages = {1,2,3};
        System.out.println("answer: " + Arrays.toString(solution(n, stages)));


    }

    public static int[] solution(int N, int[] stages) {

        double[] failRate = new double[N];

        for(int i=1; i<=N; i++) {
            int fail = 0;
            int total = 0;
            for(int j=0; j<stages.length; j++) {
                if(stages[j] >= i) total++;
                if(stages[j] == i) fail++;
            }
            failRate[i-1] = total == 0 ? 0 : (double)fail/total;
        }

        System.out.println("failRate: " + Arrays.toString(failRate));

        int[] answer = IntStream.range(1, N+1)
                .boxed()
                .sorted((a, b) -> {
                    int cmp = Double.compare(failRate[b-1], failRate[a-1]);
                    return (cmp == 0) ? Integer.compare(a,b) : cmp;
                })
                .mapToInt(Integer::intValue)
                .toArray();


        return answer;
    }
}
