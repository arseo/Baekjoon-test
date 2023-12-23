import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        Stack<Integer> stackInt = new Stack<>();
        StringBuilder sb = new StringBuilder ();

        for (int i=0; i<num; i++) {
            String order = s.next();
            switch(order) {
                case "push":
                    stackInt.push(s.nextInt());
                    break;
                case "pop":
                    if (stackInt.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(stackInt.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stackInt.size()).append("\n");
                    break;
                case "empty":
                    if (stackInt.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "top":
                    if (stackInt.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(stackInt.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}