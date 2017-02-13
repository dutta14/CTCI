package TreesAndGraphs;

import java.util.Scanner;

/**
 * Created by Anindya on 2/12/2017.
 */
public class ValidateBST {

    private boolean validate(TreeNode t, int min, int max) {
        if(t==null)
            return true;
        if(t.value>=min && t.value<=max) {
            return validate(t.left, min, t.value) && validate(t.right, t.value+1, max);
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = s.nextInt();

        TreeNode t = new CreateMinimalBST().create(arr,0,arr.length-1);
        ValidateBST obj = new ValidateBST();
        boolean result = obj.validate(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);
    }
}
