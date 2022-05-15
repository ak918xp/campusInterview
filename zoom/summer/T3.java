import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode (int val){
        this.val=val;
    }
}

public class T3 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        TreeNode head= new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
        
        doWork(head);
    }

    static List<List<Integer>> res = new ArrayList<>();
    public static void doWork(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head=tree;
        queue.offer(head);
        while(queue.size()>0){
            int size=queue.size();
            List<Integer> tmpRes = new ArrayList<>();
            while(size>0){
                TreeNode now = queue.poll();
                size--;
                tmpRes.add(now.val);
                if(now.left!=null){
                    queue.offer(now.left);
                }
                if(now.right!=null){
                    queue.offer(now.right);
                }
            }
            res.add(tmpRes);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<res.size();i++){
            List<Integer> curList = res.get(i);
            if(i%2==0){
                for(int j=0;j<curList.size();j++){
                    ans.add(curList.get(j));
                }
            }
            else{
                for(int j =curList.size()-1;j>=0;j--){
                    ans.add(curList.get(j));
                }
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
