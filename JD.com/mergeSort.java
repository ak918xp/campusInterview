public class mergeSort {
    //二路归并
    public static void main(String[] args){
        int[] num={10,8,6,4,2,0,1,3,5,7,9};
        mergeSort(num);
        printAns(num);
    }

    public static void printAns(int[] num){
        int length=num.length;
        for(int i=0;i<length;i++){
            System.out.println(num[i]);
        }
    }

    public static void mergeSort(int[] num){
        int[] tmp = new int[num.length];
        sort(num,0,num.length-1,tmp);
    }

    public static void sort(int[] num,int left,int right,int[] tmp){
        if(left<right){
            int mid = (left+right)/2;
            sort(num,left,mid,tmp);
            sort(num,mid+1,right,tmp);
            merge(num,left,mid,right,tmp);
        }
    }

    public static void merge(int[] num,int left,int mid,int right,int[] tmp){
        int i=left,j=mid+1,t=0;
        while(i<=mid && j<=right){
            if(num[i]<=num[j]){
                tmp[t++]=num[i++];
            }
            else{
                tmp[t++]=num[j++];
            }
        }
        while(i<=mid){
            tmp[t++]=num[i++];
        }
        while(j<=right){
            tmp[t++]=num[j++];
        }
        t=0;
        while(left<=right){
            num[left++]=tmp[t++];
        }
    }
}
