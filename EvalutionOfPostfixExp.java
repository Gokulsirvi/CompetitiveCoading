import java.util.*;

public class Main {

       static int evaluatePostfix(String s) {
            Stack<Integer> stack = new Stack<>();
            
            String[] tokens = s.split(" ");
            for(String ch : tokens){
              if(ch.equals("+")||ch.equals("-") ||ch.equals("/")||ch.equals("*")){
              int b= stack.pop();
              int a = stack.pop();
              switch(ch){
              case "+": stack.push(a+b);break;
              case "-": stack.push(a-b);break;
              case "/": stack.push(a/b);break;
              case "*": stack.push(a*b);break;
            }
              }
            else{
                stack.push(Integer.parseInt(ch));
            }
            }
            return stack.pop();
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        String s = sc.nextLine();
        // String[] tokens = s.split(" ");

        // PostfixEvaluator evaluator = new PostfixEvaluator();
        int result = evaluatePostfix(s);

            System.out.println(result);
        sc.close();
    }
}
