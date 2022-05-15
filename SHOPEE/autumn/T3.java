package autumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/22 15:55
 */
public class T3 {
    public static void main(String[] args){
        String[] commands = new String[]{"help","version","status"};
        String input = "statsu";
        String res = didYouMean(commands,input);
        System.out.println(res);
    }

    public static String didYouMean(String[] commands, String input) {
        // write code here
        List<Map<Character,Integer>> records = new ArrayList<>();
        List<Map<String,Integer>> ans = new ArrayList<>();
        for(int i=0;i<commands.length;i++){
            String now = commands[i];
            Map<Character,Integer> map = new HashMap<>();
            for(int j=0;j<now.length();j++){
                char c = now.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            records.add(map);
        }
        int totalCount=0;
        String res = "";
        for(int i=0;i< records.size();i++){
            Map<Character,Integer> map = records.get(i);
            int count=0;
            for(int j=0;j<input.length();j++){
                char c = input.charAt(j);
                if(map.containsKey(c)){
                    if(map.get(c)==1){
                        map.remove(c);
                    }
                    else{
                        map.put(c,map.get(c)-1);
                    }
                    count++;
                }
            }
            if(totalCount<count){
                totalCount=count;
                res=commands[i];
            }
        }
        return res;
    }
}
