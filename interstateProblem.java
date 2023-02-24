public class HighwayInfo {
   public static void main(String[] args) {
      // write some code to test your method here below
      printHighwayInfo(90);
      printHighwayInfo(290);
      printHighwayInfo(185);
      
   }
   
   public static void printHighwayInfo(int num){
   if(num >= 100){
       if(num % 2 == 1){
          String numStr = Integer.toString(num);
         System.out.println("The " + num + " is auxiliary, serving the " + numStr.substring(1) + ", going north/south.");
       }else if(num % 2 == 0){
          String numStr = Integer.toString(num);
          
         System.out.println("The " + num + " is auxiliary, serving the " + numStr.substring(1) + ", going east/west.");
       }
    }
   
   else {
      if(num % 2 == 1){
         System.out.println("The " + num + " is primary, going north/south.");
         
       }else if(num % 2 == 0){
         
         System.out.println("The " + num + " is primary, going east/west.");
       }
      }
     
    }
