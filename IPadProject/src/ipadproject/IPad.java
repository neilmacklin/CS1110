/* CLASS:  IPad             used by PROJECT:  IPadProject
 * This OOP class:
 *      - Must include attributes, getters/setters, constructors (needs 2, one
 *          for task 1, and one for task 2), toString method
 *      - the parameterized constructor uses the setters, not the instance 
 *          variables directly
 *      - Setter for cellular ensures that the data is valid.  That is, 
 *              - a small y or n is changes/stored as a Capital Y or N
 *              - any value other than those is set to the default value:  N
 *      - Setter for capacity ensures the data is valid.  That is,
 *              - a negative value is changed to its positive
 *              - if the value is not one of these:  32, 128, 256, (after fixing
 *                      the negative), change it to 32
 *      - toString nicely formats the data like this:
 *              12.9 iPad Pro  (WiFi and cellular) - 128 GB - $1,129
 *              iPad           (WiFi only        ) -  32 GB - $  329
 *          This "should be" a good format string (test it):
 *		String formatStr = "%-15s (WiFi %-12s) - %3d GB - $%,5d";
 *****************************************************************************/
package ipadproject;
import java.util.Scanner;

public class IPad {
     // ***************************************************** INSTANCE VARIABLES

    private String model;
    private boolean cellular;
    private int capacity;
    private int price;
// ************************************************ GETTER & SETTER METHODS

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        if (cellular.compareTo("Y") == 0){
            this.cellular = true;
        }
        else {
            this.cellular = false;
        }
        
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
 //******************************************** CONSTRUCTOR METHOD  
    public IPad(Scanner theFile){
        String record = theFile.nextLine();
        cleanLine(record);
        String[] field = record.split(",");
        setModel(field[0]);
        setCellular((field[1]));
        setCapacity(Integer.parseInt(field[2]));
        setPrice(Integer.parseInt(field[3]));
        
    }
    public IPad(){
        
    }
    
    public String toString() {
//        String theSong = "";
        return String.format("%-14s %-11b %-8d %-7d\r\n\r\n",
                this.model, this.cellular, this.capacity,
                this.price);
    }
    private static String cleanLine(String aLine) {
//        aLine = aLine.replace(" ", "");
        aLine = aLine.replace("-", "");
        
        return aLine;
    } 
    
}
