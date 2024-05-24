
$(document).ready(function () {
    $("#btnSubmitFile").click(function (event) {
        event.preventDefault();
        sendFiel();
    });
});

function sendFiel(){
    console.log("зашел в функцию")
    // let files = file[0]['files'];
    let formData = new FormData();
    let files = ($('#file'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/uploadFile",
        data: formData,
        contentType: false,
        processData: false
    });
}


