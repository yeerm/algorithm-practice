package programmers.level1;

/**
 * Programmers - 이웃한 칸(Lv.1)
 * [문제]
 * 각 칸마다 색이 칠해진 2차원 격자 보드판이 있습니다.
 * 그중 한 칸을 골랐을 때, 위, 아래, 왼쪽, 오른쪽 칸 중 같은 색깔로 칠해진 칸의 개수를 구하려고 합니다.
 *
 * 보드의 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board와
 * 고른 칸의 위치를 나타내는 두 정수 h, w가 주어질 때 board[h][w]와 이웃한 칸들 중
 * 같은 색으로 칠해져 있는 칸의 개수를 return 하도록 solution 함수를 완성해 주세요.
 *
 * [풀이]
 * - 이웃한 칸들의 위치를 구한다.
 * - 고른 칸의 색상과 일치하는 색상을 가졌으면 카운팅
 */
public class NeighborCell {
    public static void main(String[] args) {
        String[][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        solution(board, 0, 0);
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        String color = board[h][w];

        //위
        int up = h-1;
        if(up >= 0) {
            if(color.equals(board[up][w])) answer++;
        }

        //오른쪽
        int right = w+1;
        if(right < board.length) {
            if(color.equals(board[h][right])) answer++;
        }

        //아래
        int down = h+1;
        if(down < board.length) {
            if(color.equals(board[down][w])) answer++;
        }
        //왼쪽
        int left = w-1;
        if(left >= 0) {
            if(color.equals(board[h][left])) answer++;
        }


        return answer;
    }

    // 확장성 고려했을때 더 나은 방법
    public static int solution2(String[][] board, int h, int w) {
        String color = board[h][w];
        int H = board.length;
        int W = board[0].length;
        int cnt = 0;


        int[][] dirs = {
                {-1, 0},  // 위
                { 1, 0},  // 아래
                { 0,-1},  // 왼쪽
                { 0, 1}   // 오른쪽
        };

        for (int[] d : dirs) {
            int nh = h + d[0];
            int nw = w + d[1];
            if (0 <= nh && nh < H && 0 <= nw && nw < W
                    && color.equals(board[nh][nw])) {
                cnt++;
            }
        }
        return cnt;
    }
}
