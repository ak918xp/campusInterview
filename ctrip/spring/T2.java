import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/8 19:11
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] xy = new int[m][2];
        for(int i=0;i<m;i++){
            xy[i][0]=input.nextInt();
            xy[i][1]=input.nextInt();
        }
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i=0;i<=n;i++){
            Set<Integer> set = new HashSet<>();
            sets.add(set);
        }
        for(int i=0;i<m;i++){
            sets.get(xy[i][0]).add(xy[i][1]);
            sets.get(xy[i][1]).add(xy[i][0]);
        }
        List<Set<Integer>> res = new ArrayList<>();
        for(int i =1;i<=n;i++){//队员
            boolean flag1=false;
            for(int j=0;j<res.size();j++){
                Set<Integer> set = res.get(j);
                boolean flag2=false;
                for (int num : set) {
                    if (sets.get(i).contains(num)) {
                        flag2=true;
                        break;
                    }
                }
                if(flag2==false){
                    set.add(i);
                    flag1=true;
                    res.remove(j);
                    res.add(set);
                    break;
                }
            }
            if(flag1==false){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                res.add(set);
            }
        }
        System.out.println(res.size());
    }
}
