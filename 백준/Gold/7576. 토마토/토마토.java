    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int n, m;
        static boolean[][] visitedFlag;     // 방문여부
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static Queue<int[]> queue = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n= Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visitedFlag = new boolean[n][m];
            for (int i = 0; i < n; i++) {   // 값 저장
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1)
                        queue.add(new int[] {i, j});
                }
            }

            System.out.println(bfs());
        }

        public static int bfs() {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }

            if (cnt == 0)   // 모든 토마토가 익어있는 상태이면 0 출력
                return 0;

            while (!queue.isEmpty()) {  // bfs 시작
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                    && map[nextX][nextY] == 0) {
                        map[nextX][nextY] = map[x][y] + 1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    } else if (map[i][j] == 0) {    // 익지 않은 토마토가 있을 시에
                        return -1;
                    }
                }
            }
            return max-1;   // 익을떄까지의 총 날짜 출력
        }
    }