package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * programmers - 2016년(Lv.1)
 *
 * [문제]
 * 2016년 1월 1일은 금요일입니다.
 * 2016년 a월 b일은 무슨 요일일까요?
 * 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
 * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
 *
 * [풀이]
 * - 1월 1일부터 a월 b일까지 일 수를 구한다. (합계에서 -1 하지 않으면 1월 1일 하루를 지나고 계산하게 됨)
 * - a월 b일까지의 일 수를 7일로 나눈 나머지로 요일을 찾는다.
 */
public class Year2016 {
    public static void main(String[] args) {
        solution(5,24);
    }

    public static String solution(int a, int b) {
        String answer = "";
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = b - 1;

        for(int i=0; i<a-1; i++) {
            totalDays += dayOfMonth[i];
        }

        answer = dayOfWeek[totalDays%7];


        return answer;
    }
}
