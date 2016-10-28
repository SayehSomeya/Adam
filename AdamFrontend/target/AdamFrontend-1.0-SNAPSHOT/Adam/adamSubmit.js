/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





$(document).ready(function () {


    $(".image-preview-upload").click(function () {
        //  $("#image-preview").animate({bottom: '100px'});

        //  $("#image-preview").animate({  opacity: '0.5'});

        $("#accordion").show();
        $("#fil").show();
        var x = document.getElementById("myImage").value;

        if (x.match('.sam$') || (x.match('.bam$')))
        {




            if (x.match('.sam$')) {

                $("#opada").hide();
                $("#opto").hide();


                $("#ett").show().text('Transform');
                $('#infett').attr('data-original-title', 'Convert SAM/BAM to ADAM format and optionally perform read pre-processing transformations').show();


                $("#tva").hide();
                $('#inftva').hide();

            } else if (x.match('.bam$')) {

                $("#accordion").show();
                $("#opada").show();
                $("#opto").show();


                $('.radio-inline').change(function () {

                    var selected_radio_value = $("input[name=optradio]:checked").val();

                    if (selected_radio_value === 'first')
                    {

                        $("#ett").show().text('Fragments2reads');
                        $('#infett').attr('data-original-title', 'Convert alignment records into fragment records').show();


                        $("#tva").show().text('Reads2fragments');
                        $('#inftva').attr('data-original-title', 'Convert alignment records into fragment records').show();

                    }
                    if (selected_radio_value === 'second')
                    {

                        $("#ett").show().text('Adam2fastq');
                        $('#infett').attr('data-original-title', 'Convert BAM to FASTQ files').show();


                        $("#tva").hide();
                        $('#inftva').hide();

                    }


                });       /*
                 
                 if (document.getElementById('opada').checked) {
                 $("#ett").show().text('Fragments2reads');
                 $('#infett').attr('data-original-title', 'Convert alignment records into fragment records').show();
                 
                 
                 $("#tva").show().text('Reads2fragments');
                 $('#inftva').attr('data-original-title', 'Convert alignment records into fragment records').show();
                 
                 
                 } else if (document.getElementById('opto').checked) {
                 
                 
                 $("#ett").show().text('Adam2fastq');
                 $('#infett').attr('data-original-title', 'Convert BAM to FASTQ files').show();
                 
                 
                 $("#tva").hide();
                 $('#inftva').hide();
                 
                 }
                 */


            }


            $("#tre").show();
            $('#infpri').attr('data-original-title', 'Print an ADAM formatted file').show();


            $("#fyra").show();
            $('#inffla').attr('data-original-title', 'Convert a ADAM format file to a version with a flattened schema, suitable for querying with tools like Impala').show();


            $("#fem").show().text('View');
            $('#infsju').attr('data-original-title', 'View certain reads from an alignment-record file').show();


            $("#sex").show().text('Count_Kmers');
            $('#infatt').attr('data-original-title', 'Prints the values and counts of all tags in a set of records').show();

            $("#sju").show().text('Listdict');
            $('#inffem').attr('data-original-title', 'Print the contents of an ADAM sequence dictionary').show();


            $("#otta").hide();
            $('#infsex').hide();


            $("#X").show().text('Flagstat');
            $('#infX').attr('data-original-title', 'Print statistics on reads in an ADAM file (similar to samtools flagstat)').show();










        } else if (x.match('.vcf$'))

        {


            $("#opada").hide();
            $("#opto").hide();

            $("#ett").show().text('Vcf2adam');
            $('#infett').attr('data-original-title', 'Convert a VCF file to the corresponding ADAM format').show();

            $("#tva").hide();
            $('#inftva').hide();

            $("#tre").show();
            $('#infpri').attr('data-original-title', 'Print an ADAM formatted file').show();

            $("#fyra").hide();
            $('#inffla').hide();

            $("#fem").hide();
            $('#infsju').hide();

            $("#sex").hide();
            $('#infatt').hide();


            $("#sju").show().text('Depth');
            $('#inffem').attr('data-original-title', 'Calculate the depth from a given ADAM file, at each variant in a VCF').show();

            $("#otta").show().text('Allelecount');
            $('#infsex').attr('data-original-title', 'Calculate Allele frequencies').show();


            $("#X").hide();
            $('#infX').hide();



        } else if (x.match('.fasta$') || x.match('.fastq$') || x.match('.fq$'))
        {

            $("#opada").hide();
            $("#opto").hide();

            $("#ett").show().text('Fasta2adam');
            $('#infett').attr('data-original-title', 'Converts a text FASTA sequence file into an ADAMNucleotideContig Parquet file which represents assembled sequences.').show();

            $("#tva").hide();
            $('#inftva').hide();

            $("#tre").show();
            $('#infpri').attr('data-original-title', 'Print an ADAM formatted file').show();

            $("#fyra").show();
            $('#inffla').attr('data-original-title', 'Convert a ADAM format file to a version with a flattened schema, suitable for querying with tools like Impala').show();


            $("#fem").hide();
            $('#infsju').hide();

            $("#sex").show().text('Count_Contig_Kmers');
            $('#infatt').attr('data-original-title', 'Counts the k-mers/q-mers from a read dataset.').show();


            $("#sju").hide();
            $('#inffem').hide();

            $("#otta").hide();
            $('#infsex').hide();

            $("#X").hide();
            $('#infX').hide();


        } else if ((x.match('.bed$')) || (x.match('.gtf$')) || (x.match('.narrowPeak$'))) {

            $("#opada").hide();
            $("#opto").hide();

            $("#ett").show().text('Features2adam');
            $('#infett').attr('data-original-title', 'Convert a file with sequence features into corresponding ADAM format').show();

            $("#tva").hide();
            $('#inftva').hide();

            $("#tre").show();
            $('#infpri').attr('data-original-title', 'Print an ADAM formatted file').show();

            $("#fyra").show();
            $('#inffla').attr('data-original-title', 'Convert a ADAM format file to a version with a flattened schema, suitable for querying with tools like Impala').show();


            $("#fem").hide();
            $('#infsju').hide();

            $("#sex").hide();
            $('#infatt').hide();


            $("#sju").show().text('Print_genes');
            $('#inffem').attr('data-original-title', 'Load a GTF file containing gene annotations and print the corresponding gene models').show();

            $("#otta").hide();
            $('#infsex').hide();

            $("#X").hide();
            $('#infX').hide();


        }
    });
});



