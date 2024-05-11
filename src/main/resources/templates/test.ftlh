<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/uploadFile.js"></script>
    <title>Test</title>
</head>
<body>
<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<#--<script>-->
<#--    function sendFile() {-->
<#--        console.log("зашел в sendFile()")-->
<#--        // данные для отправки-->
<#--        let formData = new FormData();-->
<#--        // забрал файл из input-->
<#--        let files = ($('#file'))[0]['files'];-->
<#--        // добавляю файл в formData-->
<#--        [].forEach.call(files, function (file, i, files) {-->
<#--            formData.append("file", file);-->
<#--        });-->
<#--        console.log("aaaaa")-->
<#--        $.ajax({-->
<#--            type: "POST",-->
<#--            url: "/test",-->
<#--            data: formData,-->
<#--            processData: false,-->
<#--            contentType: false-->
<#--        })-->
<#--    }-->
<#--</script>-->
<div class="container">
<#--    <form action="/test" method="post" enctype="multipart/form-data">-->
<#--        <input type="file" name="file">-->
<#--        <button type="submit">Отправить</button>-->
<#--    </form>-->
    <div>
        <input type="file" name="file" id="file">
        <button onclick="sendFile()">Отправька</button>
    </div>
</div>
</body>
</html>