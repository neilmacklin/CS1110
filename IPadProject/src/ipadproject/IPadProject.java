/* PROJECT:  IPadProject
 * AUTHOR:  Lucas Bonek
 * ToDo:  Write an OOP program containing 2 classes (each in a separate .java
 *          file) which does the tasks described in the comments.
 * IMPORTANT NOTE:  These specs say ARRAY.  However, you MAY instead implement
 *      this project with an ARRAY LIST.  You MUST use an array (or array list
 *      of objects - and NOT parallel arrays.
 * INPUT DATA FILE:    iPads.csv
 *      - contains a header record
 *      - data records contain 4 fields (in this order):
 *                  model, cellular, capacity, price
 *      - Some fields contain extra spaces on the left which needs trimming
 * OUTPUT: Console Window
 * MAIN PROCESSING - see below
 *****************************************************************************/
package ipadproject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class IPadProject {
    //********************************************************* MAIN PROCESSING
    // 1.  Call a local method (in this class) to store file's data in an ARRAY
    //        of OBJECTS (which uses the constructor to store data values, and
    //        the constructor in turn uses the setters)
    // 2.  Add this NEW project (hardCoded data in main) as 4 individual fields:
    //                OLD iPad mini 2      N      31      299
    //        (Uses setters to store this data, not the constructor)
    // 3.  Call 4 individual local methods (in this class) to do the following:
    //            (NOTE:  they search array of objects NOT the data file)
    //    a.  Print products priced less than a limit (main sends in 600)
    //            METHOD 1st prints heading line:    PRODUCTS < $600
    //    b.  Print products with capacity 128 or 256 GB (hardCoded in method)
    //            METHOD 1st prints heading line:    PRODUCTS with 128 or 256 GB
    //    c.  Print products with cellular connectivity (main sends in "cellular")
    //            METHOD 1st prints heading line:    PRODUCTS with cellular
    //    d.  Print the most expensive & least expensive products with labels
    //           (as shown in samples below):
    //  Most  expensive:  12.9 iPad Pro   (WiFi and cellular) - 128 GB - $1,129
    //  Least expensive:  OLD iPad mini 2 (WiFi only        ) -  32 GB - $  299
    //*************************************************************************
    static int N = 0;
    public static void main(String[] args) throws IOException {
        final int MAX_N = 100;
        IPad[] ArrayofIPads = new IPad[MAX_N];
        
        storeData(ArrayofIPads);
        
        ArrayofIPads[N] = new IPad();
        
        ArrayofIPads[N].setModel("OLD iPad mini 2");
        ArrayofIPads[N].setCellular("N");
        ArrayofIPads[N].setCapacity(31);
        ArrayofIPads[N].setPrice(299);
        N++;
        
//        for (int i = 0; i < N; i++) {
//            System.out.println(ArrayofIPads[i].toString());
//        }
        int limit = 600;
        String target = "cellular";
        printPrice(ArrayofIPads, limit);
        printCapacity(ArrayofIPads);
        printCellular(ArrayofIPads, target);
        Expensive(ArrayofIPads);
        
        System.out.println("\nTHE END");
    } // END OF main METHOD 
    //************************************************* 5 LOCAL PRIVATE METHODS
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     private static void storeData(IPad[] ArrayofIPads) throws IOException {
        File theFile = new File("iPads.csv");
        Scanner inFile;
        inFile = new Scanner(theFile);
        int i = 0;
        
        
         inFile.nextLine();
         
         while (inFile.hasNext()) {
            ArrayofIPads[i] = new IPad(inFile);
            i++;
        }
        N = i;
     }
     
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //a.  Print products priced less than a limit (main sends in 600)
    //            METHOD 1st prints heading line:    PRODUCTS < $600
     private static void printPrice(IPad[] ArrayofIPads, int limit){
        System.out.println("\nPRODUCTS < $600");
        System.out.printf("%-14s %-11s %-8s %-7s\r\n", "model", "cellular?", "capacity" ,"price" );
        int IpadFromList;
        for (int i = 0; i < N; i++) {
            IpadFromList = ArrayofIPads[i].getPrice();
            if (IpadFromList < limit)
                                                              // calls toString
                System.out.println(ArrayofIPads[i].toString());
        } 
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // b.  Print products with capacity 128 or 256 GB (hardCoded in method)
    //            METHOD 1st prints heading line:    PRODUCTS with 128 or 256 GB
     private static void printCapacity(IPad[] ArrayofIPads){
        System.out.println("\nPRODUCTS with 128 or 256 GB");
        System.out.printf("%-14s %-11s %-8s %-7s\r\n", "model", "cellular?", "capacity" ,"price" );
        int IpadFromList;
        for (int i = 0; i < N; i++) {
            IpadFromList = ArrayofIPads[i].getCapacity();
            if (IpadFromList == 128 || IpadFromList == 256){
                                                              // calls toString
                System.out.println(ArrayofIPads[i].toString());}
        } 
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //c.  Print products with cellular connectivity (main sends in "cellular")
    //            METHOD 1st prints heading line:    PRODUCTS with cellular
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void printCellular(IPad[] ArrayofIPads, String target){
        if (target.compareTo("cellular") == 0){
            System.out.println("\nPRODUCTS with cellular");
            System.out.printf("%-14s %-11s %-8s %-7s\r\n", "model", "cellular?", "capacity" ,"price" );
            boolean IpadFromList;
            for (int i = 0; i < N; i++) {
            IpadFromList = ArrayofIPads[i].isCellular();
            if (IpadFromList == true){
                                                              // calls toString
                System.out.println(ArrayofIPads[i].toString());}
        } 
        }
        else {
             System.out.println("\nPRODUCTS WITHOUT cellular");
            boolean IpadFromList;
            for (int i = 0; i < N; i++) {
            IpadFromList = ArrayofIPads[i].isCellular();
            if (IpadFromList == false){
                                                              // calls toString
                System.out.println(ArrayofIPads[i].toString());}
        } 
        }
        
        }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //d.  Print the most expensive & least expensive products with labels
    //           (as shown in samples below):
    // Most  expensive:  12.9 iPad Pro   (WiFi and cellular) - 128 GB - $1,129
    // Least expensive:  OLD iPad mini 2 (WiFi only        ) -  32 GB - $  299
    private static void Expensive(IPad[] ArrayofIPads) {
//        System.out.println("\nPRODUCTS < $600");
        int IpadFromList;
        int iOfMostExpensive = 0;
        for (int i = 1; i < N; i++) {
            IpadFromList = ArrayofIPads[i].getPrice();
            if (IpadFromList > ArrayofIPads[iOfMostExpensive].getPrice()) {
               iOfMostExpensive = i;
            } 
        }
        if (ArrayofIPads[iOfMostExpensive].isCellular()){
            System.out.printf("Most   expensive: %s (WiFi and cellular) - %d GB - $%,d\r\n",ArrayofIPads[iOfMostExpensive].getModel(), ArrayofIPads[iOfMostExpensive].getCapacity(), ArrayofIPads[iOfMostExpensive].getPrice() );}
        else {
            System.out.printf("Most   expensive: %s (WiFi only        ) - %d GB - $%,d\r\n",ArrayofIPads[iOfMostExpensive].getModel(), ArrayofIPads[iOfMostExpensive].getCapacity(), ArrayofIPads[iOfMostExpensive].getPrice() );
        }
        
        
        int iOfLeastExpensive = 0;
        for (int i = 1; i < N; i++) {
            IpadFromList = ArrayofIPads[i].getPrice();
            if (IpadFromList < ArrayofIPads[iOfLeastExpensive].getPrice()) {
               iOfLeastExpensive = i;
            } 
        }
        if (ArrayofIPads[iOfLeastExpensive].isCellular()){
            System.out.printf("Least  expensive: %s (WiFi and cellular) - %d GB - $%,d\r\n",ArrayofIPads[iOfLeastExpensive].getModel(), ArrayofIPads[iOfLeastExpensive].getCapacity(), ArrayofIPads[iOfLeastExpensive].getPrice() );}
        else {
            System.out.printf("Least  expensive: %s (WiFi only        ) - %d GB - $%,d\r\n",ArrayofIPads[iOfLeastExpensive].getModel(), ArrayofIPads[iOfLeastExpensive].getCapacity(), ArrayofIPads[iOfLeastExpensive].getPrice() );}
        
    
    
    
}
   
    
    
    
} // END OF IPodProject CLASS
