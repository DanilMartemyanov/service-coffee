function uploadFileAccount(){
    // let files = file[0]['files'];
    let formData = new FormData();
    let files = ($('#filePhoto'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/addAccountPhoto",
        data: formData,
        contentType: false,
        processData: false
    }).done(function (response){
        const el = document.querySelector("#accountPhoto")
        const cardUrl = `${window.location.origin}/images/${response}`;
        const link = document.createElement("img");
        link.src=cardUrl;
        link.class="w-24 h-24 mb-3 rounded-full shadow-lg"
        el.append(link)
    });
}