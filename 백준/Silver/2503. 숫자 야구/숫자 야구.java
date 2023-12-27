    import java.io.*;
    import java.util.*;

    public class Main {

        public static StringBuilder sb = new StringBuilder (); // 출력 문자열

        static class BaseBallData {
            int data;
            int strike;
            int ball;

            public BaseBallData(int data, int strike, int ball) {
                this.data = data;
                this.strike = strike;
                this.ball = ball;
            }
        }
        static List<BaseBallData> inputData = new ArrayList<>();
        static int n;
        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);     // 입력받는 것
            
            // 입력된 정보 저장
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                int data = s.nextInt();
                int strike = s.nextInt();
                int ball = s.nextInt();

                BaseBallData baseBallData = new BaseBallData(data, strike, ball);
                inputData.add(baseBallData);
            }

            
            
            // 각 응답에 대해 만족여부 판단 
            // 모든 응답에 만족하는 숫자의 갯수를 결과로 출력

            System.out.println(calBaseBall());
        }
        static int calBaseBall() {
            int result = 0;

            // 숫자 야구에 나올 수 있는 모든 경우와 응답 비교
            // 123, 124 ... 987
            for (int i = 123; i <= 987; i++) {  
                if (!checkSameNum(i)) continue; // 세자리 안에서 중복숫자 판단 ex 122 이런것

                int allTestPass = 0;    // strike, ball 입력 값이랑 만족여부

                for (int j = 0; j < n; j++) {   // 입력된 값들과 비교
                    int strikeCount = 0;
                    int ballCount = 0;

                    BaseBallData current = inputData.get(j); // 물어본 숫자 차례대로 꺼내기
                    String currentDataString = Integer.toString(current.data);
                    String myDataString = Integer.toString(i);  // for 문 돌아가는 탐색 숫자

                    for (int k = 0; k < 3; k++) { // 각자리수의 값이 같으면 strike++
                        if (currentDataString.charAt(k) == myDataString.charAt(k)) {
                            strikeCount++;
                        }
                    }

                    for (int h = 0; h < 3; h++) {   // 다른 위치에 같은 수가 있으면 ball++
                        for (int u = 0; u < 3; u++) {
                            if (myDataString.charAt(h) == currentDataString.charAt(u)) { 
                                if (h != u)
                                    ballCount++;
                            }
                        }
                    }

                    if (current.strike == strikeCount && current.ball == ballCount) {
                        allTestPass++;  // 탐색 숫자에 대해 strike, ball 모두 만족하면 패스
                    }
                }
                if (allTestPass == n) { // 물어본 것들에 대해 모두 만족하면 정답이 될 수 있으므로 result++
                    result++;
                }
            }
            return result;
        }

        // 세자리 안에서 중복숫자 판단 ex 122 이런것
        static boolean checkSameNum(int num) {
            String numString = Integer.toString(num);   

            if (numString.charAt(0) == numString.charAt(1)) {
                return false;
            }

            if (numString.charAt(1) == numString.charAt(2)) {
                return false;
            }

            if (numString.charAt(0) == numString.charAt(2)) {
                return false;
            }
            // 세자리수 안에 0이 들어가도 안됨
            if (numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0')
                return false;

            return true;
        }
    }

