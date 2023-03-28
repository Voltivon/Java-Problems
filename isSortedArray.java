public class Main {
   public static void main(String[] args) {
      int[] myArray = {22, 24, 25};
      
      System.out.print(isSorted(myArray));
   }
   
   public static boolean isSorted(int[] arr){
      int count = 0;
      boolean state = false;
      for(int i = 1; i < arr.length; i++){
         if(arr[count] < arr[i]){
            count++;
            state = true;
         }else {
            state = false;  
         }
         
      }
      return state;
        
   }
   
}
