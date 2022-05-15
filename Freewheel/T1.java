import com.sun.javaws.IconUtil;
import common.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class T1 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        int failId=0;
        int[] timeCost=new int[]{1,3,2,4,5,6,7,8,9};
        int res = GetMinTimeCost(root,failId,timeCost);
        System.out.println(res);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param failId int整型
     * @param timeCost int整型一维数组
     * @return int整型
     */
    static List<List<TreeNode>> level;
    public static int GetMinTimeCost (TreeNode root, int failId, int[] timeCost) {
        if(failId>=timeCost.length){
            return 0;
        }
        findFailRoot(failId,root);
        return sendMessage(failId,timeCost);
    }

    public static void findFailRoot(int failId,TreeNode root){
        if(root==null){
            return ;
        }
        if(failId==root.val){
            levelOrder(root);
        }
        findFailRoot(failId,root.left);
        findFailRoot(failId,root.right);
    }

    public static int sendMessage(int failId,int[] timeCost){
        int levelNo=findLevel(failId);
        int totalLevel=level.size();
        int minCost =timeCost[failId];
        for(int i=levelNo;i<totalLevel-2;i++){
            int levelMinCost =Integer.MAX_VALUE;
            List<TreeNode> thisLevel=level.get(i+1);
            for(int j=0;j<thisLevel.size();j++){
                int no=thisLevel.get(j).val;
                int curCost=timeCost[no];
                if(curCost<levelMinCost){
                    levelMinCost=timeCost[no];
                }
            }
            if(levelMinCost!=Integer.MAX_VALUE){
                minCost+=levelMinCost;
//                System.out.println("minCost: "+minCost);
            }
        }
        return minCost;
    }

    public static int findLevel(int failId){
        for(int i=0;i<level.size();i++){
            List<TreeNode> thisLevel = level.get(i);
            for(int j=0;j<thisLevel.size();j++){
                if(failId==thisLevel.get(j).val){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void levelOrder(TreeNode root){
        level = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size()>0){
            int size=queue.size();
            List<TreeNode> tmp = new LinkedList<>();
            while(size>0){
                TreeNode now = queue.poll();
                tmp.add(now);
                if(now.left!=null){
                    queue.offer(now.left);
                }
                if(now.right!=null){
                    queue.offer(now.right);
                }
                size--;
            }
            level.add(tmp);
        }
    }
}