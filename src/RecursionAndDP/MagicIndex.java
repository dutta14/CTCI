package RecursionAndDP;

import java.util.Scanner;

/**
 * Created by Anindya on 2/13/2017.
 */
public class MagicIndex {

    private int magicIndex(int[] arr, int l, int r) {
        if(r<l)
            return -1;
        int mid = (l+r)/2;
        if(arr[mid] == mid)
            return mid;
        int rindex = magicIndex(arr, Math.max(arr[mid],mid+1),r);
        if(rindex >-1)
            return rindex;
        int lindex = magicIndex(arr, l,Math.min(arr[mid],mid-1));

        return lindex;
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = s.nextInt();

        MagicIndex obj = new MagicIndex();
        int index = obj.magicIndex(arr,0,n-1);
        System.out.println(index);
    }


}
