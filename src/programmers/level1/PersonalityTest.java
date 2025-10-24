package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * Programmers - 성격유형검사 (Lv.1)
 *
 * [문제]
 * 나만의 카카오 성격 유형 검사지를 만들려고 합니다.
 * 성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.
 *
 * 지표 번호	성격 유형
 * 1번 지표	라이언형(R), 튜브형(T)
 * 2번 지표	콘형(C), 프로도형(F)
 * 3번 지표	제이지형(J), 무지형(M)
 * 4번 지표	어피치형(A), 네오형(N)
 *
 * 검사지에는 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개의 선택지가 있습니다.
 *
 * 매우 비동의
 * 비동의
 * 약간 비동의
 * 모르겠음
 * 약간 동의
 * 동의
 * 매우 동의
 *
 * 각 질문은 1가지 지표로 성격 유형 점수를 판단합니다.
 *
 * 예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있습니다.
 *
 * 선택지	성격 유형 점수
 * 매우 비동의	네오형 3점
 * 비동의	네오형 2점
 * 약간 비동의	네오형 1점
 * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
 * 약간 동의	어피치형 1점
 * 동의	어피치형 2점
 * 매우 동의	어피치형 3점
 *
 *검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다.
 * 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
 *
 * 질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다.
 * 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
 *
 * [풀이]
 *
 */
public class PersonalityTest {
    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        String[] survey = {"TR", "RT", "TR"};
//        int[] choices = {5, 3, 2, 7, 5};
        int[] choices = {7, 1, 3};
        System.out.println(solution(survey,choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] type = {{'R','T'}, {'C','F'},{'J','M'},{'A','N'}};

        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

//        Map<Integer, Integer> score = new HashMap<>();
//        score.put(1,3);
//        score.put(2,2);
//        score.put(3,1);
//        score.put(5,1);
//        score.put(6,2);
//        score.put(7,3);

        int[] score = {0,3,2,1,0,1,2,3};

        for(int i=0; i<survey.length; i++) {
            if(choices[i] == 4) continue;
            char c = choices[i] < 4 ? survey[i].charAt(0) : survey[i].charAt(1);
            map.merge(c, score[choices[i]], Integer::sum);
        }

        StringBuilder sb = new StringBuilder();

        for (char[] chars : type) {
            int typeA = map.get(chars[0]);
            int typeB = map.get(chars[1]);

            char result = typeA > typeB ? chars[0] : typeA < typeB ? chars[1] : chars[0];
            sb.append(result);
        }

        answer = sb.toString();

        return answer;
    }
}
