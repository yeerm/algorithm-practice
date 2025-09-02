package programmers.level1;

import java.util.Arrays;

/**
 * Programmers - 소수찾기(Lv.1)
 *
 * [문제]
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자신으로만 나눠지는 수를 말함
 *
 * [풀이]
 * 개선 필요
 * -> 에라토스테네스의 체
 * - 2부터 n까지 소수의 배수를 지우면 소수만 남겨짐
 * - 소수 후보 p를 증가시키며 p의 배수들을 지움
 * - 배수들을 지우는 작업으로 안에 for문에서는 p*p로 시작 (작은 수들은 이미 이전 배수에서 지워짐)
 */
public class PrimeCounter {
    public static void main(String[] args) {
        int n = 100;
        solution2(n);
    }

    public static int solution2(int n) {
        if (n < 2) return 0;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; (long) p * p <= n; p++) {
            if (!isPrime[p]) continue;
            for (long m = (long) p * p; m <= n; m += p) {
                isPrime[(int) m] = false;
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) if (isPrime[i]) cnt++;
        return cnt;

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
