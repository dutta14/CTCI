package TreesAndGraphs;

import LinkedLists.SumLists;

import java.util.Scanner;

/**
 * Created by Anindya on 2/12/2017.
 */
public class Successor {

    TreeNode create(int[] arr, int low, int high, TreeNode parent) {
        if(high < low)
            return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(arr[mid],parent);
        root.setLeft(create(arr,low,mid-1,root));
        root.setRight(create(arr,mid+1,high,root));
        return root;
    }

    TreeNode findSuccesor(TreeNode t) {
        if(t==null)
            return null;
        if(t.right != null) {
            return leftmostChild(t.right);
        }
        else {
            TreeNode cur = t,
                    parent = t.parent;
            while(parent!=null && parent.left !=cur) {
                cur = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private TreeNode leftmostChild(TreeNode node) {
        if(node == null)
            return null;
        while(node.left != null)
            node = node.left;
        return node;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = s.nextInt();

        Successor obj = new Successor();
        TreeNode t = obj.create(a,0,a.length-1,null);
        System.out.println(t);

        TreeNode find = t;
        TreeNode successor = obj.findSuccesor(find);
        System.out.println(successor.value);

    }
}
