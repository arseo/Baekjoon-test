    import java.io.*;
    import java.util.*;

    public class Main {

     

        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것
            int n = s.nextInt();
            int result = 0;
            for (int i = 1; i <= n; i++) {
                int sum = i;
                int number = i;

                while(number != 0) {
                    sum += number % 10;	// 각 자릿수 더하기
                    number /= 10;
                }

                if (sum == n) {
                    result = i;
                    break;
                }

            }
            System.out.println(result);
        }
    }