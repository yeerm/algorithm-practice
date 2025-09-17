package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmers - 대충 만든 자판(Lv.1)
 *
 * [문제]
 * 휴대폰의 자판은 컴퓨터 키보드 자판과는 다르게 하나의 키에 여러 개의 문자가 할당될 수 있습니다. 키 하나에 여러 문자가 할당된 경우, 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자가 바뀝니다.
 *
 * 예를 들어, 1번 키에 "A", "B", "C" 순서대로 문자가 할당되어 있다면 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"가 되는 식입니다.
 *
 * 같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다. 또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
 *
 * 이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
 *
 * 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
 *
 * 단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
 *
 * [풀이]
 * - targets 배열의 문자열을 문자로 쪼갠다.
 * - target의 문자(c)를 keymap 배열의 문자열마다 몇번째 인덱스에 위치하는지 확인
 * - 가장 작은 인덱스를 갖는 keymap 인덱스를 answer[i]에 누적합산 (i는 targets의 인덱스와 동일)
 * - 만약, -1가 하나라도 존재하면 answer[i]는 -1
 *
 * [개선]
 * - solution은 target이 길어지면 계속 느려지므로 전처리 과정 후, 합산하도록 수정
 */
public class KeymapSolution {
    public static void main(String[] args) {
        String[] keymap = {"AA","CC"};
        String[] targets = {"BB","CCA"};
        System.out.println(Arrays.toString(solution2(keymap, targets)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int k=0; k<targets.length; k++) {
            for(char c : targets[k].toCharArray()) {
                int[] count = new int[keymap.length];
                for(int i=0; i<keymap.length; i++) {
                    count[i] = keymap[i].indexOf(c);
                }

                int minValue = count[0];
                for(int i=1; i<count.length; i++) {

                    if(minValue == -1 || (count[i] != -1 && minValue > count[i])) {
                        minValue = count[i];
                    }
                }

                if(minValue == -1) {
                    answer[k] = -1;
                    break;
                }

                answer[k] += (minValue +1);

            }

        }
        return answer;
    }


    // keymap에 있는 key들의 최소로 누르는 값을 key, value로 저장
    // targets의 문자열을 문자로 쪼개고 위에 Map에서 key값을 찾아 value로 누적
    // 해당하는 key값이 없으면 -1로 answer[i]를 채우고 다음 문자로 넘어가서 위 과정 반복
    public static int[] solution2(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map  = new HashMap<>();

        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                // 기존 값과 value가 작은거 유지
                map.merge(ch,j,Math::min);
            }
        }

        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if(!map.containsKey(ch)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += (map.get(ch)+1);
            }
        }
        return answer;
    }
}
