package edu.uoc.pac2;

public class EnigmaDecrypter {

    private static String keyWord = "UOC";

    private static String[] rotorConfigurations = {
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
            "AJDKSIRUXBLHWTMCQGZNPYFVOE",
            "BDFHJLCPRTXVZNYEIWGAKMUSQO"
    };

    public static boolean isValidRotor(String decryptedMessage) {
        //TODO
        return decryptedMessage.contains("UOC");
    }

    public static char decryptChar(char encryptedChar, String rotorConfiguration, int rotorPosition) {
        //                                  'T'     "EKMFLGDQVZNTOWYHXUSPAIBRCJ"            1   /   20
        //TODO
        //1.the encryptedChar is in the range A-Z,if it's not, return the originalChar
        if(encryptedChar < 'A' || encryptedChar > 'Z'){
            return encryptedChar;
        }
        //2.find out the index of this encryptedChar in rotorConfiguration
        int index = rotorConfiguration.indexOf(encryptedChar);//11

        //3.move index by rotorPosition, get a new index
        index -= rotorPosition;
        //if the index is negative,keep looking from the end
        while(index < 0){
            index = rotorConfiguration.length() + index;
        }
//        System.out.println(index + "---" + rotorConfiguration.charAt(index));

        //4.find out the character on this new index in A-Z
        //ABCDEFG.....Z
        //0---'A'
        char target = (char)('A' + index);
        System.out.println(target);
        //5.return that character;
        return target;
    }

    public static void main(String[] args) {
        decryptChar('T',"EKMFLGDQVZNTOWYHXUSPAIBRCJ",1);
        decryptChar('T',"EKMFLGDQVZNTOWYHXUSPAIBRCJ",20);
        decryptChar('T',"EKMFLGDQVZNTOWYHXUSPAIBRCJ",46);

        int x = 10;
        x += 2;    //x = x + 2;
        System.out.println(x);

//        System.out.println((char)('A'+0));
//        System.out.println((char)('A'+10));
//        System.out.println((char)('A'+3));

//        System.out.println("hello".indexOf('e'));
    }
    public static String decryptMessage(String encryptedMessage, String rotorConfiguration) {
        //TODO
        // "HELLO"
        // H        EKMFLGDQVZNTOWYHXUSPAIBRCJ          0  -> ?1
        // E        EKMFLGDQVZNTOWYHXUSPAIBRCJ          1  -> ?2
        // L        EKMFLGDQVZNTOWYHXUSPAIBRCJ          2  -> ?3
        // L        EKMFLGDQVZNTOWYHXUSPAIBRCJ          3  -> ?4
        // O        EKMFLGDQVZNTOWYHXUSPAIBRCJ          4  -> ?5
        StringBuffer buffer = new StringBuffer();       //save all the decryptChar 1 by 1
//            String decrypted = "";
        for (int i=0 ; i<encryptedMessage.length() ; i++){
            char encryptedChar = encryptedMessage.charAt(i);
            char decryptedChar = decryptChar(encryptedChar,rotorConfiguration,i);
            buffer.append(decryptedChar);
//            decrypted = decrypted + decryptedChar;
        }
        return buffer.toString();       //get the String saved in the buffer
//        return decrypted;
    }

    public static String turingBruteForce(String encryptedMessage) {
        //TODO
        for (String config:rotorConfigurations) {
            String decrypted = decryptMessage(encryptedMessage,config);
            if (isValidRotor(decrypted)){
                return decrypted;
            }
        }
        return "";
    }

}
