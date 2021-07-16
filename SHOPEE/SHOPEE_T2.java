import java.util.Scanner;

public class SHOPEE_T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String standard = input.nextLine();
        String target = input.nextLine();
        isMatch(standard,target);
    }
    public static void isMatch(String standard,String target){
        boolean flag=false;
        int length1=standard.length();
        int length2=target.length();
        for(int i=0;i<standard.length();i++){
            if(standard.charAt(i)=='*'){
                flag=true;
            }
        }

        if(flag){
            System.out.println("1");
        }
        else{
            int count=0;
            int mark1=0,mark2=0;
            boolean sout=false;
            while(mark1<length1 && mark2<length2){
                char c1=standard.charAt(mark1);
                char c2=target.charAt(mark2);
                if(c1==c2){
                    mark1++;
                    mark2++;
                }
                else{
                    if(c1=='?'){
                        mark1++;
                        mark2++;
                    }
                    else if(c1=='#' && count==0){
                        count++;
                        mark1++;
                    }
                    else {
                        System.out.println("0");
                        sout=true;
                        break;
                    }
                }
            }
            if(mark1<length1||mark2<length2){
                System.out.println("0");
                sout=true;
            }
            if(!sout){
                System.out.println("1");
            }
        }
    }
}
