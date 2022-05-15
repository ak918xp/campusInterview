public class test {
    public static void main(String[] args){
        int[] num1 = new int[]{1,2,3};
        int[] num2 = new int[]{1,2};
        boolean flag = contains(num1,num2);
        System.out.println(flag);
    }
    public static boolean contains(int[] dependency ,int[] check){
       for(int i=0;i< dependency.length;i++){
           if(dependency[i]==check[0]){
               boolean flag = true;
               for(int j=0;j< check.length;j++){
                   if(dependency[i+j]!=check[j]){
                       flag=false;
                       break;
                   }
               }
               if(flag==true){
                   return true;
               }
           }
       }
       return false;
    }
}
