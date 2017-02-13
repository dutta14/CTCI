package TreesAndGraphs;

/**
 * Created by Anindya on 2/11/2017.
 */
public class TreeNode {
    int value;
    TreeNode left, right;
    TreeNode parent;

    TreeNode(int value) {
        this.value = value;
        left = right = parent = null;
    }

    TreeNode(int value, TreeNode parent) {
        this.value = value;
        left = right = null;
        this.parent = parent;
    }

    void setLeft(TreeNode left) {
        this.left = left;
    }

    void setRight(TreeNode right) {
        this.right = right;
    }

    public String toString() {
        return ("["+value+ "["+left+" "+right+"]"+"]");
    }
}