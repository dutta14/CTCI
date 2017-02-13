package TreesAndGraphs;

import java.util.Scanner;

/**
 * Created by Anindya on 2/12/2017.
 */
public class CheckIfBalanced {

    int checkBalanced(TreeNode t) {
        if(t == null)
            return -1;
        int lHeight = checkBalanced(t.left);
        if(lHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rHeight = checkBalanced(t.right);
        if(rHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int diff = Math.abs(lHeight - rHeight);
        if(diff > 1)
            return Integer.MIN_VALUE;
        return Math.max(lHeight,rHeight)+1;

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = s.nextInt();

        TreeNode positive = new CreateMinimalBST().create(arr,0,arr.length-1);

        TreeNode negative = new TreeNode(arr[0]);
        TreeNode temp = negative;
        for(int i=1; i<n; i++) {
            temp.left = new TreeNode(arr[i]);
            temp = temp.left;
        }


        CheckIfBalanced obj = new CheckIfBalanced();
        int result = obj.checkBalanced(negative);
        System.out.println(result != Integer.MIN_VALUE);
    }
}
