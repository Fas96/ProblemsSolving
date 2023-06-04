package leetcode.Y2023.book.educative.a3TwoPointers;

public class QDutchNationalFlagProblem {
    public void sort(int[] arr) {
        int low=0;
        int high=arr.length-1;
        for (int i = 0; i <=high; i++) {
            if(arr[i]==0){
                swap(arr,i,low);
                low++;
                i++;
            }else if(arr[i]==1){
                i++;
            }else {
                swap(arr,i,high);
                high--;
            }
        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
