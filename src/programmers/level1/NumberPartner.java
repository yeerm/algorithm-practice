package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Programmers - 숫자 짝꿍(Lv.1)
 *
 * [문제]
 * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
 * (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
 * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
 *
 * 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
 * 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
 * (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
 * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 *
 * [풀이]
 * - x, y의 0부터 9까지 숫자가 몇번 나오는지 카운트
 * - 둘다 1개라도 카운트가 되면 둘 중의 작은 개수만큼 문자열로 만듬
 * - 가장 큰 수로 만드려면 반복문을 내림차순으로
 * - 공통으로 나타난 숫자들은 내림차순 정렬
 * - 공통으로 나타나는 숫자가 없으면 -1 return
 * - 공통으로 나타나는 숫자가 0밖에 없으면 개수와 상관없이 0 return
 */
public class NumberPartner {
    public static void main(String[] args) {
        String x = "5525";
        String y = "1255";
        System.out.println(solution2(x,y));
    }

    public static String solution(String x, String y) {
        String answer = "";
        List<Integer> integerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(y);

        for(char c: x.toCharArray()) {
            int index = y.indexOf(c);
            if(index != -1) {
                sb.deleteCharAt(index);
                integerList.add(Integer.valueOf(c-'0'));
            }
            y = sb.toString();
        }

        if(integerList.isEmpty()) return "-1";

        if(integerList.stream().allMatch(n -> n == 0)) return "0";

        integerList.sort(Comparator.reverseOrder());

        for (Integer integer : integerList) {
            answer += integer;
        }

        return answer;
    }

    public static String solution2(String x, String y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] xNumber = new int[10];
        int[] yNumber = new int[10];

        for(int i=0; i<x.length(); i++) {
            xNumber[x.charAt(i)-'0']++;
        }

        for(int i=0; i<y.length(); i++) {
            yNumber[y.charAt(i)-'0']++;
        }

        for(int i=9; i>=0; i--) {
            if(xNumber[i] > 0 && yNumber[i] > 0 ) {
                int target = Math.min(xNumber[i], yNumber[i]);
                if(target >= 2) {
                    String str = i + "";
                    str = str.repeat(target);
                    sb.append(str);
                }else {
                    sb.append(i);
                }
            }
        }

        if(sb.toString().length() == 0) return "-1";
        if(sb.toString().replaceAll("0", "").isEmpty()) return "0";
        answer = sb.toString();


        return answer;
    }
}
