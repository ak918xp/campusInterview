import java.util.*;

class Computer{
    public int no;
    public int cpuCount;
    public int memSize;
    public int cpuArch;
    public int supportNP;
    public Computer(int no,int cpuCount,int memSize,int cpuArch,int supportNP){
        this.no = no;
        this.cpuCount=cpuCount;
        this.memSize=memSize;
        this.cpuArch=cpuArch;
        this.supportNP=supportNP;
    }

    public Computer(){

    }
}

public class T1 {
    static List<Computer> computerList = new LinkedList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //初始化电脑配置
        int m = input.nextInt();
        String[] inputParam = new String[m];
        for(int i=0;i<m;i++){
            inputParam[i] = input.next();
        }
        for(int i=0;i<m;i++){
            convertInput(inputParam[i]);
        }
        //制定标准
        int maxCount=input.nextInt();
        int strategy=input.nextInt();
        int cpuCount_STD=input.nextInt();
        int memSize_STD=input.nextInt();
        int cpuArch_STD=input.nextInt();
        int supportNP_STD=input.nextInt();
        //根据条件筛选
        List<Computer> computerList2 = choose(computerList,cpuCount_STD,memSize_STD,cpuArch_STD,supportNP_STD);
        //根据策略筛选
        if(strategy==1){
            strategy1(computerList2);
        }
        else if(strategy==2){
            strategy2(computerList2);
        }
        //输出
        int count = computerList2.size();
        if(maxCount>count){
            System.out.print(count+" ");
            for(int i=0;i<count;i++){
                System.out.print(computerList2.get(i).no+" ");
            }
        }
        else{
            System.out.print(maxCount+" ");
            for(int i=0;i<maxCount;i++){
                System.out.print(computerList2.get(i).no+" ");
            }
        }
    }

    //读取参数
    public static void convertInput(String str){
        Computer comp = new Computer();
        StringBuilder sb = new StringBuilder();
        int mark=0;
        for(int i=0;i<=str.length();i++){
            if(i==str.length()){
                comp.supportNP=Integer.parseInt(sb.toString());
            }
            else{
                char c = str.charAt(i);
                if(c==','){
                    if(mark==0){
                        comp.no=Integer.parseInt(sb.toString());
                        sb=new StringBuilder();
                        mark++;
                    }
                    else if(mark==1){
                        comp.cpuCount=Integer.parseInt(sb.toString());
                        sb=new StringBuilder();
                        mark++;
                    }
                    else if(mark==2){
                        comp.memSize=Integer.parseInt(sb.toString());
                        sb=new StringBuilder();
                        mark++;
                    }
                    else if(mark==3){
                        comp.cpuArch=Integer.parseInt(sb.toString());
                        sb=new StringBuilder();
                        mark++;
                    }
                    else if(mark==4){
                        comp.supportNP=Integer.parseInt(sb.toString());
                        sb=new StringBuilder();
                        mark++;
                    }
                }
                else{
                    sb.append(c);
                }
            }
        }
        computerList.add(comp);
    }

    //策略1，cpu优先
    public static void strategy1(List<Computer> computerList){
        Collections.sort(computerList, new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
//                if(o1.cpuCount!=o2.cpuCount){
//                    return o1.cpuCount-o2.cpuCount;
//                }
//                else{
//                    if(o1.memSize!=o2.memSize){
//                        return o1.memSize-o2.memSize;
//                    }
//                    else{
//                        return o1.no-o2.no;
//                    }
//                }
                if(o1.cpuCount==o2.cpuCount){
                    if(o1.memSize==o2.memSize){
                        return o1.no-o2.no;
                    }
                    return o1.memSize-o2.memSize;
                }
                return o1.cpuCount-o2.cpuCount;
            }
        });
    }

    //策略2，内存优先
    public static void strategy2(List<Computer> computerList){
        Collections.sort(computerList, new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                if(o1.memSize!=o2.memSize){
                    return o1.memSize-o2.memSize;
                }
                else{
                    if(o1.cpuCount!=o2.cpuCount){
                        return o1.cpuCount-o2.cpuCount;
                    }
                    else{
                        return o1.no-o2.no;
                    }
                }
            }
        });
    }

    //根据条件筛选
    public static List<Computer> choose(List<Computer> computerList,int cpuCount_STD,int memSize_STD,int cpuArch_STD,int supportNP_STD){
        List<Computer> newComputerList = new LinkedList<>();
        for (Computer thisComp : computerList) {
            if (cpuArch_STD == 9 && supportNP_STD == 2) {
                if (thisComp.cpuCount >= cpuCount_STD && thisComp.memSize >= memSize_STD) {
                    newComputerList.add(thisComp);
                }
            }
            //不筛选arch
            else if (cpuArch_STD == 9) {
                if (thisComp.cpuCount >= cpuCount_STD && thisComp.memSize >= memSize_STD && thisComp.supportNP == supportNP_STD) {
                    newComputerList.add(thisComp);
                }
            }
            //不筛选np
            else if (supportNP_STD == 2) {
                if (thisComp.cpuCount >= cpuCount_STD && thisComp.memSize >= memSize_STD && thisComp.cpuArch == cpuArch_STD) {
                    newComputerList.add(thisComp);
                }
            }
            //都筛选
            else {
                if (thisComp.cpuCount >= cpuCount_STD && thisComp.memSize >= memSize_STD && thisComp.cpuArch == cpuArch_STD && thisComp.supportNP == supportNP_STD) {
                    newComputerList.add(thisComp);
                }
            }
        }
        return newComputerList;
    }
}
