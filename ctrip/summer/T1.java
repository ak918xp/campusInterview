import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1 {
    public static void main(String[] args){
        String word="preun";
        System.out.println(unwangdulize(word));
    }

    static Map<String,String> first = new HashMap<>();
    static Map<String,String> last = new HashMap<>();
    static {
        first.put("anti","against *");
        first.put("post","after *");
        first.put("pre","before *");
        first.put("re","* again");
        first.put("un","not *");

        last.put("er","one who *s");
        last.put("ing","to actively *");
        last.put("ize","change into *");
        last.put("tion","the process of *ing");
        last.put("ful","full of *");
    }

    public static String unwangdulize(String word){
        List<String> firstList = new ArrayList<>();
        List<String> lastList = new ArrayList<>();
        String res;
        //前缀
        while(word.length()>=4){
            int n=word.length();
            String fs=word.substring(0,4);
            if(first.containsKey(fs)){
                firstList.add(fs);
                word=word.substring(4,n);
            }
            else{
                break;
            }
        }
        while(word.length()>=3){
            int n=word.length();
            String fs=word.substring(0,3);
            if(first.containsKey(fs)){
                firstList.add(fs);
                word=word.substring(3,n);
            }
            else{
                break;
            }
        }
        while(word.length()>=2){
            int n=word.length();
            String fs=word.substring(0,2);
            if(first.containsKey(fs)){
                firstList.add(fs);
                word=word.substring(2,n);
            }
            else{
                break;
            }
        }
        //后缀
        while(word.length()>=4){
            int n=word.length();
            String ls=word.substring(n-4,n);
            if(last.containsKey(ls)){
                lastList.add(ls);
                word=word.substring(0,n-4);
            }
            else{
                break;
            }
        }
        while(word.length()>=3){
            int n=word.length();
            String fs=word.substring(n-3,n);
            if(last.containsKey(fs)){
                lastList.add(fs);
                word=word.substring(0,n-3);
            }
            else{
                break;
            }
        }
        while(word.length()>=2){
            int n=word.length();
            String fs=word.substring(n-2,n);
            if(last.containsKey(fs)){
                lastList.add(fs);
                word=word.substring(0,n-2);
            }
            else{
                break;
            }
        }
        res=word;
        for(int i = lastList.size()-1;i>=0;i--){
            String tmp=last.get(lastList.get(i));
            res=tmp.replace("*",res);
        }

        for(int i = firstList.size()-1;i>=0;i--){
            String tmp=first.get(firstList.get(i));
            res=tmp.replace("*",res);
        }

        return res;
    }
}
