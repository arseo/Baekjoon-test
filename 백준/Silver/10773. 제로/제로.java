import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int k = s.nextInt(); // 반복 횟수
        Stack<Integer> stackInt = new Stack<>(); // 스택
        StringBuilder sb = new StringBuilder (); // 출력 문자열
        int sum = 0; // 총 합

        while(k-->0) {
            int value = s.nextInt(); // 입력 정수
            
            if (value != 0) {
                stackInt.push(value);   // 스택에 값 넣어주기
                sum += stackInt.peek(); // 스택의 맨 윗 값 더하기
            } else {
                sum -= stackInt.pop(); // 스택의 맨 윗값 총합에서 빼면서 스택에서 제거
            }

        }

        System.out.println(sum);
    }
}