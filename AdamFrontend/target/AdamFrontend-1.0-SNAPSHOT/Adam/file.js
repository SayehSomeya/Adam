/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * d open the template in the editor.
 */


$(document).on('click', '#close-preview', function () {
    $('#image-preview').popover('hide');
    // Hover befor close the preview
    $('#image-preview').hover(
            function () {
                $('#image-preview').popover('show');
            },
            function () {
                $('#image-preview').popover('hide');
            }
    );
});

$(function () {
    // Create the close button
    var closebtn = $('<button/>', {
        type: "button",
        text: 'x',
        id: 'close-preview',
        style: 'font-size: initial;',
    });
    closebtn.attr("class", "close pull-right");
    // Set the popover default content
    $('#image-preview').popover({
        trigger: 'manual',
        html: true,
        title: "<strong>Preview</strong>" + $(closebtn)[0].outerHTML,
        content: "There's no image",
        placement: 'bottom'
    });
    // Clear event
    $('#image-preview-clear').click(function () {
        $('.image-preview').attr("data-content", "").popover('hide');
        $('#image-preview-filename').val("");
        $('#image-preview-clear').hide();
        $('#image-preview-upload').hide();

        $("#accordion").hide();
        $('.image-preview-input input:file').val("");
        $("#browse").text("Browse");
    });





    // Create the preview image
    $(".image-preview-input input:file").change(function () {
        var img = $('<img/>', {
            id: 'dynamic',
            width: 250,
            height: 200
        });
        var file = this.files[0];
        var reader = new FileReader();
        // Set preview image into the popover data-content

        var x = document.getElementById("myImage").value;

        if (x.match('.sam$') || x.match('.vcf$') || x.match('.fasta$') || x.match('.bed$') || x.match('.gtf$') || x.match('.bam$')|| x.match('.fastq$')|| x.match('.fq$')|| x.match('.narrowPeak$')|| x.match('.zip')) {
            reader.onload = function (e) {
                $("#browse").text('Change');
                $("#nu").css("color", "#2e6da4");
                $("#image-preview-clear").css("color", "#2e6da4");
                $("#image-preview-clear").show();
                $("#image-preview-upload").show();
                $("#accordion").hide();
                $("#image-preview-filename").val(file.name);
                img.attr('src', e.target.result);
                $(".image-preview").attr("data-content", $(img)[0].outerHTML).popover("show");
            }
        } else {
            alert("Please upload only .sam, .vcf, .fasta, .fastq, .fq, .bed, .gtf or .narrowPeak extention file");

        }
        reader.readAsDataURL(file);
    });



});



