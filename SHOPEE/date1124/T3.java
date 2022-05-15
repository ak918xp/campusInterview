import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/30 16:27
 */
public class T3 {
    public static void main(String[] args){
        String str = "Shopee is top 1 E-commerce platform!";
        count(str);
    }

    public static void count(String str){
        int length = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            char c = str.charAt(i);
            if('a'<= c && c<='z'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            else if('A'<c && c<='Z'){
                c+=32;
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
            @Override
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry s : list){
            System.out.print(s.getKey()+"=>"+s.getValue()+" ");
        }
    }
}
