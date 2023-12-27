    import java.io.*;
    import java.util.*;

    public class Main {

        public static StringBuilder sb = new StringBuilder(); // 출력 문자열


        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것

            // 입력된 정보 저장
            int n = s.nextInt();
            int m = s.nextInt();
            ArrayList<Integer> cards = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                cards.add(s.nextInt());
            }

            int max = 0;
            for (int i = 0; i < n; i++) {   // 첫번째 카드
                for (int j = 0; j < n; j++) {   // 두번째 카드
                    if (i == j) // 첫번째카드랑 같은거 고를 수 없음
                        continue;
                    for (int k = 0; k < n; k++) {   // 세번째 카드
                        if (i == k || j ==k)    // 첫, 두번째와 같은 카드 고를 수 없음
                            continue;
                        int sum = cards.get(i) + cards.get(j) + cards.get(k);   

                        if (m >= sum && sum > max)  // max < sum <= m 이면 max에 값 저장
                            max = sum;
                    }
                }
            }

            System.out.println(max);
        }
    }