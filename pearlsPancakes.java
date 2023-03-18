import java.util.Scanner;

public class Pearls {
   // use the following Scanner variable and object to collect any necessary user input
   public static Scanner scnr = new Scanner(System.in);
   
   public static void main(String[] args) {
      // make no changes to the code in this main method
      double totalRegisterAmount =getAllTableOrders();
	   System.out.printf("ticket totals + tax for the entire day: $%.2f\n", totalRegisterAmount);
   }

   
   public static double getAllTableOrders() {
     double totalAmount = 0;

    while(moreTablesToServe() == true) {
        double totalCost = getTableOrder();
        totalAmount += totalCost;
    }

    return totalAmount;
}
   
    public static double getTableOrder(){
      double totalCost = 0;
      int numDiners = getNumberOfDinersAtTable();
      
      while(numDiners > 0){
         double order = getDinersOrder();
         totalCost += order;
         numDiners--;
      }
      
      double tax = totalCost * .08;
      
      
      System.out.println("Table total : " + totalCost);
      System.out.println("Tax amount : " + tax);
      displaySuggestedTipAmounts(totalCost);
      
      return totalCost + tax;
     
      
      
   }
   
   // define your method(s) here below 
   public static double getDinersOrder(){
         double totalCost = 0;
         displayMenu();
         
         while(dinerWantsAnotherItem() == true){
            int choice = getMenuChoice();
            double price = getPriceOfMenuChoice(choice);
           
          totalCost += price;
         }
         
         return totalCost;
   }
   
   public static int getNumberOfDinersAtTable(){
        System.out.print("Enter number of diners at this table : ");
        int input = scnr.nextInt();
        scnr.nextLine();

        return input;
   }


   public static void displayMenu(){
     System.out.println("1) eggs          $3.25");
     System.out.println("2) bacon         $4.00");
     System.out.println("3) pancakes      $2.50");
     System.out.println("4) orange juice  $1.25");
     System.out.println("5) oatmeal       $3.99");
     System.out.println("6) milk          $1.25");
     System.out.println("7) donut         $2.00");
   }
   public static int getMenuChoice(){
        System.out.print("Enter a menu choice : ");
        int num = scnr.nextInt();
        scnr.nextLine();
        
        return num;
   }
   
   
   public static double getPriceOfMenuChoice(int choice){
     if(choice == 1){
        return 3.25;
     }else if(choice == 2){
        return 4.00;
     }else if(choice == 3){
        return 2.50;
     }else if(choice == 4){
        return 1.25;
     }else if(choice == 5){
        return 3.99;
     }else if(choice == 6){
        return 1.25;
     }else if(choice == 7){
        return 2.00;
     }

     return 0;
   }
   public static boolean dinerWantsAnotherItem(){
        System.out.print("Another item ('yes' or 'no')? ");
        String input = scnr.nextLine();
        
        

       
         if(input.equals("no")){
            return false;
         }
         
         return true;

   }
   
   public static boolean moreTablesToServe(){
      System.out.print("Another table ('yes' or 'no')? ");
      String input = scnr.nextLine();

      if(input.equals("yes")){
       return true;
      }

      return false;
   }
   
   public static void displaySuggestedTipAmounts(double input){
       double tenPercent = input * 0.1;
       double fPercent = input * 0.15;
       double twPercent = input * 0.20;
       double twfPercent = input * 0.25;

       System.out.printf("10%% tip: %.2f\n", tenPercent);
       System.out.printf("15%% tip: %.2f\n", fPercent);
       System.out.printf("20%% tip: %.2f\n", twPercent);
       System.out.printf("25%% tip: %.2f\n", twfPercent);
   }
   
}
   
