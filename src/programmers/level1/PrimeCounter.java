package programmers.level1;

/**
 * Programmers - 소수찾기(Lv.1)
 *
 * [문제]
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자신으로만 나눠지는 수를 말함
 *
 * [풀이]
 * 개선 필요
 */
public class PrimeCounter {
    public static void main(String[] args) {
        int n = 100;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i++) {
            boolean isPrime = true;
            if(i == 2) answer ++;
            if(i % 2 == 0) continue;
            for(int j=3; j*j<=i; j+=2) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) answer++;
        }
        return answer;
    }
}
