/* PROJECT:  LittlePeopleListOfObj
 * AUTHOR: Neil Macklin-Camel                 DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  Reads data from a file into an ArrayLists of objects.  It then
 *      prettyPrints the data and does several searches (by name and by age).
 * INPUT FILE:  LittlePeopleInfo.csv
 *      each line contains:  name,pic,age,salary
 * OUTPUT:  console window
 ****************************************************************************/
package littlepeoplelistofobj;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class LittlePeopleListOfObj {
    
    public static void main(String[] args) throws IOException {
        // ToDo: STEP 1) declare ArrayList of APerson type objects
        //                  where object is called peopleList
        ArrayList<APerson> peopleList = new ArrayList<>();
        // ToDo:  uncomment the code below once the methods below are finished
        fillListWithData(peopleList);
        prettyPrintData(peopleList);
//        
        search("Bashful", peopleList);
        search("Snow White",peopleList);
//        
        search(80,peopleList);
        search(20,peopleList);
        
        System.out.println("\nTHE END");
    } // END OF main METHOD
    //*************************************************************************
    private static void fillListWithData(ArrayList<APerson> peopleList)     // ToDo:  needs parameter
                                                        throws IOException {
        File f = new File("LittlePeopleInfo.csv");
        Scanner inFile = new Scanner(f);
        String record;
        String[] field = new String[4];
        String name;
        String picture;
        int age;
        double salary;
        
        while (inFile.hasNext()) {
            record = inFile.nextLine();
            field = record.split(",");
            name = field[0];
            picture = field[1];
            age = Integer.parseInt(field[2]);
            salary = Double.parseDouble(field[3]);
            // ToDo:  STEP 2) declare the ArrayList ELEMENT (an APerson type
            //                  object, supplying the constructor with the
            //                  4 fields);
            peopleList.add(new APerson(name, picture, age, salary));
        }
        inFile.close();   
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void prettyPrintData(ArrayList<APerson> peopleList) {    // ToDo:  needs parameter
        System.out.println("THE DATA\n--------");
        // ToDo:  write this method body
        System.out.println("NAME              PICTURE     AGE  SALARY");
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.printf("%-10s %10s %10d %10.2f\n", peopleList.get(i).getName(), 
                    peopleList.get(i).getPicture(), peopleList.get(i).getAge(), 
                    peopleList.get(i).getSalary());
        }
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - SEARCH METHOD
    // The OVERLOADED search method
    //      - finds the target (name or age)
    //      - then prettyPrints that person's data (for SUCCESSFUL searches)
    //          OR prints "SORRY, NOT IN LIST" (for UNSUCCESSFUL searches)
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - OVERLOADED for name
    private static void search(String targetName, ArrayList<APerson> peopleList) {
        System.out.println("\nSEARCHING FOR " + targetName);
//        ToDo:  write this method body & uncomment rest of method code
        //System.out.println("Search by name");
        APerson oneName;
        String name;

        for (int i = 0; i < peopleList.size(); i++) {
            oneName = peopleList.get(i);
            name = oneName.getName();
            if (name.compareTo(targetName) == 0) {
                System.out.println("NAME              PICTURE     AGE  SALARY");
                System.out.printf("%-10s %10s %10d %10.2f\n", peopleList.get(i).getName(), 
                    peopleList.get(i).getPicture(), peopleList.get(i).getAge(), 
                    peopleList.get(i).getSalary());
                return;                        
            }
        }
        System.out.printf("SORRY, NOT IN LIST\n");
    }
    //- - - - - - - - - - - - - - - - - - - - - - - - - - -  OVERLOADED for age
    private static void search(int targetAge, ArrayList<APerson> peopleList) {
        APerson oneAge;
        int age;
        System.out.println("\nSEARCHING FOR AGE " + targetAge);
        for (int i = 0; i < peopleList.size(); i++) {
            oneAge = peopleList.get(i);
            age = oneAge.getAge();
            if (age == (targetAge)) {
                System.out.println("NAME              PICTURE     AGE  SALARY");
                System.out.printf("%-10s %10s %10d %10.2f\n", peopleList.get(i).getName(), 
                    peopleList.get(i).getPicture(), peopleList.get(i).getAge(), 
                    peopleList.get(i).getSalary());
                return;                        
            }
        }
        System.out.printf("SORRY, NOT IN LIST\n");
    }
}
