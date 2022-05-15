import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 19:03
 */
public class T1 {
    static List<String> res;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int v = Integer.parseInt(input.nextLine().trim());
        String s = input.nextLine();
        res = new ArrayList<>();
        detect(v,s);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    public static void detect(int v,String s){
        Map<String,Integer> container = new LinkedHashMap<>();
        int length = s.length();
        char[] currContainer = new char[length];
        String LMark = "L";
        String RMark = "R";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==LMark.charAt(0)){
                container.put(LMark,i);
                currContainer[i]='X';
                LMark+="L";
            }
            else if(s.charAt(i)==RMark.charAt(0)){
                container.put(RMark,i);
                currContainer[i]='X';
                RMark+="R";
            }
            else{
                currContainer[i]='.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<currContainer.length;i++){
            sb.append(currContainer[i]);
        }
        res.add(sb.toString());
        while(container.size()>0){
            Iterator<Map.Entry<String,Integer>> it = container.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String,Integer> entry = it.next();
                String key = entry.getKey();
                if(key.charAt(0)=='L'){
                    int preValue=entry.getValue();
                    if(preValue-v>=0){
                        entry.setValue(preValue-v);
                    }
                    else{
                        it.remove();
                    }
                }
                else if(key.charAt(0)=='R'){
                    int preValue=entry.getValue();
                    if(preValue+v<length){
                        entry.setValue(preValue+v);
                    }
                    else{
                        it.remove();
                    }
                }
            }
            for(int i=0;i<length;i++){
                currContainer[i]='.';
            }
            for(Integer value:container.values()){
                currContainer[value]='X';
            }
            sb = new StringBuilder();
            for(int i=0;i<currContainer.length;i++){
                sb.append(currContainer[i]);
            }
            res.add(sb.toString());
        }
    }
}
