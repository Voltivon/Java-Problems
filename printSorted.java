public class Main {
   public static void main(String[] args) {
      // you may wish to write some code in this main method
      // to test your method.
      printSorted(0, 0, 0);
      printSorted(1, 2, 1);
       printSorted(3, 3, 2);
        printSorted(3, 1, 2);
   }
   
   public static void printSorted(int num1, int num2, int num3){
       
       if(num1 == 0 && num2 == 0 && num3 == 0){
         System.out.printf("0 0 0");  
      }
      
      else if(num1 >= num2 && num1 >= num3){
         if(num2 >= num3){
          System.out.printf("%d %d %d\n", num3, num2, num1);  
         }
         else{
            System.out.printf("%d %d %d\n", num2, num3, num1);  
         }
      }
      
      else if(num2 >= num1 && num2 >= num3 ){
         if(num1 >= num3){
            System.out.printf("%d %d %d", num3, num1, num2);  
         }
         else{
             System.out.printf("%d %d %d", num1, num3, num2);  
      }  
      }
      
      
      
      else if(num3 >= num1 && num3 >= num2){
          if(num1 >= num2){
            System.out.printf("%d %d %d\n", num2, num1, num3);  
          }
          else{
             System.out.printf("%d %d %d\n", num1, num2, num3);
          }
      }
      
     
    
      
   
}
}
