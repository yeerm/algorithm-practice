package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * programmers - 모의고사(Lv.1)
 *
 * [문제]
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * [풀이]
 * - 정답을 비교할 수포자별 인덱스 값을 나머지 값을 사용해서 반복되도록 처리한다.
 * - 정답 수가 가장 많은 값을 추출한다.
 * - 정답 수와 동일한 값들의 인덱스 값만 오름차순으로 정렬한다.
 *
 *
 * */
public class PracticeTest {
    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        solution(answer);
    }

    public static int[] solution(int[] answers) {

        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};

        int[] result = {0,0,0};

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == num1[i%5]) result[0]++;
            if(answers[i] == num2[i%8]) result[1]++;
            if(answers[i] == num3[i%10]) result[2]++;
        }

        int max = Arrays.stream(result).max().getAsInt();

        int[] rank = IntStream.range(0, result.length)
                .boxed()
                .filter(i -> max == result[i])
                .sorted((a,b) -> Integer.compare(result[b], result[a]))
                .mapToInt(i -> i+1)
                .toArray();


        System.out.println("rank: " + Arrays.toString(rank));

        return rank;
    }
}
