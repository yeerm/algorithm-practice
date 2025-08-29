package programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * programmers - 포켓몬(해시)(Lv.1)
 *
 * [문제]
 * 연구실에 있는 N마리의 폰켓몬 중 절반(N/2)만 선택할 수 있다.
 * 폰켓몬은 종류 번호로 구분되며, 같은 번호는 같은 종류다.
 * 목표는 선택할 수 있는 폰켓몬 종류의 수를 최대화하는 것이다.
 *
 * [풀이]
 * - Set을 사용하여 중복 번호 제외
 *
 * */
public class Poketmon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        solution(nums);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int len = nums.length/2;

        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int size = set.size();

        answer = Math.min(len, size);

        return answer;
    }
}
