import java.util.*;

public class Main {

       static int[] nextGreatestElement(int[] arr){
        //   Stack<Integer> stack = new Stack<>();
           int n = arr.length;
           int[] result = new int[n];
           for(int i=0;i<n;i++){
               for(int j=i;j<n;j++){
                   if(arr[i]<arr[j]){
                       result[i] = arr[j];
                       break;
                   }
                   else{
                       result[i] = -1;
                   }
               }
           }
           return result;
       }

    public static void main(String[] args) {
        int[] s = {5,6,3,2,4,0};
        int result[] = nextGreatestElement(s);

            System.out.println(Arrays.toString(result));
    }
}
