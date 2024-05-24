$(document).ready(function () {
    $("#btnUploadFileAccount").click(function (event) {
        event.preventDefault();
        uploadFileAccount();
    });
});
function uploadFileAccount(){
    let formData = new FormData();
    let files = ($('#filePhoto'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });
    console.log("ulploadFileAccount")
    $.ajax({
        type: "POST",
        url: "/addAccountPhoto",
        data: formData,
        contentType: false,
        processData: false
    })
        .done(function (response){
        const el = document.querySelector("#accountPhoto")
        const accountPhotoUrl = `${window.location.origin}/account/images/${response}`;
        el.setAttribute("src", accountPhotoUrl)
    });
}