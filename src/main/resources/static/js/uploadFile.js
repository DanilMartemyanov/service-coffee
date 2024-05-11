
    function sendFile() {
    console.log("зашел в sendFile()")
    // данные для отправки
    let formData = new FormData();
    // забрал файл из input
    let files = ($('#file'))[0]['files'];
    // добавляю файл в formData
    [].forEach.call(files, function (file, i, files) {
    formData.append("file", file);
});
    console.log("aaaaa")
    $.ajax({
    type: "POST",
    url: "/addProduct",
    data: formData,
    processData: false,
    contentType: false
})
}
