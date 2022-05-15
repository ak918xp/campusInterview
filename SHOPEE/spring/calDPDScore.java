package spring;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/7 20:03
 */
public class calDPDScore {
    public static void main(String[] args){
        int res = calDPDScore("NNYYYYYNNYYYYYYY");
        System.out.println(res);
    }

    public static int calDPDScore(String dpdInfo) {
        // write code here
        int stackSize=0;
        int record=0;
        int res=0;
        for(int i=0;i<dpdInfo.length();i++){
            char c=dpdInfo.charAt(i);
            if(c=='Y'){
                stackSize++;
            }
            else{
               record=Math.max(record,stackSize);
               stackSize=0;
            }
        }
        record=Math.max(stackSize,record);
        if(record>0 && record<=3){
            res-=10;
        }
        else if(record>3 && record<=7){
            res-=15;
        }
        else if(record>7){
            res-=25;
        }
        stackSize=0;
        return res;
    }
}
