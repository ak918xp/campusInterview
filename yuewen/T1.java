

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/21 20:34
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
    this.val = val;
    }
}

public class T1 {
    public static void main(String[] args){

    }

    public static boolean isSameTree (TreeNode p, TreeNode q) {
        // write code here
        if(p==null && q ==null){
            return true;
        }
        else if(p!=null && q !=null){
            if(p.val==q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
