import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/26 15:32
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] mn = input.nextLine().trim().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[][] channel1 = new String[m][2];
        String[][] channel2 = new String[n][2];
        for(int i=0;i<m;i++){
            channel1[i] = input.nextLine().trim().split("-");
        }
        for(int i=0;i<n;i++){
            channel2[i] = input.nextLine().trim().split("-");
        }
        List<String[]> timeLine = new ArrayList<>();
        for(int i=0;i<m;i++){
            timeLine.add(channel1[i]);
        }
        for(int j=0;j<n;j++){
            timeLine.add(channel2[j]);
        }
        int count = timeLine.size();
        Collections.sort(timeLine, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        while(count>0){
            for(int i=1;i<timeLine.size();i++){
                String[] first = timeLine.get(i-1);
                String[] last = timeLine.get(i);
                if(first[0].compareTo(last[0])<=0 && last[0].compareTo(first[1])<0){
                    if(first[1].compareTo(last[1])>0){
                        timeLine.remove(i-1);
                    }
                    else{
                        timeLine.remove(i);
                    }
                    break;
                }
            }
            count--;
        }
        int max=timeLine.size();
        System.out.println(max);
    }
}
