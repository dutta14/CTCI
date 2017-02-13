package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anindya on 2/12/2017.
 */
public class ListOfDepths {

    void depthlists(TreeNode t, int depth, ArrayList<ArrayList<Integer>> list) {
        if(t==null)
            return;
        ArrayList<Integer> tempList;
        if(list.size() == depth) {
            tempList = new ArrayList<>();
        } else {
            tempList = list.remove(depth);
        }
        tempList.add(t.value);
        list.add(depth,tempList);
        depthlists(t.left,depth+1,list);
        depthlists(t.right,depth+1,list);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = s.nextInt();

        TreeNode t = new CreateMinimalBST().create(arr,0,arr.length-1);
        System.out.println(t);

        ListOfDepths obj = new ListOfDepths();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        obj.depthlists(t,0,list);
        System.out.println(list);
    }
}
