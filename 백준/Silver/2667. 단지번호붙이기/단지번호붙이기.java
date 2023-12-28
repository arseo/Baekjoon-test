    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int n;
        static boolean[][] visitedFlag;     // 방문여부
        static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
        static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우
        static int count = 0;
        static int number = 0;  // 단지별 숫자이자 단지가 몇개인지 카운트
        static int nextX, nextY;


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            map = new int[n][n];    // 지도 저장
            visitedFlag = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visitedFlag[i][j] == false && map[i][j] == 1) { // 집이 있는데 방문한 적이 없으면
                        count = 0;
                        number++;
                        dfs(i, j);
                        list.add(count);
                    }
                }
            }

            Collections.sort(list);
            bw.append(number + "\n");
            for (int num : list) {
                bw.append(num + "\n");
            }

            bw.flush();
            bw.close();

        }

        public static void dfs(int x, int y) {
            visitedFlag[x][y] = true;
            map[x][y] = number; // 단지 별 숫자로 넣어주기
            count ++;   // 단지 안 집의 갯수 세기

            for (int i = 0; i < 4; i++) {   // 상하좌우 이동할 수 있는 곳 탐색
                nextX = dx[i] + x;
                nextY = dy[i] + y;
                // map 범위를 넘지 않기 && 방문한 적이 없는 곳 && 값이 있는 곳 이 다음 위치면
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n
                && !visitedFlag[nextX][nextY] && map[nextX][nextY] == 1) {

                    dfs(nextX, nextY);
                }
            }

        }
    }