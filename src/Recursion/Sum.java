package Recursion;

public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }
    public static int sum(int[] arr,int l){
//        if(l==arr.length){
//            return 0;
//        }
        if(l==arr.length-1){
            return arr[l];
        }else{
          int x = sum(arr,l+1);
          return arr[l]+x;
        }
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,2,3,5,6,8,6,4,9,7}));
    }
}
