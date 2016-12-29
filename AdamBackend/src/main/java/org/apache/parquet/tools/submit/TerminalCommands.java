/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author someya
 */
public class TerminalCommands {


    ArrayList<String> commandOutput = new ArrayList<String>();

    public ArrayList<String> setCommand(String adamSubmitCommand, String fileName, String outputFileName, String kmers) throws IOException, InterruptedException {

     String comman = "/home/someya/ADam/adam/bin/adam-submit " + adamSubmitCommand + " " + fileName + " " + outputFileName+" " + kmers;

        //  String comm = "/home/someya/ADam/adam/bin/adam-submit print /home/someya/Desktop/Fragment/toy3.adam  " ;
       
      
        
        String command = comman;
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {

         System.out.print(line + "\n");
          commandOutput.add(line);

        }
  
        proc.waitFor();
        return commandOutput;

    }

    public String setConvert(ArrayList<String> list) {

        String listString = "";

        for (String s : list) {
            listString += s + "\t";
        }

        return listString;
    }

    public String setCommandString(String adamSubmitCommand, String fileName, String outputFileName, String kmers) throws IOException, InterruptedException {

        return setConvert(setCommand(adamSubmitCommand, fileName, outputFileName, kmers));
    }

    
    
    
    
    
    
    public String myArrr(String fileName) throws IOException, InterruptedException {

        ArrayList<String> myArr = new ArrayList<String>();
      //String comman = "/home/someya/ADam/adam/bin/adam-submit " + fileName;

       //String command = comman;

  String command = "java -jar parquet-tools-1.6.0-IBM-7.jar schema  "+fileName +"/part-r-00000.gz.parquet";
  
  // String command = "java -jar parquet-tools-1.6.0-IBM-7.jar schema  /home/someya/NetBeansProjects/AdamBackend/Files/wgEncodeOpenChromDnaseGm19238Pk.trunc10.adam/part-r-00000.gz.parquet";
  
  
  
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {

            String newLine = line + "\n";

            myArr.add(newLine);

        }

        proc.waitFor();

        String output = myArr.get(0).replace("message", "");

        String newOutput = output.replace("{", " ");

        return newOutput;

    }
    
    
    
    
    
    
    
    
    
      public String setReplay(String fileName,String g) throws IOException, InterruptedException {
        
          String newFileName="";
          String pathFileName=fileName+".fasta";
       
   /*      
      if (fileName.endsWith(".fastq")) {
           newFileName= "new"+pathFileName.replace(".fastq", "fasta");
          
      }
      
      
      else if (fileName.endsWith(".fq")) {
           newFileName= "new"+pathFileName.replace(".fq", "fasta");
          
      } 
         */
 //String rattkom= "awk 'BEGIN{P=1}{if(P==1||P==2){gsub(/^[@]/,\">\");print}; if(P==4)P=0; P++}' /home/someya/NetBeansProjects/AdamBackend/Files/fastq_noqual.fq > /home/someya/NetBeansProjects/AdamBackend/Files/fastq_noqual.fasta ";
       //  System.out.print(rattkom);  
       // String comman = "awk 'BEGIN{P=1}{if(P==1||P==2){gsub(/^[@]/,\\\">\\\");print}; if(P==4)P=0; P++}'" +fileName + " > " +g;
   //System.out.print(comman);
       String command = " sed -n '1~4s/^@/>/p;2~4p' /home/someya/NetBeansProjects/AdamBackend/Files/multiline_fastq.fq > /home/someya/NetBeansProjects/AdamBackend/Files/test30000000.fasta ";
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {

            System.out.print(line + "\n");
         
        }

        proc.waitFor();
         
      
    return    newFileName;
    
} 
      
      
       
      
      
      
      
}
