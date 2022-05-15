import java.util.ArrayList;
import java.util.List;

public class T3 {
    public static void main(String[] args){
        String[][] str = new String[][]{{"0.1.0","1.0"},{"2.1.13","1.20.0"},{"2.1.0","2.1.0"}};
        int[] res=max_version(str);
        for(int i=0;i<str.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] max_version (String[][] version_list) {
        int length=version_list.length;
        int[] res = new int[length];
        for(int i=0;i<length;i++){
            List<Integer> num1=convert(version_list[i][0]);
            List<Integer> num2=convert(version_list[i][1]);
            if(compare(num1,num2)) {
                res[i]=1;
            }
            else{
                res[i]=2;
            }
        }
        return res;
    }

    public static List<Integer> convert(String str){
        List<Integer> res = new ArrayList<>();
        int length=str.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=length;i++){
            if(i==length || str.charAt(i)=='.'){
                String s = sb.toString();
                Integer num=Integer.valueOf(s);
                res.add(num);
                sb=new StringBuilder();
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return res;
    }

    public static boolean compare(List<Integer> list1,List<Integer> list2){
        int mark1=0,mark2=0;
        while(mark1<list1.size() && mark2<list2.size()){
            if(list1.get(mark1)>list2.get(mark2)){
                return true;
            }
            else if(list1.get(mark1)<list2.get(mark2)){
                return false;
            }
            else{
                mark1++;
                mark2++;
            }
        }
        while(mark1<list1.size()){
            if(list1.get(mark1)>0){
                return true;
            }
            else if(list1.get(mark1)<0){
                return false;
            }
            else{
                mark1++;
            }
        }

        while(mark2<list2.size()){
            if(list2.get(mark2)>0){
                return true;
            }
            else if(list2.get(mark2)<0){
                return false;
            }
            else{
                mark2++;
            }
        }
        return true;
    }
}
