package me.johanneslosch.javafilehandler;

import java.io.FileWriter;

public class WriteFile {

    /**
     * Writes Properties in a  file
     * @param path      path to file
     * @param filename  filename (without ending)
     * @param ending    file ending without the . (dot)
     * @param content   file content as string
     */
    public static void writer(String path, String filename, String ending, String content){
        if(FileHelper.checkFile(path, filename, ending)){
            try(FileWriter fileWriter = new FileWriter(String.format("%s/%s.%s",path, filename, ending),true)) {
                fileWriter.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File not found");
        }

    }
}
