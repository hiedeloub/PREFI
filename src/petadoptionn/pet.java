package petadoptionn;

import java.util.Scanner;


public class pet {
    
    public static void precord() {
        
        
           Scanner sc = new Scanner(System.in);
           String response;
           do{
        
        System.out.println("");    
        System.out.println("||---------------||");
        System.out.println("      PET      ");  
        System.out.println("||---------------||");
        System.out.println("");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
       
     System.out.print("Enter action: ");
            int action = sc.nextInt();
            pet pet = new pet ();
            switch(action){
               case 1:
                    pet.addpet();
                break;
                
                case 2:
                    pet. viewpet();
                    break;
                    
                case 3:
                    pet. viewpet();
                    pet. updatepet();
                    pet. viewpet();
                    break;
                
                case 4:
                    pet. viewpet();
                    pet. deletepet();
                    pet. viewpet();
                    break;
                    
                case 5:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Invalid actiopn. Please try again.");
                   
           
            }
             System.out.println("Do you want to continue? (yes/no): ");
             response = sc.next();
                    
           }while(response.equalsIgnoreCase("yes"));
           System.out.println("Thank You! ");
    }
      public void addpet(){
        Scanner sc = new Scanner(System.in);
   
        System.out.print("Pet Name: ");
        String name = sc.next();
        System.out.print("Pet Species: ");
        String species = sc.next();
        System.out.print("Pet Breed: ");
        String breed = sc.next();
        System.out.print("Pet Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_pet (name, species, breed, status) VALUES (?, ?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, name, species, breed, status);
              
     }
          
      public void viewpet() {
       
        String qry = "SELECT * FROM tbl_pet";
        String[] hrds = {"ID" ,"Pet Name", "Pet Species", "Pet Breed", "Pet Status"};
        String[] clm = {"PID", "name", "species", "breed", "status"};
        
        config conf = new config();
     
        conf.viewRecords(qry, hrds, clm);
    }
   
    
    private void updatepet(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the id to update: ");
        int PID = sc.nextInt();
       
        System.out.print("Pet Name: ");
        String name = sc.next();
        System.out.print("Pet Species: ");
        String species = sc.next();
        System.out.print("Pet Breed: ");
        String breed = sc.next();
        System.out.print("Pet Status: ");
        String status = sc.next();

        String qry = "UPDATE tbl_pet SET name = ?, species = ?, breed = ?, status = ? WHERE PID = ?";
        
        config conf = new config();
        conf.updateRecord(qry, name, species, breed, status, PID);
        
    }
    
      private void deletepet() {
          Scanner sc = new Scanner(System.in);
          config conf = new config();
          System.out.println("Enter the id to delete");
          int ID = sc.nextInt();
          
         while(conf.getSingleValue("SELECT PID FROM tbl_pet WHERE PID = ?", ID) == 0){
             System.out. print("Selected ID doesn't exist!");
             System.out. print("Select PET ID Again: ");
             ID = sc.nextInt();
}

          
          String qry = "DELETE FROM tbl_pet WHERE PID = ?";        
          conf.deleteRecord(qry,ID);


    }  
}