package petadoptionn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class adoptionrecord {
    
public static void arrecord() {
        
        
             Scanner sc = new Scanner (System.in);
        String response;
        do{
           
        System.out.println("");    
        System.out.println("||---------------------------||");
        System.out.println("      Adoption Record      ");  
        System.out.println("||---------------------------||");
        System.out.println("");
        System.out.println("1. Add Record");
        System.out.println("2. View Record");
        System.out.println("3. Update Record");
        System.out.println("4. Delete Record");
        System.out.println("5. Exit");
        
        System.out.print("Enter Action: ");
        if (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number between 1 to 5: ");
                sc.nextLine();
               
            }
        int action = sc.nextInt();
        adoptionrecord ar = new adoptionrecord ();
        

        switch(action){
            case 1:
                ar.addadoptionrecord();  
                ar.viewadoptionrecord();
                break;
            case 2:       
                ar.viewadoptionrecord();
                break;
            case 3:
                ar.viewadoptionrecord();
                ar.updateadoptionrecord();
                ar.viewadoptionrecord();
                break;
            case 4:
                ar.viewadoptionrecord();
                ar.deleteadoptionrecord();
                ar.viewadoptionrecord();
                break;
        }
        System.out.println("Do you want to exit? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("no"));
    System.out.println("Okay, Thanks!");
    
    }
    
    public void addadoptionrecord(){
        Scanner sc = new Scanner (System.in);   
        config conf = new config(); 
        
        pet p = new pet();
        p.viewpet();         
        
        System.out.print("Enter the pet ID: ");
        while (!sc.hasNextInt()) {
        System.out.print("Invalid input! enter a valid ID: ");
        sc.next();
        }
        int PID = sc.nextInt();
        sc.nextLine();
        
        String petsql = "SELECT PID FROM tbl_pet WHERE PID = ?";
        while(conf.getSingleValue(petsql, PID) == 0){
            System.out.print("does not exist, Select Again: ");
            PID = sc.nextInt();
            
        }
        
        fosterparent fparent = new fosterparent ();
        fparent.viewfparent();  
        
        System.out.print("Enter the fparent ID:: ");
        while (!sc.hasNextInt()) {
        System.out.print("Invalid input! enter a valid ID: ");
        sc.next();
        }
        int FPID = sc.nextInt();
        sc.nextLine();
        
        String fpsql = "SELECT FPID FROM tbl_fosterparent WHERE FPID = ?";
        while(conf.getSingleValue(fpsql, FPID) == 0){
            System.out.print("does not exist, Select Again: ");
            FPID = sc.nextInt();
        }
        
       
        
        System.out.print("Enter Adoption Date: ");
        String a_date= sc.next();

        System.out.print("Enter Adoption Status: ");
        String a_status = sc.next();
   
        
        String qry = "INSERT INTO tbl_adoptionrecord (PID, FPID, a_date, a_status)"
                + "VALUES (?, ?, ?, ?)";
        conf.addRecord(qry, PID, FPID, a_date, a_status);

   } 
    public void viewadoptionrecord() {
        
        String qry =  "SELECT ID, name, fname, lname, breed, species ,address, contact, a_date, a_status FROM tbl_adoptionrecord\n"
        + "LEFT JOIN tbl_pet ON tbl_pet.PID = tbl_adoptionrecord.PID "
        + "LEFT JOIN tbl_fosterparent ON tbl_fosterparent.FPID = tbl_adoptionrecord.FPID ";
       


        String[] hrds = {"ID", "name",  "fname", "lname", "breed", "species" ,"address", "contact", "a_date", "a_status"};
        String[] clms = {"ID", "name", "fname", "lname", "breed", "species" ,"address", "contact", "a_date", "a_status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clms);
        
        
}
    
    private void updateadoptionrecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Enter the ID to update: ");
        while (!sc.hasNextInt()) {
        System.out.print("Invalid input! enter a valid ID: ");
        sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        
        while(conf.getSingleValue("SELECT ID FROM tbl_adoptionrecord WHERE ID = ?", id) == 0){
        System.out.println("Selected ID doesn't exist!");
        System.out.print("Select Adoption ID Again: ");
        id = sc.nextInt();
        } 
        
        System.out.print("Enter New Adoption Status: ");
        String mstat = sc.next();
        
    
        String qry = "UPDATE tbl_adoptionrecord SET m_status = ? WHERE ID = ?";
        
        
        conf.updateRecord(qry, mstat, id);         
  }
   private void deleteadoptionrecord() {
        Scanner sc = new Scanner (System.in);
        config conf = new config();
        System.out.print("Enter the ID  to delete: ");
        while (!sc.hasNextInt()) {
        System.out.print("Invalid input! enter a valid ID: ");
        sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        
        while(conf.getSingleValue("SELECT ID FROM tbl_adoptionrecord WHERE ID = ?", id) == 0){
        System.out.println("Selected ID doesn't exist!");
        System.out.print("Select Adoption ID Again: ");
        id = sc.nextInt();
        }
        String qry = "DELETE FROM tbl_adoptionrecord WHERE ID = ?";
        
       
        conf.deleteRecord(qry, id);
    }
   
}
