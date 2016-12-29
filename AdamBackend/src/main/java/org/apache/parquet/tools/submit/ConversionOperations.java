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
public class ConversionOperations {

    public TerminalCommands commando = new  TerminalCommands();
 
    public String vcf2adam;

    public String anno2adam;
    public String adam2vcf;
    public String fasta2adam;
    public String adam2fasta;
    public String features2adam;
    public String wigfix2bed;
    public String fragments2reads;
    public String reads2fragments;
    public String transform;
    public String adam2fastq;
    
    
   
    

    public void setVcf2adam(String fileName, String outputFileName) throws IOException, InterruptedException {
            
        this.vcf2adam = commando. setCommandString("vcf2adam",fileName,outputFileName,"");
    }

    public void setAnno2adam(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.anno2adam = commando. setCommandString("anno2adam",fileName,outputFileName,"");
    }

    public void setAdam2vcf(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.adam2vcf = commando. setCommandString("adam2vcf",fileName,outputFileName,"");
    }

    public void setFasta2adam(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.fasta2adam = commando. setCommandString("fasta2adam",fileName,outputFileName,"");
    }


    public void setAdam2fasta(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.adam2fasta = commando. setCommandString("adam2fasta",fileName,outputFileName,"");
    }

 
    public void setFeatures2adam(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.features2adam = commando. setCommandString("features2adam",fileName,outputFileName,"");;
    }

    public void setWigfix2bed(String fileName, String outputFileName) throws InterruptedException, IOException {
        this.wigfix2bed = commando. setCommandString("wigfix2bed",fileName,outputFileName,"");;
    }

    public void setFragments2reads(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.fragments2reads = commando. setCommandString("fragments2reads",fileName,outputFileName,"");;
    }

    public void setReads2fragments(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.reads2fragments = commando. setCommandString("reads2fragments",fileName,outputFileName,"");
    }

    public void setTransform(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.transform = commando. setCommandString("transform ",fileName,outputFileName,"");;
    }

    public void setAdam2fastq(String fileName, String outputFileName) throws IOException, InterruptedException {
        this.adam2fastq = commando. setCommandString("adam2fastq ",fileName,outputFileName,"");;
    }

   
    
    
    public String getVcf2adam() {
        return vcf2adam;
    }

    public String getAnno2adam() {
        return anno2adam;
    }

    public String getAdam2vcf() {
        return adam2vcf;
    }

    public String getFasta2adam() {
        return fasta2adam;
    }

    public String getAdam2fasta() {
        return adam2fasta;
    }

    public String getFeatures2adam() {
        return features2adam;
    }

    public String getWigfix2bed() {
        return wigfix2bed;
    }

    public String getFragments2reads() {
        return fragments2reads;
    }

    public String getReads2fragments() {
        return reads2fragments;
    }

    public String getTransform() {
        return transform;
    }

    public String getAdam2fastq() {
        return adam2fastq;
    }
    
    
    
    
    
    
    
    

}
