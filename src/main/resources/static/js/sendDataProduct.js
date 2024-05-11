$(document).ready(function () {
    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        console.log("---------")
        addProductSubmit();
    });
});

function addProductSubmit() {
    let form = $("#form")[0];
    let data = new FormData(form)
    console.log('-------------')
    console.log(data)
    $("#btnSubmit").prop("disabled", true);
    $.ajax({
        method: "POST",
        enctype: "multipart/form-data",
        url: "/addProduct",
        data: data,
        contentType: false,
        processData: false,
        success: function (data) {
            console.log("SUCESS: ", data)
        }
    })
}