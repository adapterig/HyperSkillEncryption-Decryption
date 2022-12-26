package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        parseArgs(args);
    }
    private static void parseArgs(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String inputMode = "";
        String alg = "shift";
        boolean isData = false;
        boolean isIn = false;
        boolean isOut = false;
        boolean isKey = false;
        boolean isMode = false;
        String pathIn = "";
        String pathOut = "";
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
                isMode = true;
                continue;
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
                isKey = true;
                continue;
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
                isData = true;
                continue;
            } else if ("-in".equals(args[i])) {
                isIn = true;
                inputMode = args[i];
                pathIn = args[i + 1];
                continue;
            } else if ("-out".equals(args[i])) {
                isOut = true;
                inputMode = args[i];
                pathOut = args[i + 1];
                continue;
            }
            else if ("-alg".equals(args[i])) {
                alg = args[i + 1];
                continue;
            }
        }
        if (!isData && isIn) {
            data = readFile(pathIn);
        }
        String returnString;
        Encoder encoder;
        if ("shift".equals(alg)){
            encoder = new ShiftEncoder();
        } else {
            encoder = new UnicodeEncoder();
        }
        if ("dec".equals(mode)) {
            returnString = encoder.decode(data, key);
        } else {
            returnString = encoder.encode(data, key);
        }
        if (isOut) {
            writeFile(pathOut, returnString);
        } else {
            System.out.println(returnString);
        }
    }

    private static String readFile(String path) {
        String stringFromFile = "";
        try (Scanner scanner = new Scanner(new File(path))){
            stringFromFile = scanner.nextLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        return stringFromFile;
    }

    private static boolean writeFile(String path, String string) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(string);
        } catch (IOException e) {
            System.out.println("Error");
            return false;
        }
        return true;
    }
}
