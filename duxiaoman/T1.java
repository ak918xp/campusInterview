import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/26 15:25
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int mark=0;
        while(list.size()>1){
            mark=(mark+a-1)%list.size();
            list.remove(mark);
            if(list.size()>1){
                mark=(mark+b-1)%list.size();
                list.remove(mark);
            }
        }
        int res = list.get(0);
        System.out.println(res);
    }


}
