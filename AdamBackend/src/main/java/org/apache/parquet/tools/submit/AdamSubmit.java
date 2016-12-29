/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import org.apache.parquet.tools.submit.AdamActions;

import org.apache.parquet.tools.submit.*;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author someya
 */
public class AdamSubmit {

    FileFormat type = new FileFormat();

    AdamPrint display = new AdamPrint();
    AdamActions operation = new AdamActions();

    ConversionOperations transformation = new ConversionOperations();

    TerminalCommands commando = new TerminalCommands();
    AdamArvo arvo = new AdamArvo();
      UnzipDemo UnzipDemo= new UnzipDemo();
    /*
 *  den gör allt
 * 
 * 
     */
    public void checkConversion(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException, Exception {

        if (type.checkFileName(fileName, ".adam")) {
            
           
//UnzipDemo.extractFolder(fileName);
     // String newFileName=fileName.replace(".zip", "");
//System.out.println(newFileName);  
        selectionAdam(fileName, outputFileName, selection, kmers);

        } else if (type.checkFileName(fileName, ".bam")) {
            selectionBam(fileName, outputFileName, selection, kmers);

        } else if (type.checkFileName(fileName, ".fq")) {
            selectionFq(fileName, outputFileName, selection, kmers);

        } else {
            setConversion(fileName, outputFileName, selection, kmers);
        }

    }

    /*
 *  
 * 
 * 
     */
    public void setConversion(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException {
        File filepath = new File("Inputfilename");
        String newOutputFileName = outputFileName + "Print";
        if (type.checkFileName(fileName, ".vcf")) {
            transformation.setVcf2adam(fileName, outputFileName);
            arvo.selectionGenotype(outputFileName, newOutputFileName, selection);

        } else if (type.checkFileName(fileName, ".fasta")) {
            transformation.setFasta2adam(fileName, outputFileName);
            arvo.selectionNucleotideContigFragment(outputFileName, newOutputFileName, selection, kmers);

        } else if (type.checkFileName(fileName, ".bed") || (type.checkFileName(fileName, ".gtf")) || (type.checkFileName(fileName, ".narrowPeak")) || (type.checkFileName(fileName, ".txt"))) {
            transformation.setFeatures2adam(fileName, outputFileName);
            arvo.selectionFeature(outputFileName, newOutputFileName, selection);
        } else if (type.checkFileName(fileName, ".sam")) {
            transformation.setTransform(fileName, outputFileName);
            arvo.selectionAlignmentRecord(outputFileName, newOutputFileName, selection, kmers);
        }

    }

    /*
 *  
 * 
 * 
     */
    public void selectionBam(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException, Exception {
        if (selection.equals("adam2fastq")) {
            transformation.setAdam2fastq(fileName, outputFileName);
        } else if (selection.equals("fragments2reads")) {
            transformation.setFragments2reads(fileName, outputFileName);
        } else if (selection.equals("reads2fragments")) {
            transformation.setReads2fragments(fileName, outputFileName);
        } else {
            transformation.setFragments2reads(fileName, outputFileName);
            String newOutputFileName = outputFileName + "Print";
            //setAdam(outputFileName, newOutputFileName, selection, kmers);
            arvo.selectionAlignmentRecord(outputFileName, newOutputFileName, selection, kmers);

        }
    }

    /*
 *  
 * 
 * 
     */
    public boolean setAdam(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException, Exception {
//
        String fileType = type.checkAdam(fileName);
//System.out.print(fileType);
        if (fileType.equals(("org.bdgenomics.formats.avro.NucleotideContigFragment  " + "\n"))) {
            arvo.selectionNucleotideContigFragment(fileName, outputFileName, selection, kmers);
            return true;
        } else if (fileType.equals(("org.bdgenomics.formats.avro.Genotype  " + "\n"))) {
            arvo.selectionGenotype(fileName, outputFileName, selection);
            return true;
        } else if (fileType.equals(("org.bdgenomics.formats.avro.Feature  " + "\n"))) {
            arvo.selectionFeature(fileName, outputFileName, selection);
            return true;
        } else if (fileType.equals(("org.bdgenomics.formats.avro.AlignmentRecord  " + "\n"))) {
            arvo.selectionAlignmentRecord(fileName, outputFileName, selection, kmers);
            return true;
        }

        return false;
    }

    public void selectionAdam(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException, Exception {

        if (selection.equals("adam2fasta")) {
            transformation.setAdam2fasta(fileName, outputFileName);
        } else if (selection.equals("adam2vcf")) {
            transformation.setAdam2vcf(fileName, outputFileName);

        } else {
            setAdam(fileName, outputFileName, selection, kmers);

        }

    }

    public void selectionFq(String fileName, String outputFileName, String selection, String kmers) throws IOException, InterruptedException {
       // String newFileName = commando.setReplay(fileName);
      //  String newOutputFileName = outputFileName + "Print";

       // transformation.setFasta2adam(newFileName, outputFileName);

       // arvo.selectionNucleotideContigFragment(outputFileName, newOutputFileName, selection, kmers);

    }

}
