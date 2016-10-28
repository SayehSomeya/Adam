  /*
             filedrag.js - HTML5 File Drag & Drop demonstration
             Featured on SitePoint.com
             Developed by Craig Buckler (@craigbuckler) of OptimalWorks.net
             */
            
     var x = "";        
            
     $(document).ready(function () {     
       

                // getElementById
                function $id(id) {
                     
                    return document.getElementById(id);
   

                }


                // output information
                function Output(msg) {
                    var m = $id("messages");
                    m.innerHTML = msg + m.innerHTML;
                   
              
        
                }


                // file drag hover
                function FileDragHover(e) {
                    e.stopPropagation();
                    e.preventDefault();
                    e.target.className = (e.type == "dragover" ? "hover" : "");

                }


                // file selection
                function FileSelectHandler(e) {
                    // 


                    // cancfilesel event and hover styling
                    FileDragHover(e);
  
                    // fetch FileList object
                    var files = e.target.files || e.dataTransfer.files;

                    // process all File objects
                    f = files[0];

                    for (var i = 0, f; f = files[ i]; i++) {


                        ParseFile(f);
                        
                    }

   


                }


              // output file information
                function ParseFile(file) {

                    Output(
                            "<p>File information: <strong>" + file.name +
                            "</strong> type: <strong>" + file.type +
                            "</strong> size: <strong>" + file.size +
                            "</strong> bytes</p>"
                            );
 
                     if((file.name.match('.adam$'))||(file.name.match('.bam$') ) ) {
                   document.getElementById("demo").innerHTML = file.name;
                    
                       document.getElementById('tlm').style.display = "block";
                    
                       x = file.name;
                       Initm(x);
                       
                 
         
           }
         
           else {
                alert("Please upload only .bam or .adam extention folder");
    
           }
           
                }

 
   
 
 
                function Output(msg) {
                    var m = $id("messages");
                    m.innerHTML = msg + m.innerHTML;
                }


                // initialize
                function Init() {

                    var fileselect = $id("fileselect"),
                            filedrag = $id("filedrag"),
                            submitbutton = $id("submitbutton");

                    // file select
                    fileselect.addEventListener("change", FileSelectHandler, false);

                    // is XHR2 available?
                    var xhr = new XMLHttpRequest();
                    
                    if (xhr.upload) {

                        // file drop
                        
                        filedrag.addEventListener("dragover", FileDragHover, false);
                        filedrag.addEventListener("dragleave", FileDragHover, false);
                        filedrag.addEventListener("drop", FileSelectHandler, false);
                        filedrag.style.display = "block";
 
                        // remove submit button
                        submitbutton.style.display = "none";

                    }

                }

 /*
  $("#tlm").click(function () {
             //  alert("Please upload only .bam or .adam extention folder");
    
         
       $("#accordion").show();
           $("#opada").show();
            $("#opto").show();

     //  var x = document.getElementById("demo").name;
       alert(x);
  if (x.match('bam$'))
        {

             

            $("#ett").show().text('Transform');
            $('#infett').attr('data-original-title', 'Convert SAM/BAM to ADAM format and optionally perform read pre-processing transformations').show();


            $("#tva").hide();
            $('#inftva').hide();

            $("#tre").show();
            $('#infpri').attr('data-original-title', 'Print an ADAM formatted file').show();


            $("#fyra").show();
            $('#inffla').attr('data-original-title', 'Convert a ADAM format file to a version with a flattened schema, suitable for querying with tools like Impala').show();


            $("#fem").show().text('View');
            $('#infsju').attr('data-original-title', 'View certain reads from an alignment-record file').show();

            $("#sex").show().text('Print_tags');
            $('#infatt').attr('data-original-title', 'Prints the values and counts of all tags in a set of records').show();

            $("#sju").show().text('Flagstat');
            $('#inffem').attr('data-original-title', 'Print statistics on reads in an ADAM file (similar to samtools flagstat)').show();


            $("#otta").show().text('Listdict');
            $('#infsex').attr('data-original-title', 'Print the contents of an ADAM sequence dictionary').show();




        } 
         
    });   */
         
         
          
          $("#tlm").click(function () {
              
          alert(x)    ;
          }); 
      
                // call initialization file
                if (window.File && window.FileList && window.FileReader) {
                    Init();
                }


            })();
            
            
            
            
            
 
