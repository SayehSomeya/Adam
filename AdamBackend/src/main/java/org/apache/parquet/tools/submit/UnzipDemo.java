/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.parquet.tools.submit;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class UnzipDemo {
    
    
    
    public void extractFolder(String zipFile) throws ZipException, IOException 
{
    System.out.println(zipFile);
    int BUFFER = 2048;
    File file = new File(zipFile);

    ZipFile zip = new ZipFile(file);
    String newPath = zipFile.substring(0, zipFile.length() - 4);

    new File(newPath).mkdir();
    Enumeration zipFileEntries = zip.entries();

    // Process each entry
    while (zipFileEntries.hasMoreElements())
    {
        // grab a zip file entry
        ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
        String currentEntry = entry.getName();
        File destFile = new File(newPath, currentEntry);
        //destFile = new File(newPath, destFile.getName());
        File destinationParent = destFile.getParentFile();

        // create the parent directory structure if needed
        destinationParent.mkdirs();

        if (!entry.isDirectory())
        {
            BufferedInputStream is = new BufferedInputStream(zip
            .getInputStream(entry));
            int currentByte;
            // establish buffer for writing file
            byte data[] = new byte[BUFFER];

            // write the current file to disk
            FileOutputStream fos = new FileOutputStream(destFile);
            BufferedOutputStream dest = new BufferedOutputStream(fos,
            BUFFER);

            // read and write until last byte is encountered
            while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                dest.write(data, 0, currentByte);
            }
            dest.flush();
            dest.close();
            is.close();
        }

        if (currentEntry.endsWith(".zip"))
        {
            // found a zip file, try to open
            extractFolder(destFile.getAbsolutePath());
        }
    }
}
    public static void main(String[] args) throws IOException {
        String zipName = "/home/someya/NetBeansProjects/AdamBackend/Files/wgEncodeOpenChromDnaseGm19238Pk.trunc10.adam.zip";
UnzipDemo UnzipDemo= new UnzipDemo();
UnzipDemo.extractFolder(zipName);
     
    }
}