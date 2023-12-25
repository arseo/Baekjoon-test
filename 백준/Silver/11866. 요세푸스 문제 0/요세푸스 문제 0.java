    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    import java.util.Stack;

    public class Main {
        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것
            Queue<Integer> q = new LinkedList<>();  // 큐
            StringBuilder sb = new StringBuilder (); // 출력 문자열
            int n = s.nextInt();
            int k = s.nextInt();

            for (int i = 1; i <= n; i++) {  // 큐에 값 넣기
                q.offer(i);
            }
            sb.append("<");
            while (q.size()> 1) { // 큐 사이즈가 1보다 클때
                int cnt = 0;
                for (int i = 0; i < k; i++) {
                    cnt++;
                    if (cnt < k) {  // 맨 앞의 데이터 뒤로 넣어주기
                        q.offer(q.peek());
                        q.poll();
                    } else {
                        sb.append(q.poll()).append(", ");    // 해당 순서 데이터 지우면서 출력
                    }

                }
            }
            sb.append(q.poll()).append(">");
            System.out.println(sb);
        }
    }