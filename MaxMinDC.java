import java.util.*;
public class MaxMinDC {
    private static class MaxMinPair{
        int max,min;

        MaxMinPair(int max,int min)
        {
            this.max=max;
            this.min=min;
        }
    }

    public static MaxMinPair findMaxMin(int[] arr)
    {
        if(arr==null||arr.length==0)
         return null;
        
         return findMaxMinDC(arr,0,arr.length-1);
    }

    private static MaxMinPair findMaxMinDC(int[] arr,int left,int right)
    {
        int mid;
        if(left==right)
        {
            return new MaxMinPair(arr[left], arr[right]);//Base Case
        }

        if(right-left==1)
        {
            return new MaxMinPair(Math.max(arr[left],arr[right]),Math.min(arr[left],arr[right]));
        }

        else{

            //Dividing array into two halves
            mid=left+(right-left)/2;
            MaxMinPair localLeft=findMaxMinDC(arr,left,mid);
            MaxMinPair localRight=findMaxMinDC(arr,mid+1,right);

            //Combining results
            int max=Math.max(localLeft.max,localRight.max);
            int min=Math.min(localLeft.min,localRight.min);

            return new MaxMinPair(max, min);

        }
    }

    public static void main(String[] args)
    {
        int[] arr={9,1,3,4,10,-1,11,20,8};
        MaxMinPair result=findMaxMin(arr);

        System.out.println("The Maximum is:"+result.max);
        System.out.println("The Minimum is:"+result.min);
    }
}
