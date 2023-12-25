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
        //sb = new StringBuilder (); // 출력 문자열
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {  // 1~n 까지 큐에 넣기
            q.add(i);
        }

        // 큐에 하나 남을때까지 반복
        while (q.size() > 1) {
            q.poll(); // front 삭제 후 front 값 맨 뒤로 보내기
            q.add(q.poll());
        }

        System.out.println(q.poll());
    }
}