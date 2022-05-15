import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class check {
    static boolean[] solve(int[][] dependencies, int[][] checks) {
        boolean[] res = new boolean[checks.length];
        if(dependencies == null){
            return res;
        }
        for(int i=0;i< checks.length;i++){
            for(int j = 0;j< dependencies.length;j++){
                if(checks[i]==null){
                    res[i]=true;
                }
                if(Arrays.equals(checks[i], dependencies[j])){
                    res[i]=true;
                    break;
                }
            }
        }
        return res;
    }

//    public static boolean contains(int[] dependency ,int[] check){
//        for(int i=0;i< dependency.length;i++){
//            if(dependency[i]==check[0]){
//                boolean flag = true;
//                for(int j=0;j< check.length;j++){
//                    if(i+j>= dependency.length || dependency[i+j]!=check[j]){
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag==true){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean[] res;

        int dependency_rows = 0;
        int dependency_cols = 0;
        dependency_rows = Integer.parseInt(in.nextLine().trim());
        dependency_cols = 2;

        int[][] dependency = new int[dependency_rows][dependency_cols];
        for(int dependency_i=0; dependency_i<dependency_rows; dependency_i++) {
            for(int dependency_j=0; dependency_j<dependency_cols; dependency_j++) {
                dependency[dependency_i][dependency_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int checks_rows = 0;
        int checks_cols = 0;
        checks_rows = Integer.parseInt(in.nextLine().trim());
        checks_cols = 2;

        int[][] checks = new int[checks_rows][checks_cols];
        for(int checks_i=0; checks_i<checks_rows; checks_i++) {
            for(int checks_j=0; checks_j<checks_cols; checks_j++) {
                checks[checks_i][checks_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = solve(dependency, checks);
        System.out.println(Arrays.toString(res));
    }
}
