    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int r, c;
        static boolean[] visitedFlag;     // 방문여부
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int result = 0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c= Integer.parseInt(st.nextToken());

            map = new int[r][c];
            visitedFlag = new boolean[26];  // 알파벳의 갯수가 26이기 때문
            for (int i = 0; i < r; i++) {   // 값 저장
                String str = br.readLine();
                for (int j = 0; j < c; j++) {
                    // 알파벳을 숫자로 저장하여 배열의 index로 사용할 것이기 때문에 대문자 A 빼주기
                    map[i][j] = str.charAt(j) - 'A';  
                }
            }

            dfs(0, 0, 1);

            System.out.println(result);
        }

        public static void dfs(int x, int y, int count) {
            visitedFlag[map[x][y]] = true;
            result = Math.max(result, count);
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < r && nextY < c) {
                    if (!visitedFlag[map[nextX][nextY]]) {
                        dfs(nextX, nextY, count+1);
                        visitedFlag[map[nextX][nextY]] = false;   // 빠져나올때 방문 표시 false 바꿔줘야 다음 탐색 수행가능
                    }

                }
            }

        }
    }