import sun.security.krb5.internal.tools.Klist;

import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/8 11:36
 */
public class T1_1 {
    public static void main(String[] args) {
        List<int[]> inputParams = new ArrayList<>();
        List<Set<Integer>> inputSets = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        //入参处理
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] inputParam = new int[n];
            Set<Integer> inputSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                inputParam[j] = input.nextInt();
                inputSet.add(inputParam[j]);
            }
            inputParams.add(inputParam);
            inputSets.add(inputSet);
            kList.add(k);
            nList.add(n);
        }
        for(int i=0;i<t;i++){
            int[] num = inputParams.get(i);
            Set<Integer> set = inputSets.get(i);
            int k = kList.get(i);
            int n = nList.get(i);
            int res = action(num,set, k,n);
            System.out.println(res);
        }
    }

    public static int action(int[] num,Set<Integer> set,int k,int n){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            queue.offer(num[i]);
        }
        for(int i=k;i<num.length;i++){
            if(queue.peek()>num[i]){
                queue.poll();
                queue.offer(num[i]);
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }
        int max = res[k-1];
        return max+1;
    }
}
