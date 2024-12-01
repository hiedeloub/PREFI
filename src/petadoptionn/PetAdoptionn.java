package petadoptionn;

import java.util.Scanner;

public class PetAdoptionn {

   
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;  
        int action = 0;
        String response = null;

            do {  
            System.out.println("");    
            System.out.println("---------------------------------------");
            System.out.println("      WELCOME TO PET ADOPTION SYSTEM!  ");  
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("----------------------");
            System.out.println("1. PET             ");
            System.out.println("2. FOSTER PARENT   ");
            System.out.println("3. ADOPTION RECORD ");
            System.out.println("4. REPORTS         ");
            System.out.println("5. EXIT            ");
            System.out.println("----------------------");

            System.out.print("Enter Action: ");
            
            if (sc.hasNextInt()) {
                action = sc.nextInt(); 
                sc.nextLine();  

                switch (action) {
                    case 1:
                        pet p = new pet();
                        p.precord();
                        break;

                    case 2:
                        fosterparent fp = new fosterparent();
                        fp.fprecord();
                        break;

                    case 3:
                        adoptionrecord ar = new adoptionrecord();
                        ar.arrecord();
                        break;
                        
                    case 4:
                        Reports r = new Reports();
                        r.viewReports();
                        break;
                        
                    
                    case 5:
                        System.out.println("EXIT NA U? (yes/no): ");
                        String resp = sc.nextLine();  
                        if (resp.equalsIgnoreCase("no")) {
                            exit = true;  
                        }
                        break;

                    default:
                        System.out.println("Invalid action. Please enter a valid action.");
                        break;
                }
            } else {
                System.out.println("Invalid action. Please enter a valid action");
                sc.nextLine();  
            }
            System.out.println("continue? (yes/no)");
            response = sc.nextLine();
            }while(response.equalsIgnoreCase("no"));
            
           System.out.println("OKAY, THANK YOU FOR USING MY SYSTEM!!");
           
    }
}