$(document).on('click', '#X', function () {

    $(".form-horizontal").hide();
    $("#actfileX").show();
});


$(document).on('click', '#ett', function () {

    $(".form-horizontal").hide();
    $("#confil1").show();
});



$(document).on('click', '#tva', function () {


    $(".form-horizontal").hide();
    $("#confil2").show();

});


$(document).on('click', '#tre', function () {
    $(".form-horizontal").hide();
    $("#prifile1").show();


});

$(document).on('click', '#fyra', function () {
    $(".form-horizontal").hide();
    $("#prifile2").show();


});

$(document).on('click', '#fem', function () {
    $(".form-horizontal").hide();
    $("#actfile1").show();


});

$(document).on('click', '#sex', function () {
    $(".form-horizontal").hide();
    $("#actfile2").show();


});

$(document).on('click', '#sju', function () {
    $(".form-horizontal").hide();
    $("#actfile3").show();


});

$(document).on('click', '#otta', function () {
    $(".form-horizontal").hide();
    $("#actfile4").show();

});


/*
 $(document).on('click', '#sub1', function () {
 $(".btn-success").hide();
 if (myFunctin('txt1') == true) {
 
 
 $("#confileout1").show();
 
 
 
 }
 
 });
 
 $(document).on('click', '#sub2', function () {
 $(".btn-success").hide();
 if (myFunctin('txt2') == true) {
 
 $("#confileout2").show();
 
 
 }
 
 
 });
 
 
 
 $(document).on('click', '#sub3', function () {
 $(".btn-success").hide();
 if (myFunctin('txt3') == true) {
 
 $("#prifileout1").show();
 }
 
 });
 
 
 $(document).on('click', '#sub4', function () {
 $(".btn-success").hide();
 if (myFunctin('txt4') == true) {
 $("#prifileout2").show();
 }
 
 });
 
 $(document).on('click', '#sub5', function () {
 $(".btn-success").hide();
 if ((myFunctin('txt7') == true) && (myFunctin('txt8') == true)) {
 $("#actfileout1").show();
 }
 
 
 });
 
 $(document).on('click', '#sub6', function () {
 $(".btn-success").hide();
 if ((myFunctin('txt9') == true) && (myFunctin('txt10') == true)) {
 $("#actfileout2").show();
 }
 
 });
 
 
 $(document).on('click', '#sub7', function () {
 $(".btn-success").hide();
 if (myFunctin('txt5') == true) {
 
 $("#actfileout3").show();
 }
 
 });
 
 
 $(document).on('click', '#sub8', function () {
 $(".btn-success").hide();
 if (myFunctin('txt6') == true) {
 
 $("#actfileout4").show();
 }
 
 });
 
 */






