import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/5 16:16
 */
public class T2 {
    public int maxPreRolDuration (int[][] orders) {
        int orderCount= orders.length;
        List<List<Integer>> newOrders = new ArrayList<>();
        int timeCost=0;
        for(int i=0;i<orderCount;i++){
            int[] order = orders[i];
            int a=order[0];
            int b=order[1];
            int c=order[2];
            int x=order[3];
            List<Integer> tmpRes = new ArrayList<>();
            tmpRes.add(a*x);
            tmpRes.add(b*x);
            tmpRes.add(c*x);
            newOrders.add(tmpRes);
        }
        int total=0;
        for(int i=0;i<orderCount;i++){
            List<Integer> thisOrder = newOrders.get(i);
            int nowCost=0;
            for(int j=0;j<3;j++){
                if(thisOrder.get(i)>nowCost){
                    nowCost=thisOrder.get(i);
                }
            }
            total+=nowCost;
        }
        return total;
    }
}
