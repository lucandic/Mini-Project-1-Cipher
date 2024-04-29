/**
 * Author: Candice Lu
 * Assignment: Mini project 1: VigenereCipher
 * Description: A cipher that takes a command (encode/decode) and a text, returns the text encode/decoded by the given key
 * Original due date: January 30th, 2024
 * Redo due date: Mar 10th, 2024
 * Second redo due date: April 28th, 2024
 */

import java.io.PrintWriter;

public class VigenereCipher {

    static int base = 'a';

    // encode text based on given key
    public static String code(String command, String text, String key){
        String output = "";
        boolean encode = false;
        if (command.equals("encode")) {
            encode = true;
        }
        for (int i = 0; i < text.length(); i++){
            int keyIndex = i % (key.length());
            if (encode) {
                output += (char) (((int)text.charAt(i) + (int)key.charAt(keyIndex) - 2 * base) % 26 + base);
            } else {
                int newValue = ((int)text.charAt(i) - (int)key.charAt(keyIndex));
                if (newValue < 0) newValue += 26;
                output += (char) (base + newValue);
            }
        }
        return output;
    } // code(command, text, key)

    public static void main(String[] args) throws Exception{
        // printwriter
        PrintWriter pen = new PrintWriter(System.out, true);
        //System.out.println("".isEmpty());

        // check if there are exactly three parameters
        if (args.length != 3){
            System.err.println("Incorrect number of parameters.");
            System.exit(1);
        }

        // if no key given return original thing
        if (args[2].equals("")) {
            pen.println(args[1]);
            System.exit(0);
        }

        args[0] = args[0].toLowerCase();

        String output = "";
        // check if input is encode or decode
        if (args[0].equals("decode") || args[0].equals("encode")){
            output = code(args[0], args[1], args[2]);
        // if neither encode or decode is given give error message
        } else {
            System.err.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
        }
        // print outcome to console
        pen.println(output);
    }
} // class VigenereCipher(args)
