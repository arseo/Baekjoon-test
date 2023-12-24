import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main { //Scanner 쓰면 시간초과로 나옴 ㅋㅋ;;;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

        int n = Integer.parseInt(br.readLine());
        //Scanner s = new Scanner(System.in);     // 입력받는 것
        Queue<Integer> q = new LinkedList<>();  // 큐
        StringBuilder sb = new StringBuilder (); // 출력 문자열

        //int n = Integer.parseInt(s.nextLine()); // 반복 횟수, 입력 데이터의 수
        int last = 0; // 큐의 마지막 값을 알기 위해

        while (n-- > 0) {
            String str = br.readLine();

            String[] strArray = str.split(" ");
            String cmd = strArray[0];
            int num = 0;
            if (strArray.length != 1) {
                num = Integer.parseInt(strArray[1]);
            }

            switch (cmd) {
               case "push" :    // 큐에 넣기
                   q.add(num);
                   last = num;
                   break;
               case "pop":
                   if (q.isEmpty()) // 큐에 정수가 없으면 -1 출력
                       sb.append("-1").append("\n");
                   else {           // 큐에서 빼면서 값 출력
                       sb.append(q.remove()).append("\n");
                   }
                   break;
               case "size":
                   sb.append(q.size()).append("\n");
                   break;
               case "empty":
                    if (q.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                   break;
               case "front":
                   if (q.isEmpty())
                       sb.append("-1").append("\n");
                   else
                       sb.append(q.element()).append("\n");
                   break;
               case "back":
                   if (q.isEmpty())
                       sb.append("-1").append("\n");
                   else
                       sb.append(last).append("\n");
                   break;
           }
        }
        System.out.println(sb);
    }
}