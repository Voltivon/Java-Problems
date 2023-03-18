public class Main {
   public static void main(String[] args) {
      // you may wish to write some code in this main method
      // to test your method.
      
      System.out.print(isPalindrome("never odd or even"));
   }
   
   public static boolean isPalindrome(String input){
      
      String backwardString = "";
      
      for(int i = input.length() - 1; i >= 0; i--){
           
            if (Character.isWhitespace(input.charAt(i))) {
            continue;
        }
        backwardString += input.charAt(i);
      }
      input = input.replaceAll("\\s+", "");
      System.out.println(backwardString + "|" + input);
      
      if(!backwardString.equals( input)){
         return false;  
      }
      
      return true;
        
   }
  
   
}
