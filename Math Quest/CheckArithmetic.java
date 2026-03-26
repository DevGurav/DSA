public class CheckArithmetic {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }       
        if ((max-min) % (n-1) != 0) return false;
        int diff = (max-min) / (n-1);
        if (diff == 0) return true;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if ((arr[i]-min) % diff != 0) 
                return false;
            int index = (arr[i]-min) / diff;
            if (seen[index] == true) 
                return false; 
            seen[index] = true;
        }
        return true;
    }
    public static void main(String args[])
    {
        CheckArithmetic obj = new CheckArithmetic();
        int [] input = {1,3,5,7};
        System.out.println("result :" + obj.canMakeArithmeticProgression(input));
    }
}










// runtime 5ms

//import java.util.Arrays;

// public class CheckArithmetic {
//     public boolean canMakeArithmeticProgression(int[] arr) {
//         if(arr.length<=2)
//         {
//             return true;
//         }
//         Arrays.sort(arr);
//         int diff =arr[1]-arr[0];
//         for(int i=1;i<arr.length-1;i++)
//         {
//             if(diff!=(arr[i+1]-arr[i]))
//             return false;
//         }
//         return true;
//     }
// }
