package programmers.level1;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        solution(6, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
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

        //System.out.println("answer: " + Arrays.toString(answer));
        return answer;
    }
}
