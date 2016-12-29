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
public class AdamArvo {
    
    
    FileFormat type = new FileFormat();

    AdamPrint display = new AdamPrint();
    AdamActions operation = new AdamActions();

    ConversionOperations transformation = new ConversionOperations();

   
    
    
    
        public void selectionNucleotideContigFragment(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException {
         
        
        if (selection.equals("count_contig_kmers")) {

            operation.setCount_contig_kmers(fileName, outputFileName, kmers);
        } else {
            selectionPrint(fileName, outputFileName, selection);
        }
    }

    /*
 *  
 * 
 * 
     */
    public void selectionGenotype(String fileName, String outputFileName, String selection) throws IOException, InterruptedException {
        if (selection.equals("depth")) {
            operation.setDepth(fileName, outputFileName);

        } else if (selection.equals("allelecount")) {
            display.setAllelecount(fileName, outputFileName);

        }  else {
            selectionPrint(fileName, outputFileName, selection);
        }

    }

    /*
 *  
 * 
 * 
     */
    public void selectionFeature(String fileName, String outputFileName, String selection) throws IOException, InterruptedException {

        if (selection.equals("print_genes")) {
            display.setPrint_genes(fileName, outputFileName);
        } else {
            selectionPrint(fileName, outputFileName, selection);
        }

    }

    /*
 *  
 * 
 * 
     */
    public void selectionAlignmentRecord(String fileName, String outputFileName, String selection,String kmers) throws IOException, InterruptedException {

        if (selection.equals("view")) {
            display.setView(fileName, outputFileName);

        } else if (selection.equals("count_kmers")) {
          operation.setCount_kmers(fileName, outputFileName, kmers);

        } else if (selection.equals("flagstat")) {
          display.setFlagstat(fileName, outputFileName);

        } else if (selection.equals("listdict")) {
              display.setListdict(fileName, outputFileName);

        } else {
            selectionPrint(fileName, outputFileName, selection);
        }

    }
    
    
    
    /*
 *  
 * 
 * 
     */
    

    public void selectionPrint(String fileName, String outputFileName, String selection) throws IOException, InterruptedException {

        if (selection.equals("print")) {
            display.setPrint(fileName,outputFileName);
        } else if (selection.equals("flatten")) {
            operation.setFlatten(fileName, outputFileName);

        }

    }
 
    
    
    
    
    
}
