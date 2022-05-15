import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/1 17:23
 * 拣货最优路径
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 便利蜂仓库每日为门店提供商品配货服务，商品分布在不同的货位上，拣货员每天要在不同的货位拣刚解开，、n选商品为门店配货， 给出一组货位的分布情况，按给定货位的顺序进行拣货，假定仓库每个货位之间的间隔距离均相等的（包括纵、横、45度角方向），且拣货员分别要从这些货位上进行拣货， 为了尽量减少拣货员的冗余移动，请在给定的货位分布中，输出拣货员拣货的最优移动次数
 *
 *
 *
 * 约束 以D[x,y]表示一个货位的坐标，DP[D1,D2]表示一组货位  P[x,y]表示拣货员的位置，货位数为N，坐标间最小间隔1个距离单位
 *
 * x,y都是整数，且满足 -100 <= x,y <= 100;
 *
 * P ∈ {D},即拣货员的坐标只能是一组货位坐标中的某一个;总是以拣货员的坐标作为起始点
 *
 * 0 < N <= 10, DP[i].length == 2, P.length == 2
 *
 * 不符合规则的输入，输出-1
 *
 * 拣货员没有超能力，不能攀爬不能飞不能跳跃货位
 *
 *
 *
 * 输入描述
 * 第一行：货位坐标，以[x,y]标注二维坐标位置，数据间以分号隔开
 *
 * 第二行：拣货员的位置，上述货位坐标中的某一个，以x,y表述坐标。
 *
 *
 * 以D[x,y]表示一个货位的坐标，DP[D1,D2]表示一组货位，P[x,y]表示拣货员的位置，货位数为N，坐标间最小间隔1个距离单位
 *
 * x,y都是整数，且满足 -100 <= x,y <= 100;
 *
 * P ∈ {D},即拣货员的坐标只能是一组货位坐标中的某一个;总是以拣货员的坐标作为起始点
 *
 * 0 < N <= 10, DP[i].length == 2, P.length == 2
 *
 * 输出描述
 * 拣货员拣货的最优移动次数（数字）。
 *
 * 示例：移动了6次：[3,4] -->[3,3] -->[2,2] -->[1,1] -->[0,0] -->[-1,-1] -->[-2,-1] 。
 */
public class T2 {
    static List<int[]> grid;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String goodsParam = input.nextLine();
        goodsParam=goodsParam.trim();
        String personParam = input.nextLine();
        personParam=personParam.trim();
        String[] goodsParams = goodsParam.split(";");
        int number=goodsParams.length;
        grid = new ArrayList<>();
        for(int i=0;i<number;i++){
            String str = goodsParams[i].substring(1,goodsParams.length-1);
            String[] strPoint = str.split(",");
            int[] point = new int[2];
            point[0]=Integer.parseInt(strPoint[0]);
            point[1]=Integer.parseInt(strPoint[1]);
            grid.add(point);
        }
        int curX,curY;
        String[] personParams = personParam.split(",");
        curX=Integer.parseInt(personParams[0]);
        curY=Integer.parseInt(personParams[1]);
        int count = countStep(grid,curX,curY);
        System.out.println(count);
    }

    public static int countStep(List<int[]> grid,int x,int y){
        int length=grid.size();
        int[][] dp = new int[length][length];
        return -1;
    }

    public static int distance(int[] start,int[] end){
        int res = 0;
        while(tan1Length(start,end)==Integer.MAX_VALUE && start!=end){
            if(end[0]>start[0]){
                start[0]++;
                res++;
            }
            else if(end[0]<start[0]){
                start[0]--;
                res++;
            }
            else{
                if(end[1]>start[1]){
                    start[1]++;
                    res++;
                }
                else if(end[1]<start[1]){
                    start[1]--;
                    res++;
                }
                else{
                    return res;
                }
            }
        }
        return res;
    }

    public static int[] nearest(List<int[]> grid,int x,int y){
        double location2=0;
        int[] res = new int[2];
        int mark=-1;
        for(int i=0;i<grid.size();i++){
            double length2=(grid.get(i)[0]-x)*(grid.get(i)[0]-x)+(grid.get(i)[1]-y)*(grid.get(i)[1]-y);
            if(length2>location2){
                location2=length2;
                res[0]=grid.get(i)[0];
                res[1]=grid.get(i)[1];
                mark=i;
            }
        }
        grid.remove(mark);
        return res;
    }

    public static int tan1Length(int[] start,int[] end){
        if(Math.abs(start[0] - end[0]) > Math.abs(start[1] - end[1])){
            return Integer.MIN_VALUE;
        }
        else if(Math.abs(start[0] - end[0]) < Math.abs(start[1] - end[1])){
            return Integer.MAX_VALUE;
        }
        else{
                return Math.abs(start[0] - end[0]);
        }
    }
}
