import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/8 10:01
 */
public class T1 {
    public static void main(String[] args){
        List<int[]> inputParams = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        //入参处理
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=0;i<t;i++){
            int n = input.nextInt();
            int k = input.nextInt();
            int[] inputParam = new int[n];
            for(int j=0;j<n;j++){
                inputParam[j]=input.nextInt();
            }
            inputParams.add(inputParam);
            kList.add(k);
            nList.add(n);
        }

        for(int i=0;i<inputParams.size();i++){
            int[] inputParam = inputParams.get(i);
            int k = kList.get(i);
            int n = nList.get(i);
            int length = inputParam.length;
            ////排序
            quickSort(inputParam,0,length-1);
            //判断
            Set<Integer> set = new HashSet<>();
            for (int value : inputParam) {
                set.add(value);
            }
            //当0个数小于x，则x可以为1
            if(k==0 && inputParam[0]>1){
                System.out.println("YES");
                System.out.println("1");
            }
            //找k个数小于x
            else if(k<length && k>0 && inputParam[k-1]!=inputParam[k] && !set.contains(inputParam[k-1]+1)){
                System.out.println("YES");
                System.out.println(inputParam[k-1]+1);
            }
            else if(k==length && inputParam[k-1]<n){
                System.out.println("YES");
                System.out.println(inputParam[k-1]+1);
            }
            else{
                System.out.println("NO");
            }
        }
    }

    public static void quickSort(int[] num,int left,int right){
        if(left<right){
            int i=left,j=right,x=num[left];
            while(i<j){
                while(i<j && num[j]>x){
                    j--;
                }
                if(i<j){
                    num[i++]=num[j];
                }
                while(i<j && num[i]<x){
                    i++;
                }
                if(i<j){
                    num[j--]=num[i];
                }
            }
            num[i]=x;
            quickSort(num,left,i-1);
            quickSort(num,i+1,right);
        }

    }
}
