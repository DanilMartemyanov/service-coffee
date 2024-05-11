<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Сброс пароля</title>
</head>
<body>
<div class="container">
  <h1>Смена пароля</h1>
    <form action="/resetPassword" method="post">
      <label for="mainPassword">Password</label>
        <div>
            <input type="password" name="mainPassword" id="mainPassword">
        </div>
      <label for="repeatPassword">Repeat passowrd</label>
        <div>
            <input type="password" name="repeatPassword" id="repeatPassword">
        </div>
        <label for="codeForResetPassword">Вставьте код для сброса</label>
        <div>
            <input type="text" name="codeForResetPassword" id="codeForResetPassword">
        </div>
        <button type="submit">Сменить пароль</button>
    </form>
</div>
</body>
</html>