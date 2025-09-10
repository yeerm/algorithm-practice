package programmers.level1;

/**
 * Programmers - 지폐접기(Lv.1)
 *
 * [문제]
 * 민수는 다양한 지폐를 수집하는 취미를 가지고 있습니다. 지폐마다 크기가 달라 지갑에 넣으려면 여러 번 접어서 넣어야 합니다.
 * 예를 들어 지갑의 크기가 30 * 15이고 지폐의 크기가 26 * 17이라면 한번 반으로 접어 13 * 17 크기로 만든 뒤 90도 돌려서 지갑에 넣을 수 있습니다.
 *
 * 지폐를 접을 때는 다음과 같은 규칙을 지킵니다.
 *
 * 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
 * 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다.
 * 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
 * 지갑의 가로, 세로 크기를 담은 정수 리스트 wallet과
 * 지폐의 가로, 세로 크기를 담은 정수 리스트 bill가 주어질 때,
 * 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return하도록 solution함수를 완성해 주세요.
 *
 * [풀이]
 * - 길이가 긴 방향을 기준으로 잡음
 * - 90도 회전을 할 수 있는걸 감안하여 wallet, bill을 크로스도 확인
 *
 * [개선]
 * - while루프 내부에 if문을 while 조건으로 중복된 if 조건문을 제거함
 */
public class BillFolding {
    public static void main(String[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};

        solution2(wallet, bill);
    }

    public static int solution2(int[] wallet, int[] bill) {
        int answer = 0;

        while(!((bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
                (bill[0] <= wallet[1] && bill[1] <= wallet[0]))) {
            int dir = bill[0] > bill[1] ? 0 : 1;
            bill[dir] = bill[dir]/2;
            answer++;
        }
        return answer;
    }


    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;


        while(true) {

            int dir = bill[0] > bill[1] ? 0 : 1;

            if(bill[dir] <= wallet[dir]) {
                if(dir == 0) {
                    if(bill[1] <= wallet[1]){
                        break;
                    }
                }

                if(dir == 1) {
                    if(bill[0] <= wallet[0]){
                        break;
                    }
                }
            }else {
                if(dir == 0) {
                    if(bill[0] <= wallet[1] && bill[1] <= wallet[0]) break;
                }
                if(dir == 1) {
                    if(bill[1] <= wallet[0] && bill[0] <= wallet[1]) break;
                }


            }
            bill[dir] = bill[dir]/2;
            answer++;

        }

        return answer;
    }
}
