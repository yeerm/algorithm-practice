package programmers.level2;

// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
// 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

import java.util.Arrays;
import java.util.stream.Stream;

public class MinMaxBuilder {

    public static String solution(String s) {
        String answer = "";

        int[] intArr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int min = Arrays.stream(intArr).min().getAsInt();
        int max = Arrays.stream(intArr).max().getAsInt();

        answer = min + " " + max;
//        System.out.println(Arrays.toString(intArr));
        return answer;
    }

    // Stream API 사용하지 않고
    public static String solution2(String s) {
        String[] strArr = s.split(" ");
        int min = Integer.parseInt(strArr[0]);
        int max = Integer.parseInt(strArr[0]);
        for (int i=1; i<strArr.length; i++){
            int tmp = Integer.parseInt(strArr[i]);
            if (tmp > max) max = tmp;
            if (tmp < min) min = tmp;
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        System.out.println("정답:1 4 " + solution("1 2 3 4"));
        System.out.println("정답: -4 -1 " + solution("-1 -2 -3 -4"));
        System.out.println("정답: -1 -1" + solution("-1 -1"));
    }
}
