/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import java.io.IOException;
import org.apache.parquet.tools.submit.TerminalCommands;

/**
 *
 * @author someya
 */
public class AdamPrint {

    public TerminalCommands commando = new TerminalCommands ();
    public FileFormat fileFormat= new FileFormat();
    
    
    public String print;

    public String print_genes;

    public String flagstat;

    public String print_tags;

    public String listdict;

    public String allelecount;

    public String view;

   

    public void setPrint(String fileName, String outputFileName) throws IOException, InterruptedException {
      fileFormat.writeFile("print",fileName,outputFileName,"");
      //  this.print = commando. setCommandString("print",fileName,"","");
         

    }

    public void setPrint_genes(String fileName, String outputFileName) throws IOException, InterruptedException {
         fileFormat.writeFile("print_genes",fileName,outputFileName,"");
       // this.print_genes = commando. setCommandString("print_genes",fileName,"","");
    }

    public void setFlagstat(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.flagstat = commando. setCommandString("flagstat",fileName,outputFileName,"");
    }

    public void setPrint_tags(String fileName) throws IOException, InterruptedException {
        this.print_tags = commando. setCommandString("print_tags",fileName,"","");
    }

    public void setListdict(String fileName, String outputFileName) throws IOException, InterruptedException {
       // this.listdict = commando. setCommandString("listdict",fileName,"","");
             fileFormat.writeFile("listdict",fileName,outputFileName,"");
    }

    public void setAllelecount(String fileName,String outputFileName) throws IOException, InterruptedException {
        this.allelecount = commando. setCommandString("allelecount",fileName,outputFileName,"");
    }

    public void setView(String fileName, String outputFileName) throws IOException, InterruptedException {
        
  String newOutputFileName=outputFileName +"W"      ;
        
        
        this.view = commando. setCommandString("view",fileName,newOutputFileName,"");
  fileFormat.CreateDirectory(outputFileName)   ; 
  

String rgdict=newOutputFileName+".rgdict";
String seqdict=newOutputFileName+".seqdict";

           fileFormat.     CopyFiles(newOutputFileName, outputFileName);
               fileFormat.  CopyFiles(rgdict, outputFileName);
            fileFormat.    CopyFiles(seqdict, outputFileName);
 
     
        
        
        
    }

    
    
    
    
    
    public String getPrint() {
        return print;
    }

    public String getPrint_genes() {
        return print_genes;
    }

    public String getFlagstat() {
        return flagstat;
    }

    public String getPrint_tags() {
        return print_tags;
    }

    public String getListdict() {
        return listdict;
    }

    public String getAllelecount() {
        return allelecount;
    }

    public String getView() {
        return view;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
