package programmers.level1;

import java.util.*;

/**
 * Programmers - 완주하지 못한 선수(Lv.1)
 *
 * [문제]
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * [풀이]
 * completion에는 없지만 participant에 없는 인물 찾기 -> 동명이인인 경우 생각해야함
 *
 * [개선]
 * 해시맵을 이용해서 풀 경우 중복이 있는 데이터를 빠르게 카운팅 할 수 있음
 */
public class UnfinishedRunner {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant,completion));

    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return  participant[i];
            }
        }

        return participant[participant.length-1];
    }

    public static String solution2(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        for (String p : participant) m.merge(p, 1, Integer::sum);
        for (String c : completion) m.merge(c, -1, Integer::sum);
        for (var e : m.entrySet()) if (e.getValue() != 0) return e.getKey();
        return "";
    }

    public static String solution3(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        // 1) 참가자 카운트 +1
        for (String p : participant) {
            count.put(p, count.getOrDefault(p, 0) + 1);
            // 또는: count.merge(p, 1, Integer::sum);
        }

        // 2) 완주자 카운트 -1
        for (String c : completion) {
            count.put(c, count.get(c) - 1);
            // 또는: count.merge(c, -1, Integer::sum);
        }

        // 3) 값이 1(또는 0이 아닌)인 이름이 미완주자
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() != 0) return e.getKey();
        }
        return "";
    }


}
