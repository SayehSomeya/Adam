 var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function(){
  if(xmlhttp.status==200 && xmlhttp.readyState==4){   
      //var words = xmlhttp.responseText.split('');
    //  document.write(text[0]);
              var lines =  xmlhttp.responseText.split('\n');
       
    for(var line = 0; line < lines.length; line++){
      
                document.write(lines[line]+'<br>');
    }
 
      
 
  }
}
var openFile = function() {
     document.write('<a href="http://localhost:8383/HTML5Application3/Test/Adam.html">Back</a> <br><br><br>');
  
   xmlhttp.open("GET","artificial.README.txt",true);
xmlhttp.send();
}