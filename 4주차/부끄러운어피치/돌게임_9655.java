import java.util.*;

public class 돌게임_9655 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String answer = "";

            if(n%2 == 0) answer+="CY";
            else answer+="SK";

            System.out.println(answer);

        }
}
