    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int n;
        static boolean[][] visitedFlag;     // 방문여부
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int count;
        static int result = 1;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; i++) {   // 값 저장해주기
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > max) max = map[i][j];    // 값들 중에 최대값 구하기
                }
            }

            for (int height = 1; height <= max; height++) { // 1~부터 최대값 돌면서 영역 구하기
                visitedFlag = new boolean[n][n];
                count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // 방문한 적이 없고 안전지대이면 dfs 시작
                        if (!visitedFlag[i][j] && map[i][j] > height) {
                            dfs(i, j, height);
                            count ++;
                        }
                    }
                }
                result = Math.max(count, result);
            }
            System.out.println(result);
        }

        public static void dfs(int i, int j, int height) {
            visitedFlag[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextX = i + dx[k];
                int nextY = j + dy[k];
                // 다음 값이
                // 1. 배열의 범위를 넘지 않는다
                // 2. 물에 잠기지 않는다
                // 3. 방문한 적이 없다  ==> dfs 실행
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                && map[nextX][nextY] > height && !visitedFlag[nextX][nextY]) {
                    dfs(nextX, nextY, height);
                }
            }
        }
    }