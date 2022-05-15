import java.util.Scanner;

public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String num = input.next();
        int k =input.nextInt();
        operation(num,k);
    }

    /**
     * 找到那个数
     * @param num
     * @param k
     * @return
     */
    private static void operation(String num, int k) {
        int flag=-1;
        //当那个数1个数等于k的时候返回
        while(flag!=k){
            num = add2(num,"1");
            flag=judge(num);
        }
        System.out.println(num);

    }
    public static int judge(String num){
        int count=0;
        for(int i=0;i<num.length();i++){
            char tmp = num.charAt(i);
            String tmp2 = String.valueOf(tmp);
            if("1".equals(tmp2)){
                count++;
            }
        }
        return count;
    }


//    private static String add(String num1, String num2) {
//        int len1 = num1.length();
//        int len2 = num2.length();
//        String s1 = num1;
//        String s2 = num2;
//        StringBuffer sb1 = new StringBuffer();
//        if(len1>len2){
//            for(int i=0;i<(len1-len2);i++){
//                sb1.append(0);
//            }
//            sb1.append(num2);
//            s1 = num2;
//            s2 = sb1.toString();
//        }
//        else if(len1<len2){
//            for(int j=0;j<(len2-len1);j++){
//                sb1.append(0);
//            }
//            sb1.append(num1);
//            s1 = sb1.toString();
//            s2 = num2;
//        }
//        //进位
//        int flag=0;
//        StringBuffer sb2 = new StringBuffer();
//        for(int k = s1.length()-1;k>=0;k--){
//            if((s1.charAt(k)-48)==0 &&(s2.charAt(k)-48)==0){
//                sb2.append(flag);flag=0;
//                continue;
//            }
//            if( ((s1.charAt(k)-48)==0 &&(s2.charAt(k)-48)==1 && flag==1 ) || ((s1.charAt(k)-48)==1 &&(s2.charAt(k)-48)==0 && flag==1)){
//                sb2.append(0);
//                flag=1;
//                continue;
//            }
//            if(((s1.charAt(k)-48)==0 && (s2.charAt(k)-48)==1 && flag==0) || ((s1.charAt(k)-48)==1 &&(s2.charAt(k)-48)==0 && flag==0)){
//                sb2.append(0);
//                flag=0;
//                continue;
//            }
//            if((s1.charAt(k)-48)==1 &&(s2.charAt(k)-48)==1 && flag==0){
//                sb2.append(0);
//                flag=1;
//                continue;
//            }
//            if( (s1.charAt(k)-48)==1 &&(s2.charAt(k)-48)==1 && flag==1 ){
//                sb2.append(1);
//                flag=1;
//            }
//        }
//        if(flag == 1){
//            sb2.append(flag);
//        }
//        sb2.reverse();
//        return sb2.toString();
//    }

    public static String add2(String a ,String b){
        StringBuilder sb = new StringBuilder();
        int x=0;
        int y = 0;
        int pre=0;
        int sum=0;
        while(a.length()!=b.length()){
            if(a.length()>b.length()){
                b="0"+b;
            }
            else{
                a="0"+a;
            }
        }
        for(int i=a.length()-1;i>=0;i--){
            x=a.charAt(i)-'0';
            y=b.charAt(i)-'0';
            sum=x+y+pre;
            if(sum>=2){
                pre=1;
                sb.append(sum-2);
            }
            else{
                pre = 0;
                sb.append(sum);
            }
        }
        if(pre==1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
