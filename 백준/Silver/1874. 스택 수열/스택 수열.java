import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt(); // 반복 횟수
        Stack<Integer> stackInt = new Stack<>(); // 스택
        StringBuilder sb = new StringBuilder (); // 출력 문자열
        int cnt = 0;

        while(num-->0) {
            int value = s.nextInt(); // 입력 정수

            if(value > cnt) { // 입력 받은 값보다 카운트가 작으면 스택에 추가
                for (int i = cnt +1; i <= value; i++) {
                    stackInt.push(i);
                    sb.append("+").append("\n");
                }
                cnt = value;    // 다음 숫자 넣기 위해 값 저장해둠
            } else if (stackInt.peek() != value) {
                System.out.println("NO");
                return;
            }

            stackInt.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}