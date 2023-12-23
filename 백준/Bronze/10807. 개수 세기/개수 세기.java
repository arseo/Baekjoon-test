import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int n = sc.nextInt();  // 배열 길이 받기
        int[] intArray = new int[n]; // 배열 생성

        for(int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();			 // 배열에 입력한 정수들 넣어주기
        }
        int v = sc.nextInt();

        for (int i = 0; i < intArray.length; i++) {
            if (v == intArray[i]) cnt++;
        }

        System.out.println(cnt);
    }
}