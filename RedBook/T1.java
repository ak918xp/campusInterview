import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 10:08
 */
public class T1 {
    static List<Integer> res ;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine().trim());
        List<List<Integer>> inputParams = new ArrayList<>();
        int black=0,white=0,blank=0;
        for(int i=0;i<n;i++){
            String data = input.nextLine();
            data=data.trim();
            List<Integer> inputParam = readInput(data);
            if(inputParam.get(0)==1){
                white++;
            }
            else if(inputParam.get(0)==2){
                black++;
            }
            else{
                blank++;
                inputParams.add(inputParam);
            }
        }
        res = new ArrayList<>();
        if(Math.abs(black-white)>blank){
            System.out.println(-1);
        }
        else{
            doWork(inputParams,0,0,white,black,blank);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<res.size();i++){
            if(res.get(i)<min){
                min=res.get(i);
            }
        }
        System.out.println(min);
    }

    public static void doWork(List<List<Integer>> inputParams,int step,int count,int white,int black,int none){
        if(step==inputParams.size()){
            if(black==white){
                res.add(count);
            }
        }
        else{
            List<Integer> inputParam = inputParams.get(step);
            if(Math.abs(white-black)<=none){
                doWork(inputParams,step+1,count+inputParam.get(1),white+1,black,none-1);
                doWork(inputParams,step+1,count+inputParam.get(2),white,black+1,none-1);
            }
        }
    }

    public static List<Integer> readInput(String data){
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<data.length();i++){
            char c= data.charAt(i);
            if(i==data.length()-1){
                sb.append(c);
                Integer num = Integer.parseInt(sb.toString());
                res.add(num);
                sb=new StringBuilder();
            }
            else if(c==' '){
                Integer num = Integer.parseInt(sb.toString());
                res.add(num);
                sb=new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }
        return res;
    }
}
