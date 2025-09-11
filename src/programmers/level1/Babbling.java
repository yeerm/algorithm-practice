package programmers.level1;

import java.util.*;

/**
 * Programmers - 옹알이(Lv.1)
 *
 * [문제]
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
 * 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * [풀이]
 * - babbling에 네 가지 발음이 연속되어 포함되는지 확인
 * - 단어 파싱해서 발음할 수 있는 단어에 포함되는지 확인
 * - 포함된 단어는 제거 후, 마지막에 빈문자열일 경우 카운팅에 포함
 *
 */
public class Babbling {
    public static void main(String[] args) {
        String[] babbling = {"ayayeaya", "uuu", "yeye", "yemawooye", "ayaayaa", "ayayeyeaya"};
        solution(babbling);
    }

    public static int solution2(String[] babbling) {
        int answer = 0;
        String[] filter = {"aya", "ye", "woo", "ma"};

        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<filter.length; j++) {
                if(!babbling[i].contains("ayaaya")
                        && !babbling[i].contains("yeye")
                        && !babbling[i].contains("woowoo")
                        && !babbling[i].contains("mama")) {
                    babbling[i] = babbling[i].replace(filter[j], " ");
                }
            }
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i].isEmpty()) {answer++;}
        }
        return answer;
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        List<String> babblingList = List.of("aya", "ye", "woo", "ma");
        List<String> result = new ArrayList<>();

        for(int i=0; i<babbling.length; i++) {
            boolean hasRepeat = false;
            for(int h=0; h<babblingList.size(); h++) {
                if(babbling[i].contains(babblingList.get(h).repeat(2))) {
                    hasRepeat = true;
                    break;
                }
            }
            if(!hasRepeat) { result.add(babbling[i]); }
        }


        for(String s: result) {
            char[] charArray = s.toCharArray();
            String word = "";
            for(int i=0; i<charArray.length; i++) {
                word += charArray[i];
                for(int j=0; j<babblingList.size(); j++) {
                    if(word.equals(babblingList.get(j))) {
                        word = "";
                        break;
                    }
                }
            }
            if(word.isEmpty()) answer++;
        }


        return answer;
    }

}
