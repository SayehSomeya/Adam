/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
/*
import org.apache.parquet.tools.Main;
import static org.apache.parquet.tools.Main.OPTIONS;
import static org.apache.parquet.tools.Main.mergeOptions;

import org.apache.parquet.tools.command.Command;
import org.apache.parquet.tools.command.Registry;
import org.apache.parquet.tools.command.ShowSchemaCommand;
*/
/**
 *
 * @author someya
 */



public class FileFormat {
    
        public boolean checkfilenamn;

    // public   Main main = new Main();
 //public ShowSchemaCommand show = new   ShowSchemaCommand (); 
        
    public  TerminalCommands terminalCall = new  TerminalCommands();

        
 public boolean checkFileName(String filename,String endsWith){
     
     checkfilenamn = filename.endsWith(endsWith);   
     
     return  checkfilenamn;

 }
 
    
 
 
 
 public String checkAdam(String fileNamn) throws IOException, Exception{
 String filtyp=    terminalCall.myArrr(fileNamn);
   return filtyp;

 } 
     
    
 
    
    
    public void setFile(String fileNamn, ArrayList<String> contentsOfFile) {
        BufferedWriter writer = null;
        try {

            if (getFolder(fileNamn) == true) {

                File logFile = new File(fileNamn);

                writer = new BufferedWriter(new FileWriter(logFile));

                String listString = "";

                for (String s : contentsOfFile) {
                    listString += s + "\t";

                }

                //  System.out.println(i);
                writer.write(listString);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    
    
    
    
    public String getFile(String fileNamn) {
        return fileNamn;
    }
    
    

    public boolean getFolder(String fileNamn) {

        File folder = new File("/home/someya/NetBeansProjects/AdamBackend/Files/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (fileNamn.equals(listOfFiles[i].getName())) {
                //   System.out.println("File ");
                return false;
            }

        }
        return true;
    }
    
    
  
     
    
    
    
    
    
    
    
    public void writeFile(String adamSubmitCommand, String fileName, String outputFileName, String kmers) throws IOException, InterruptedException{
        
 setFile(outputFileName, terminalCall.setCommand(adamSubmitCommand, fileName, "",""));
    }
    
    
    
    
    

public static void main(String[] a) throws Exception {
 FileFormat fileTyp= new FileFormat();
//fileTyp.zipFolder("/home/someya/NetBeansProjects/AdamBackend/Files/igen9", "/home/someya/NetBeansProjects/AdamBackend/Files/igen9.zip");


//fileTyp.zipSam("bqsr1.sam","frt");

  }

   
    
    
 public void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;
    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);
    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }
  private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
    }
  }

  private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" +   fileName, zip);
      }
    }
  }


  
  
  
public String CreateDirectory(String namn){
    
    String folder= namn;

        Path path = Paths.get(folder);
        //if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
  
    
    return folder;
   
  
    
}





public void CopyFiles(String srcDir,String dstDir) throws IOException{
     File source = new File(srcDir);
File dest = new File(dstDir);
     
 if ( source.isFile()) {
               FileUtils.copyFileToDirectory(source, dest);
            } else if (source.isDirectory()) {
                 FileUtils.copyDirectoryToDirectory( source,dest );      
  
    
}   
}


public String zipSam(String FilePath) throws IOException, Exception{
    
String folder=FilePath+".folder";
String rgdict=FilePath+".rgdict";
String seqdict=FilePath+".seqdict";

                 CreateDirectory(folder);
               CopyFiles(FilePath, folder);
               CopyFiles(rgdict, folder);
              CopyFiles(seqdict, folder);
              
              
  String zipFile = folder+".zip";
      zipFolder(folder, zipFile);

      
          
      return folder;
    
}






}