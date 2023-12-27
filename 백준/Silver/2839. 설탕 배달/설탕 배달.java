    import java.io.*;
    import java.util.*;

    public class Main {

        //public static StringBuilder sb = new StringBuilder(); // 출력 문자열


        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것

            int n = s.nextInt();
            int result = 0;

            while (n > 0) {
                if(n % 5 == 0) {    // 5로 나누어 떨어지는 경우
                    result += n / 5;
                    break;
                }
                if (n < 3) {    // 3키로 보다 작을때 떨어지지 않으므로 -1
                    result = -1;
                    break;
                }   
                n -= 3;     // 5로 나누어 떨어지지 않음 && 3으로 먼저 나누어서 가능한 경우
                result++;
            }
            System.out.println(result);
        }
    }