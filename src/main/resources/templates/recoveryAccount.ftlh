<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Восстановление аккаунта</title>
</head>
<body>
<div class="justify-center flex min-h-full flex-col py-12 px-6 lg: px-8">
    <h1 class="text-center mt-10 text-2xl font-normal">Введите почту для смены пароля</h1>
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm bg-white p-4 rounded-lg">
        <form class="space-y-6" action="/recoveryAccount" method="post">
            <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Enter email</label>
            <input type="email" name="email" id="email" class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
            <button type="submit" class="flex w-full justify-center rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Отправить</button>
        </form>
    </div>
</div>
</body>
</html>