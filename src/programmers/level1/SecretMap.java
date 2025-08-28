package programmers.level1;

import java.util.Arrays;

/**
 *  programmers - 비밀지도(Lv.1)
 *
 *  [문제]
 *  네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
 *
 * 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 * 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 * "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 * 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 * 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
 *
 * [초안 풀이]
 * - arr1, arr2를 각각 2진수 문자열로 변환
 * - char 배열로 만들어서 비교
 * - 자릿수가 0,0 일떄만 공백으로 채우고 나머지는 #으로 채움
 *
 * [개선]
 * - arr1[i] | arr2[i] 한 번만 계산 (OR연산을 포함한 2진수 변환)
 * - replace로 0,1 각각 ' '(공백),'#'로 치환하여 간결화
 *
 *
 *
 */
public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        solution(6, arr1, arr2);
    }

    // 개선
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%" + n + "s";

        for(int i=0; i<n; i++) {
            // 2진수 변환 (OR연산 포함)
            String binaryStr = String.format(format, Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replace('1','#')
                    .replace('0',' ');
            answer[i] = binaryStr;
        }

        System.out.println("answer = " + Arrays.toString(answer));

        return answer;
    }

    // 초안풀이
    public static String[] firstSolution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%"+ n + "s";

        for(int i=0; i<n; i++) {
            // 2진수 변환
            String binaryArr1 = String.format(format, Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binaryArr2 = String.format(format, Integer.toBinaryString(arr2[i])).replace(' ', '0');

            // String -> char[] (자릿수마다 더한 결과를 얻기 위함)
            char[] charArr1 = binaryArr1.toCharArray();
            char[] charArr2 = binaryArr2.toCharArray();

            // 자릿수 결과
            String target = "";

            // 자릿수별 더하기
            for(int j=0; j<n; j++) {
                int num1 = (charArr1[j] - '0');
                int num2 = (charArr2[j] - '0');

                if(num1 == 0 && num2 == 0){
                    target += ' ';
                }else {
                    target += '#';
                }
            }

            answer[i] = target;
        }

        return answer;
    }
}
