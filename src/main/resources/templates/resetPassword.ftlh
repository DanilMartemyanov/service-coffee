<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Сброс пароля</title>
</head>
<body>
<div class="justify-center flex min-h-full flex-col py-12 px-6 lg: px-8">
    <h1 class="text-center mt-10 text-2xl font-normal">Смена пароля</h1>
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm bg-white p-4 rounded-lg">
        <form action="/resetPassword" class="space-y-6" method="post">
            <label for="mainPassword" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
            <div>
                <input type="password" name="mainPassword" id="mainPassword" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
            </div>
            <label for="repeatPassword" class="block text-sm font-medium leading-6 text-gray-900">Repeat passowrd</label>
            <div>
                <input type="password" name="repeatPassword" id="repeatPassword" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
            </div>
            <label for="codeForResetPassword" class="block text-sm font-medium leading-6 text-gray-900" >Вставьте код для сброса</label>
            <div>
                <input type="text" name="codeForResetPassword" id="codeForResetPassword" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
            </div>
            <button type="submit" class="flex w-full justify-center rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Сменить пароль</button>
        </form>
    </div>
</div>
</body>
</html>