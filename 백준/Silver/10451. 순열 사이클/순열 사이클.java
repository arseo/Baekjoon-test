    import java.io.*;
    import java.util.*;

    public class Main {

        static int[] map;
        static int n;
        static int t;
        static boolean[] visitedFlag;     // 방문여부
        static int count;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                n = Integer.parseInt(br.readLine());
                map = new int[n + 1]; // 0번째는 사용하지 않음
                visitedFlag = new boolean[n + 1];
                count = 0;
                
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i < n + 1; i++) {
                    map[i] = Integer.parseInt(st.nextToken());
                }

                for (int i = 1; i < n + 1; i++) {
                    if (visitedFlag[i] == false) {  // 해당 노드 방문한 적 없으면 dfs 시작
                        dfs(i, map[i]);
                    }
                }
                System.out.println(count);
            }
        }

        public static void dfs(int i, int start) {  // 현재 노드, 시작 노드
            visitedFlag[i] = true;  // 현재노드 방문처리

            if (visitedFlag[map[i]] == false) { // 다음 노드 방문 안했으면 dfs
                dfs(map[i], start);
            }
            if (visitedFlag[map[i]] == true && start == map[i]) {   // 다음 노드 방문했음 + 시작 노드랑 같으면 사이클 카윤트 올려주기
                count++;
            }
        }
    }