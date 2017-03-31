package com.leycarno.javacourse.java_07_json_files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NativeJavaIO {

    public static void main(String[] args) {

        String filename = "example.txt";
        String input = "Dies ist ein Text, den wir nun in einer Datei speichern und anschließend daraus wieder laden wollen!";

        // write the input string into the file
        WriteExample(filename, input);
        // read the file into the output string
        String output = ReadExample(filename);

        System.out.println(output);
    }

    /** ****************************************************************************************************
     *
     */
    public static void WriteExample(String filename, String input) {
        File file = new File(filename);     // create a new file-handler for the file
        FileWriter writer = null;           // define the FileWriter-variable -> see "finally"-part below
        try {
            file.createNewFile();           // create the file - if the file exists, nothing happened!
            writer = new FileWriter(file);  // create a writer for the file-handler
            writer.write(input);            // write (into memory for now)
            writer.flush();                 // flush the content of the memory into the file (like SAVE the file)
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer !=null){
                try {
                    writer.close();         // always close the stream!
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** ****************************************************************************************************
     *
     * @param filename
     * @return
     */
    public static String ReadExample(String filename) {
        String content = null;              // define an empty string for return value (see end of the method)
        File file = new File(filename);     // create a new file-handler for the file
        FileReader reader = null;           // define the FileWriter-variable -> see "finally"-part below
        try {
            reader = new FileReader(file);  // create a reader for the file-handler
            char[] chars = new char[(int) file.length()];   // we can only read characters - luckily for us, "File" know the size of the file-content
            reader.read(chars);             // read the content of the file - charcater for character
            content = new String(chars);    // set the content-string by create a string from character-array
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null){
                try {
                    reader.close();         // always close the stream!
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

}
