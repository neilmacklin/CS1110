/* PROGRAM:  Recursions
 * DESCRIPTION:  This program writes out the word, char by char, both forward
 *      and backwards.  It uses recursive algorithms for both.
 * HELP:    - charAt(0) gets the FIRST CHAR of a String
 *          - substring(1,theString.length()) gets the REST of the String
 *                  (as a String)
 ******************************************************************************/
package recursion;
public class Recursion {
    public static void main(String[] args) {
        String word = "MICHIGAN";
        writeWord(word);
        System.out.println("\n-----------"); 
        writeWordBackwards(word);
        System.out.println("-----------"); 
    }
    //-------------------------------------------------------------------------
    private static void writeWord(String word) {
        if (word.length() == 0) {
            return;
        }
       System.out.println(word.charAt(0));
       writeWord(word.substring(1,word.length())); 
    }
    //-------------------------------------------------------------------------
    private static void writeWordBackwards(String word) {
        writeWordBackwardsCore(word);
        System.out.println();
        
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void writeWordBackwardsCore(String word) {
        if (word.length() == 0) {
            return;
        }
       writeWordBackwardsCore(word.substring(1,word.length()));
       System.out.println(word.charAt(0));
    }
    //-------------------------------------------------------------------------
}
