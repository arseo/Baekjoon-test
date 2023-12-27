    import java.io.*;
    import java.util.*;

    public class Main {

        public static StringBuilder sb = new StringBuilder (); // 출력 문자열
        static boolean[] visitiedFlag;
        static int[][] arr;

        static int node, line, start;
        static Queue<Integer> queue = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것

            node = s.nextInt();    // 정점의 개수
            line = s.nextInt();    // 간선의 개수
            start = s.nextInt();    // 탐색을 시작할 정점
            int gragh_arr_size = node + 1;      // 그래프 사이즈

            arr = new int[gragh_arr_size][gragh_arr_size];  // 정점 숫자 오름차순으로 하기 위해 배열 사용
            visitiedFlag = new boolean[gragh_arr_size];

            for (int i = 0; i < line; i++) {    // 배열안에 그래프 구현
                int a = s.nextInt();
                int b = s.nextInt();
                arr[a][b] = arr[b][a] = 1;
            }

            dfs(start);
            sb.append("\n");
            visitiedFlag = new boolean[gragh_arr_size];

            bfs(start);
            System.out.println(sb);
        }

        public static void dfs(int start) { // 첫 정점 방문하고 연결된 다음 정점으로 들어가는 재귀
            visitiedFlag[start] = true;
            sb.append(start).append(" ");

            for (int i = 0; i <= node; i++) {
                if (arr[start][i] == 1 && !visitiedFlag[i])
                    dfs(i);
            }
        }

        public static void bfs(int start) { // 첫 정점 방문하고 큐에 넣고 연결된 정점 모두 방문
            queue.add(start);               // 큐에서 노드를 꺼낸 뒤 인접 노드 중 방문하지 않은 노드 큐에 다 넣고 방문 처리
            visitiedFlag[start] = true;

            while (!queue.isEmpty()) {
                start = queue.poll();
                sb.append(start).append(" ");

                for (int i = 1; i <= node; i++) {
                    if (arr[start][i] == 1 && !visitiedFlag[i]) {
                        queue.add(i);
                        visitiedFlag[i] = true;
                    }
                }
            }
        }
    }

