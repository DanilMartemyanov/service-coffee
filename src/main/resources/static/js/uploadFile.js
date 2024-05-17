// const file = document.querySelector("#formFile").querySelector("#file")

// form.addEventListener("submit", async function (event) {
//     const formData = new FormData()
//     formData.append("file", file.files[0])
//     fetch("/uploadFile",{
//         method:"POST",
//         body:formData
//     })
    // console.log("зашел в функцию")
    // let files = file[0]['files'];
    // let formData = new FormData();
    //     [].forEach.call(files, function (file, i, files) {
    //     formData.append("file", file);
    // });

    // $.ajax({
    //     type: "POST",
    //     url: "/uploadFile",
    //     data: formData,
    //     contentType: false,
    //     processData: false
    // });
// });
$(document).ready(function () {
    $("#btnSubmitFile").click(function (event) {
        event.preventDefault();
        sendFiel();
    });
});

function sendFiel(){
    // const formData = new FormData()
    // formData.append("file", file.files[0])
    // fetch("/uploadFile",{
    //     method:"POST",
    //     body:formData
    // })
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


