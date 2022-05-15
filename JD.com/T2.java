import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/11 19:36
 */
public class T2 {
    static List<int[]> services;//保存依赖关系
    static Map<Integer,Set<Integer>> roots;//保存反依赖
    static int[] machines;//保存机器运行状态
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String nq = input.nextLine();
        nq=nq.trim();
        String[] nqs = nq.split(" ");
        int n = Integer.parseInt(nqs[0]);//n个服务
        int q = Integer.parseInt(nqs[1]);//查询数量

        services = new ArrayList<>();
        roots = new HashMap<>();
        services.add(new int[1]);//初始化一下依赖关系，填补0号机器
        roots.put(0,new HashSet<>());//初始化反依赖关系，填补0号机器

        for(int i=0;i<n;i++){
            String inputParam = input.nextLine();
            inputParam=inputParam.trim();
            String[] inputParams = inputParam.split(" ");

            int size = Integer.parseInt(inputParams[0]);//每个服务的依赖数量
            int[] service = new int[size];//保存当前服务依赖其他服务的编号
            if(size>0){
                for(int j=1;j<inputParams.length;j++){
                    service[j-1]=Integer.parseInt(inputParams[j]);
                }
            }
            services.add(service);//存入依赖大数组
        }
        initRoots();//初始化反依赖关系
        int[][] order = new int[q][2];//命令记录
        for(int i=0;i<q;i++){
            String inputParam = input.nextLine();
            inputParam=inputParam.trim();
            String[] inputParams = inputParam.split(" ");
            order[i][0] = Integer.parseInt(inputParams[0]);//命令为启动或者结束
            order[i][1] = Integer.parseInt(inputParams[1]);//对应的机器
        }
        machines = new int[n+1];//初始化机器状态
        int[] res = new int[q];//结果数组
        for(int i=0;i<q;i++){
            res[i] = operate(order[i]);
        }
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static void initRoots(){
        for(int i=1;i<services.size();i++){
            int[] service = services.get(i);
            Set<Integer> root = new HashSet<>();
            for(int j=0;j<service.length;j++){
                //i代表a号机器，service[j]代表b号机器
                //取得service[j]被以来的关系
                root = roots.getOrDefault(service[j],new HashSet<>());
                root.add(i);
                roots.put(service[j],root);
            }
        }
    }

    public static int operate(int[] order){
        int x = order[0];
        int y = order[1];
        if(x==1){
            start(y);
        }
        else if(x==0){
            end(y);
        }
        return count();
    }

    public static int count(){
        int count=0;
        for(int i=0;i< machines.length;i++){
            if (machines[i]==1){
                count++;
            }
        }
        return count;
    }

    //n表示启动n号机器
    public static void start(int n){
        //启动正在运行的程序，不会造成任何变化
        if(n==0 || machines[n]==1){
            return;
        }
        else{
            //启动这台机器
            machines[n]=1;
            //找到n相关的依赖,启动
            int[] requires = services.get(n);
            for (int require : requires) {
                start(require);
            }
        }
    }

    //终止命令
    public static void end(int n){
        if(n==0 || machines[n]==0){
            return ;
        }
        else{
            //停止这台机器
            machines[n]=0;
            //找到对应的根,关闭
            Set<Integer> root = roots.getOrDefault(n,null);
            if(root!=null){
                for(Integer num:root){
                    end(num);
                }
            }
        }
    }
}
