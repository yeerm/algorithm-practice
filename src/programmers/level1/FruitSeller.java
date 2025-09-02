package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [문제]
 * 과일 장수가 사과 상자를 포장하고 있습니다. 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며,
 * k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 사과 한 상자의 가격은 다음과 같이 결정됩니다.
 *
 * 한 상자에 사과를 m개씩 담아 포장합니다.
 * 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
 * 과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.(사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
 *
 * 예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면, 다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.
 *
 * (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
 * 사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때, 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
 *
 * [풀이]
 * - score을 내림차순으로 정렬
 * - 상자 1개의 사과 최소 점수 설정
 * - 상자 1개에 들어갈 사과 개수(m) 의 배수일 때 마다 게산
 *
 * [개선]
 * - 배열 기본정렬(오름차순) 후 뒤집으면 내림차순
 * - 내림차순으로 이미 정렬했으므로, 사과 최소 점수는 m의 배수마다 이미 정해진거나 다름 없음
 * - 최소 점수와 계산을 두 번에 나눠서 할 필요 없이 배수마다 계산해주면 사과 최소 값으로 계산하는거임
 *
 */
public class FruitSeller {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        solution2(k,m, score);
    }

    public static int solution2(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i=score.length; i>m; i-=m) {
            answer += score[i-m] * m;
        }
        return answer;
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        int[] sortedScore = Arrays.stream(score).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

       // System.out.println("sorted score: " + Arrays.toString(sortedScore));

        int min = k;

        for(int i=0; i<sortedScore.length; i++) {
            if(min > sortedScore[i]) min = sortedScore[i];
            if((i+1)%m == 0) {
                answer += (min * m);
            }
        }

        //System.out.println("answer: " + answer);

        return answer;
    }
}
