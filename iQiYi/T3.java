import java.util.*;

public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParams = input.nextLine();
        List<Integer> list = new ArrayList<>();
        int[] rain = initParams(inputParams,list);
        int[] res = pool(rain);
//        for (int re : res) {
//            System.out.print(re+",");
//        }
        System.out.println(Arrays.toString(res));
    }

    public static int[] initParams(String inputParams, List<Integer> list){
        inputParams=inputParams.substring(1,inputParams.length()-1);
        int length=inputParams.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=length;i++){
            if(i==length){
                list.add(Integer.parseInt(sb.toString()));
            }
            else{
                char c = inputParams.charAt(i);
                if(c==','){
                    Integer num = Integer.parseInt(sb.toString());
                    list.add(num);
                    sb=new StringBuilder();
                }
                else{
                    sb.append(c);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;

    }

    public static int[] pool(int[] rain){
        int length = rain.length;
        int[] release = new int[length];
        Set<Integer> pool = new HashSet<>();
        for(int i=0;i<length;i++){
            //下雨
            if(rain[i]!=0){
                if(pool.contains(rain[i])){
                    int[] empty = new int[0];
                    return empty;
                }else{
                    pool.add(rain[i]);
                    release[i]=-1;
                }
            }
            //天晴
            else{
                if(i==length-1){
                    pool.remove(rain[0]);
                    release[i]=rain[0];
                }
                for(int j=i+1;j<length;j++){
                    if(pool.contains(rain[j])){
                        pool.remove(rain[j]);
                        release[i]=rain[j];
                        break;
                    }
                    else{
                        release[i]=1;
                    }
                }
            }
        }
        return release;
    }
}
