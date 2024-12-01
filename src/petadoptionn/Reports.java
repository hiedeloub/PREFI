package petadoptionn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reports {

    public void viewReports() {
        Scanner sc = new Scanner(System.in);
        String response = "yes";
        int action;

       
        do {
            System.out.println("\n-----------------------------------");
            System.out.println("  WELCOME TO PET ADOPTION SYSTEM! ");
            System.out.println("-----------------------------------");
            System.out.println("1. VIEW PET REPORTS");
            System.out.println("2. VIEW FOSTER PARENT REPORT");
            System.out.println("3. VIEW ADOPTION RECORD REPORT");
            System.out.println("4. ALL REPORT");
            System.out.println("5. EXIT REPORT");
           
        System.out.print("Enter action: ");
            
            
          

           
            try {
                action = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid action.");
                sc.nextLine();  
                continue;
            }

          
            if (action < 1 || action > 4) {
                System.out.println("Invalid action! Please enter a valid action.");
                continue;
            }

            
            switch (action) {
                case 1:
                    viewpetReport();                  
                    break;
                case 2:
                    viewfparentReport();
                    break;
                case 3:
                    viewarecordReport();
                    break;
                case 4:
                    viewAllReport();
                    break;
                case 5:
                    System.out.println("Exiting Reports...");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            
            System.out.println("Do you want to continue viewing reports? (yes/no)");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("THANK YOU FOR USING THE REPORTS SYSTEM!");
    }

  
    private void viewpetReport() {
        String qry = "SELECT * FROM tbl_pet";
        String[] hrds = {"ID", "Pet Name", "Pet Species", "Pet Breed", "Pet Status"};
        String[] clm = {"PID", "name", "species", "breed", "status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clm);
    }

    
    private void viewfparentReport() {
        String qry = "SELECT * FROM tbl_fosterparent";
        String[] hrds = {"ID", "First Name", "Last Name", "Address", "Contact"};
        String[] clm = {"FPID", "fname", "lname", "address", "contact"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clm);
    }

   
    private void viewarecordReport() {
        String qry = "SELECT ID, name, fname, lname, breed, species, address, contact, a_date, a_status FROM tbl_adoptionrecord " +
                     "LEFT JOIN tbl_pet ON tbl_pet.PID = tbl_adoptionrecord.PID " +
                     "LEFT JOIN tbl_fosterparent ON tbl_fosterparent.FPID = tbl_adoptionrecord.FPID";
        String[] hrds = {"ID", "Name", "First Name", "Last Name", "Breed", "Species", "Address", "Contact", "Adopted Date", "Adoption Status"};
        String[] clms = {"ID", "name", "fname", "lname", "breed", "species", "address", "contact", "a_date", "a_status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clms);
        
    }
    
    private void viewAllReport() {
    String qry = "SELECT * FROM tbl_pet";
        String[] hrds = {"ID", "Pet Name", "Pet Species", "Pet Breed", "Pet Status"};
        String[] clm = {"PID", "name", "species", "breed", "status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clm);
        
        
        String fpqry = "SELECT * FROM tbl_fosterparent";
        String[] fphrds = {"ID", "First Name", "Last Name", "Address", "Contact"};
        String[] fpclm = {"FPID", "fname", "lname", "address", "contact"};
        conf.viewRecords(fpqry, fphrds, fpclm);
        
        String arqry = "SELECT ID, name, fname, lname, breed, species, address, contact, a_date, a_status FROM tbl_adoptionrecord " +
                     "LEFT JOIN tbl_pet ON tbl_pet.PID = tbl_adoptionrecord.PID " +
                     "LEFT JOIN tbl_fosterparent ON tbl_fosterparent.FPID = tbl_adoptionrecord.FPID";
        String[] arhrds = {"ID", "Name", "First Name", "Last Name", "Breed", "Species", "Address", "Contact", "Adopted Date", "Adoption Status"};
        String[] arclms = {"ID", "name", "fname", "lname", "breed", "species", "address", "contact", "a_date", "a_status"};
       
        conf.viewRecords(arqry, arhrds, arclms);
        
}
}
