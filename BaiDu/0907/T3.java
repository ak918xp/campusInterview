import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/7 20:18
 */
public class T3 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputLine1 = input.nextLine();
        String[] nk = inputLine1.split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String s = input.nextLine();
        res = new ArrayList<>();
        subSet(s,k);
        int count=0;
        count=findK(k);
        System.out.println(count);
    }
    static List<List<Character>> res ;
    public static void subSet(String s,int k){
        char[] c=s.toCharArray();
        binSet(c,k);
    }

//    public static void dfs(int start,char[] c,List<Character> list,int k){
//        if(list.size()>k){
//            res.add(new ArrayList<>(list));
//        }
//        for(int i=start;i<c.length;i++){
//            list.add(c[i]);
//            dfs(i+1,c,list,k);
//            list.remove(list.size()-1);
//        }
//    }

    public static void binSet(char[] c,int k){
        for(int i=0;i<(1<<c.length);i++){
            List<Character> sub = new ArrayList<>();
            for(int j=0;j<c.length;j++){
                if((i>>j & 1)==1){
                    sub.add(c[j]);
                }
            }
            if(sub.size()>=k){
                res.add(sub);
            }
        }
    }

    public static int findK(int k){
        int count=0;
        for(int i=0;i<res.size();i++){
            List<Character> s = res.get(i);
            if(s.size()>=k){
                Map<Character,Integer> map = new HashMap<>();
                for(int j=0;j<s.size();j++){
                    map.put(s.get(j),map.getOrDefault(s.get(j),0)+1);
                }
                if( map.size()==k){
                    count++;
                }
            }
        }
        return count;
    }
}
