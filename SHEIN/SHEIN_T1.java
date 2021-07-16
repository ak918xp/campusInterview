public class SHEIN_T1 {
    public static void main(String[] args){
        String str ="a  b    c";
        String res=changespaceto20(str);
        System.out.println(res);
    }
    public static String changespaceto20 (String str) {
        // write code here
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c==' '){
                sb.append("%20");
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
