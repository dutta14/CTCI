package TreesAndGraphs;

import java.util.Scanner;

/**
 * Created by Anindya on 2/11/2017.
 */
public class CreateMinimalBST {

    TreeNode create(int[] arr, int low, int high) {
        if(high < low)
            return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeft(create(arr,low,mid-1));
        root.setRight(create(arr,mid+1,high));
        return root;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = s.nextInt();

        CreateMinimalBST obj = new CreateMinimalBST();
        TreeNode t = obj.create(arr,0,arr.length-1);
        System.out.println(t);
    }
}
