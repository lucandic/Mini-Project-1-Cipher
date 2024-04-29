/**
 * Author: Candice Lu
 * Assignment: Mini project 1: CaesarCipher
 * Description: takes a command (encode/decode) and a text, returns the texts encode/decoded by key from 0-25
 * Original due date: January 30th, 2024
 * Redo due date: Mar 10th, 2024
 */

import java.io.PrintWriter;
import java.lang.String;

public class CaesarCipher {

    static int base = (int) 'a';
    // declare base as class variable

    // function to transform an integer into an alphabet
    public static char intToAlpha(char ch, int key) {
        if (((int)ch + key) < base) {
            key += 26;
        }
        return (char) ((((ch + key) % base) % 26)+ base);
    } // intToAlpha(ch, key)

    // function to encode text based on key
    public static void transform(int key, String text, int dir, PrintWriter pen){
        String output = "";
        int newkey = key*dir;
        for (int i = 0; i < text.length(); i++){ 
            output += intToAlpha(text.charAt(i), newkey);
        }
        pen.println("n = "+ key + ": " + new String(output));
    } // transform(key, text, dir, pen)

    public static void main(String[] args) throws Exception{

        // printwriter
        PrintWriter pen = new PrintWriter(System.out, true);

        // check if parameters are valid
        if (args.length != 2){
            System.err.println("Incorrect number of parameters.");
            System.exit(1);
        } 
        /*
        else if (args[1].equals("")){
            System.err.println("Text to be encoded or decoded cannot be empty.");
            System.exit(1);
        }
        */

        // make everything lower case
        String type = args[0].toLowerCase();
        String text = args[1];
        int offsetDirection = 1;

        // check for encode or decode, use for loop to run through keys 0 to 25
        if (type.equals("encode")) {
            offsetDirection = 1;
        } else if (type.equals("decode")){
            offsetDirection = -1;
        } else {
            System.err.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
        }

        // transform text and print result
        for (int n = 0; n < 26; n++){
            CaesarCipher.transform(n, text, offsetDirection, pen);
        }
    }
}
