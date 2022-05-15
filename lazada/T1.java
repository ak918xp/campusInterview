import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/1 10:02
 */
public class T1 {
    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
        String inputParam=null;
        BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
        while((inputParam=localReader.readLine())!=null){
            inputParam=inputParam.trim();
            boolean flag=false;
            if(inputParam.charAt(0)=='\"'){
                flag=true;
                inputParam=inputParam.substring(1,inputParam.length()-1);
                inputParam=inputParam.trim();
            }
            String[] inputParams = inputParam.split(" ");
            StringBuilder sb =new StringBuilder();
            for(int i=inputParams.length-1;i>=0;i--){
                if(!"".equals(inputParams[i])){
                    sb.append(inputParams[i]);
                    sb.append(" ");
                }
            }
            String res=sb.toString();
            res=res.trim();
            if(flag){
                System.out.println("\""+res+"\"");
                break;
            }
            else{
                System.out.println(res);
                break;
            }
        }

    }
}
