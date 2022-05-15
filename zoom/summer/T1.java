import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        str=str.trim();
        if(str.length()==0){
            System.out.println();
        }
        int length=str.length();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<length;i++){
            char now = str.charAt(i);
            map.put(now, map.getOrDefault(now,0)+1);
        }
        StringBuilder res=new StringBuilder();
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            StringBuilder tmp = new StringBuilder();
            tmp.append(entry.getKey());
            tmp.append("_");
            String num = String.valueOf(entry.getValue());
            tmp.append(num);
            tmp.append("_");
            res.append(tmp);
        }
        String ans = res.substring(0,res.length()-1);
        System.out.println(ans);
    }
}
