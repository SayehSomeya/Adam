/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import java.io.IOException;

/**
 *
 * @author someya
 */
public class AdamActions {

    
 public TerminalCommands commando = new TerminalCommands ();

    
    
    public String depth;

   
    public String count_kmers;

    public String count_contig_kmers;


    public String plugin;

    public String flatten;
    
    
    
    
    public void setDepth(String fileName, String outputFileName) throws IOException, InterruptedException {

        this.depth = commando. setCommandString("depth",fileName,outputFileName,"");
    }

    public void setCount_kmers(String fileName, String outputFileName, String kmers) throws IOException, InterruptedException {
        this.count_kmers = commando. setCommandString("count_kmers",fileName,outputFileName,kmers); 
    }

    public void setCount_contig_kmers(String fileName, String outputFileName,  String kmers) throws IOException, InterruptedException {
        this.count_contig_kmers = commando. setCommandString("count_contig_kmers",fileName,outputFileName,kmers);;
    }

  

    public void setPlugin(String fileName, String outputFileName ,  String kmers) throws IOException, InterruptedException {
        this.plugin = commando. setCommandString("plugin",fileName,outputFileName,kmers); 
    }

    public void setFlatten(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.flatten = commando. setCommandString("flatten",fileName,outputFileName,""); 
    }
    
    
    
     public String getDepth() {
        return depth;
    }

    public String getCount_kmers() {
        return count_kmers;
    }

    public String getCount_contig_kmers() {
        return count_contig_kmers;
    }

    public String getPlugin() {
        return plugin;
    }

    public String getFlatten() {
        return flatten;
    }

    
    

}
