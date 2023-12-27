    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int n;
        static int m;
        static boolean[][] visitedFlag;
        static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
        static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];    // 미로 저장
            for(int i=0; i<n; i++) {
                String s = br.readLine();
                for(int j=0; j<m; j++) {
                    map[i][j] = s.charAt(j) - '0'; // char -> int 변환
                }
            }

            visitedFlag = new boolean[n][m];
            visitedFlag[0][0] = true;
            bfs(0, 0);
            System.out.println(map[n-1][m-1]);
        }

        public static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {x,y});  // 큐에 방문한 곳 넣기

            while(!q.isEmpty()) {
                int now[] = q.poll();   // 큐에서 지금 위치 꺼낸 뒤 인접 위치 중 방문하지 않은 곳 큐에 넣고 방문 처리
                int nowX = now[0];
                int nowY = now[1];

                for(int i=0; i<4; i++) {    // 상하좌우 4방향 탐색
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) // 행렬 좌표 범위를 벗어나는 경우 넘어가기
                        continue;
                    if (visitedFlag[nextX][nextY] || map[nextX][nextY] == 0)// 방문했던 곳이거나 갈 수 없는 곳이면 넘어가기
                        continue;

                    q.add(new int[] {nextX, nextY});    // 큐에 다음 위치 넣기
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    visitedFlag[nextX][nextY] = true;
                }
            }
        }
    }