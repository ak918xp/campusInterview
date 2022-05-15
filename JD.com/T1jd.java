import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/12/30 20:27
 */
public class T1jd {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row=input.nextInt();
        int column=input.nextInt();
        char c = '1';
        char[][] nums = new char[row][column];
        int total=row*column;
        for(int i=0,n=column;i<n;n--,i++){
            for(int j=i;j<n;j++){//左往右
                nums[i][j]= c;
                c=(char)(c+1);
            }
            for(int j=i+1;j<n;j++){//上往下
                nums[j][n-1]=c;
                c=(char)(c+1);
            }
            for(int j=n-2;j>=i;j--){//右往左
                nums[n-1][j]=c;
                c=(char)(c+1);
            }
            for(int j=n-2;j>i;j--){//下往上
                nums[j][i]=c;
                c=(char)(c+1);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}
