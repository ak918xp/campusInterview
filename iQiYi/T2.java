import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {
    static int windowSize=-1;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParams = input.nextLine();
        List<Integer> list = new ArrayList<>();

        initParams(inputParams,list);
        List<Integer> total = new ArrayList<>();
        calculateTotal(total,list);
        String maxRate = calculateRate(total);
        System.out.println(maxRate);
    }

    public static void initParams(String inputParams, List<Integer> list){
        int length=inputParams.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            char c = inputParams.charAt(i);
            if(c==',' || c==':'){
                Integer num = Integer.parseInt(sb.toString());
                list.add(num);
                sb=new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }
        windowSize = Integer.parseInt(sb.toString());
    }

    public static void calculateTotal(List<Integer> total,List<Integer> list){
        int sum = 0;
        for(int i=0;i<windowSize;i++){
            sum+=list.get(i);
        }
        int first=0,last=windowSize-1;
        while(last<list.size()){
            total.add(sum);
            if(last<list.size()){
                sum-=list.get(first++);
                ++last;
                if(last>=list.size()){
                    break;
                }
                else{
                    sum+=list.get(last);
                }
            }
        }
    }

    private static String calculateRate(List<Integer> total) {
        double maxRate = 0;
        int length = total.size();
        for(int i=1;i<length;i++){
            double num1=total.get(i);
            double num2=total.get(i-1);
            double tmp=num1/num2;
            if(tmp>maxRate){
                maxRate=tmp;
            }
        }
        double increaseRate=maxRate-1;
        java.text.NumberFormat percentFormat = java.text.NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        percentFormat.setMinimumFractionDigits(2);
        return percentFormat.format(increaseRate);
    }

}
