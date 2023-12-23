import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /* nextInt 메소드 이용시에 정수를 엔터를 사용해 입력하는 상황에서, 엔터(개행문자)바로 전까지만 숫자로 입력을 받는다. 즉 개행문자는 제거되지 않는다. 따라서, 개행문자는 뒤에 계속 남아있는 것이다.
        * nextInt 다음에 nextLine 바로 못씀! 개행문자 때문에!!*/
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine()); // 반복 횟수, 입력 데이터의 수

        StringBuilder sb = new StringBuilder (); // 출력 문자열

        while(t>0) {
            String str = s.nextLine();
            Stack<Character> stack = new Stack<>(); // 스택
            
            for (int i = 0; i < str.length(); i++) { // 문자열 하나씩 돌기
                char c = str.charAt(i);

                if (c == '(') { // 여는 괄호는 스택에 넣고
                    stack.push(c);
                } else {  // 닫는 괄호면 스택에서 뺸다
                    if (stack.empty()) { // 비어있는데 닫는 괄호가 남으면 x
                        stack.push(c);   // )를 스택에 넣어준다
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.empty())
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");  // ( 괄호가 남아있을 시
            t--;
        }

        System.out.println(sb);
    }
}