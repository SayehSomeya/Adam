package com.mkyong.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import org.apache.parquet.tools.submit.AdamSubmit;
import org.apache.parquet.tools.submit.FileFormat;

import org.apache.parquet.tools.submit.Test;
import sun.misc.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

@Path("/file")
public class RestFileService {

    AdamSubmit submit = new AdamSubmit();
    FileFormat fileTyp = new FileFormat();

    @POST
    @Path("/uploade")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "/home/someya/NetBeansProjects/AdamBackend/Files/"
                + fileDetail.getFileName();

        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        //return Response.status(200).entity(output).build();
    }

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(
                    uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    
    
    
    
    
    @GET
    @Produces("text/html")
    @Consumes("text/html")
    @Path("/namn/{namn}")
    public String getHtml(@PathParam("namn") String namn) throws URISyntaxException, InterruptedException, Exception {
        String message = "";
        String wrongInformation = "";
        String[] valueOfChoice = namn.split(",");

        String h = "/home/someya/NetBeansProjects/AdamBackend/Files/" + valueOfChoice[2];
        String m = "/home/someya/NetBeansProjects/AdamBackend/Files/" + valueOfChoice[1];

        if (fileTyp.getFolder(valueOfChoice[2]) == true) {

      submit.checkConversion(m, h, valueOfChoice[3], valueOfChoice[4]);
            
      
      message = "true";

        } else if (fileTyp.getFolder(valueOfChoice[2]) == false) {
            message = "The name is already used choose a different name";
        }
 
         return message;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    @GET
    @Path("/getFolder/{namn}")
    @Produces("text/html")
    public Response getFolder(@PathParam("namn") String namn) throws Exception, IOException {

        String[] valueOfChoice = namn.split(",");

        String FilePath = "/home/someya/NetBeansProjects/AdamBackend/Files/" + valueOfChoice[1];
        String fileNamn = "";
        File filepath = new File(FilePath);

        if (filepath.isDirectory()) {

            if (valueOfChoice[0].endsWith(".sam") || (valueOfChoice[0].endsWith(".bam")&&valueOfChoice[3].equals("fragments2reads"))) {

                fileTyp.zipSam(FilePath);
                fileNamn = FilePath + ".folder" + ".zip";

            } else {
                String zipFile = FilePath + ".zip";
                fileNamn = zipFile;
                fileTyp.zipFolder(FilePath, fileNamn);

            }
        }

        File file = new File(fileNamn);

        ResponseBuilder response = Response.ok((Object) file);
        String s = "attachment; filename=" + fileNamn;

        response.header("Content-Disposition", s);
        return response.build();

    }

    
    
    
    
    
    
    
    
    
    
    
    
    @GET
    @Path("/getFolderPrint/{namn}")
    @Produces("text/html")
    public Response getFolderPrint(@PathParam("namn") String namn) throws Exception, IOException {

        String[] valueOfChoice = namn.split(",");

        String FilePath = "/home/someya/NetBeansProjects/AdamBackend/Files/" + valueOfChoice[1] + "Print";
        String fileNamn = "";
        File filepath = new File(FilePath);

        if (filepath.isDirectory()) {

            if (valueOfChoice[2].equals("Print") || valueOfChoice[2].equals("Adamactions")) {

                fileNamn = FilePath + ".zip";
                fileTyp.zipFolder(FilePath, fileNamn);

            }
        }
        File file = new File(fileNamn);

        ResponseBuilder response = Response.ok((Object) file);
        String s = "attachment; filename=" + fileNamn;

        response.header("Content-Disposition", s);
        return response.build();

    }

    
    
    
    
    
    
    
    
    @GET
    @Path("/getFile/{namn}")
    @Produces("text/html")
    public Response getFile(@PathParam("namn") String namn) throws Exception, IOException {

        String[] valueOfChoice = namn.split(",");

        String FilePath = "/home/someya/NetBeansProjects/AdamBackend/Files/" + valueOfChoice[1] + "Print";
        String fileNamn = FilePath;
        File file = new File(fileNamn);

        ResponseBuilder response = Response.ok((Object) file);
        String s = "attachment; filename=" + fileNamn;

        response.header("Content-Disposition", s);
        return response.build();

    }
    
    
    
    
    
    
    

    /*    
    @GET
    @Produces("text/html")
    @Consumes("text/html")
    @Path("/someya")
    public String getHtmll()  {

        return "true";
    }
     */
}
