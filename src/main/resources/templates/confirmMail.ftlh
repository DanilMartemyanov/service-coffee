<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Подтверждение пользователя</title>
</head>
<body>
<div class="container">
    <div>
        <p>Ваш код для сброса пароля: ${confirmCode} . Скопируйте его прежде, чем переходить по ссылке</p>
    </div>
    <a href="http://localhost:8080/confirm/${confirmCode}"><button>Подтвердить</button></a>
</div>
</body>
</html>