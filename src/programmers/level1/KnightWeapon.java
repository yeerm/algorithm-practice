package programmers.level1;

/**
 * programmers - 기사단원의 무기(Lv.1)
 *
 * [문제]
 * 기사단의 각 기사는 1번부터 number 까지 번호가 지정되어 있다.
 * 각 기사는 자신의 번호 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 한다.
 * 단, 이웃나라 협약에 의해 최대 공격력 수치가 정해져 있고, 제한수치가 넘어가면 협약기관에서 정한 공격력의 무기를 구매해야한다.
 * 무기의 무게는 공격력 1당 1kg의 철이 필요하다고 했을 때, 무기점에서 기사들의 무기를 만들기 위해 필요한 철의 무게를 구해라.
 *
 * [제한사항]
 * 1 ≤ number ≤ 100,000
 * 2 ≤ limit ≤ 100
 * 1 ≤ power ≤ limit
 *
 * [초안풀이]
 * - 1에서 number까지의 약수의 개수를 모두 구한다.
 * - 단, 저장하기 전 최대 공격력 수치를 넘는 경우 협약기관에서 정한 공격력으로 지정한다.
 * - 나온 공격력 (=철의 무게)를 모두 합한다.
 *
 * [개선풀이]
 * 초안풀이 시간초과로 다시 풀이함
 * - 약수는 한 쌍으로 존재하므로 i를 제곱근까만 확인하도록 함
 * - 약수 개수를 카운팅 하는 반복문에 한 쌍의 약수가 동일한 숫자가 아니라면 카운트를 한 번 더 하도록 수정
 *
 */
public class KnightWeapon {
    public static void main(String[] args) {
        solution2(5,3,2);
    }

    public static int solution2(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            int cnt = 0;
            int j = 1;

            while(j * j <= i) {
                if(i % j == 0) {

                    cnt++;
                }
                j++;
            }

            if(limit < cnt) cnt = power;
            answer += cnt;
        }

        System.out.println("answer: " + answer);

        return answer;
    }

    public static int solution1(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            int cnt = 0;
            int j = 1;

            while(j <= i) {
                if(i % j == 0) {

                    cnt++;
                }
                j++;
            }

            if(limit < cnt) cnt = power;
            answer += cnt;
        }

        System.out.println("answer: " + answer);

        return answer;
    }
}
