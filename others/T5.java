import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/27 21:15
 */
public class T2 {
    static List<int[]> list;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] nums = new int[m];
        for(int i=0;i<m;i++){
            nums[i]=input.nextInt();
        }
        list = new ArrayList<>();
        int res = choice(nums,nums.length,n);
        System.out.println(res);
    }

    public static int choice(int[] nums,int m,int n){
        Arrays.sort(nums);
        int mark=0;
        int[][] gap = new int[m*(m-1)/2][3];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                gap[mark][0]=nums[j]-nums[i];
                gap[mark][1]=nums[i];
                gap[mark][2]=nums[j];
                mark++;
            }
        }
        Arrays.sort(gap, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        Set<Integer> set = new HashSet<>();
        for(int i=gap.length-1;i>=0;i--){
            if(set.size()<n){
                set.add(gap[i][1]);
                if(set.size()<n){
                    set.add(gap[i][2]);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<res.size()-1;i++){
            ans=Math.min(ans,res.get(i+1)-res.get(i));
        }
        return ans;
    }

}
