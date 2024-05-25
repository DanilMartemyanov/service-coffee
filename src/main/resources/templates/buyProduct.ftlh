<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="/js/basket.js"></script>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
<div class="container">
    <nav class="bg-white dark:bg-gray-900 fixed w-full z-20 top-0 start-0 border-b border-gray-200 dark:border-gray-600">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
            <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Что то будет</span>
            </a>
            <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-sticky">
                <ul class="flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                    <li>
                        <a href="/main" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Home</a>
                    </li>
                    <li>
                        <a href="/signIn" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">SignIn</a>
                    </li>
                    <li>
                        <a href="/signUp" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">SignUp</a>
                    </li>
                    <li>
                        <a href="sms/promoCode" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Получить промокодик</a>
                    </li>
                    <li>
                        <a href="/basket" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Корзина</a>
                    </li>
                    <li>
                        <a href="/bookingPay"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Order</a>
                    </li>
                    <li>
                        <a href="/account"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Account</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="max-w-md mx-auto pt-48 ">
        <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
        <div class="relative">
            <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
            </div>
            <input type="search" id="searchProduct"  name="q" class="block w-full p-4 pr-10 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Maybe coffee ... ?" required />
            <button type="submit" class="text-white absolute  end-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search</button>
        </div>
    </form>
    <div class="grid grid-cols-3 pt-20 px-10">
    <#list products as product>
        <div id="" value="${product.id}" class="pt-20 px-3 pl-30">

                <div class="max-w-sm rounded overflow-hidden shadow-lg">
                    <#list photos as photo>
                        <#if product.id == photo.product.id>
                    <a href="/cardProduct/${product.id}">
                            <img class=" object-cover h-96 w-96" src="/images/${photo.storageFileName}">
                    </a>
                        </#if>
                    </#list>
                    <div class="px-6 py-4">
                        <div class="font-bold text-xl mb-2">${product.name}</div>
                        <p class="text-gray-700 text-base">
                            ${product.compound}
                        </p>
                    </div>
                    <div class="px-6 pt-4 pb-2">
                        <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#Цена: ${product.price}</span>
                        <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#Время приготовления: ${product.cookingTime}</span>
                    </div>
                </div>
            <div class="flex pt-2">
                <div id="countProduct${product.id}" class="flex ">
                    <button id="counterMinus${product.id}" class="px-2 border rounded">-</button>
                    <div id="countProductNumber${product.id}" class="px-2">0</div>
                    <button id="counterPlus${product.id}" class="px-2  border rounded">+</button>
                </div>
                <div class="pl-7">
                    <button onclick="sendProductInBasket(${product.id})" class="flex w-full rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Добавить в корзину</button>
                </div>
                <script>
                    const plus${product.id} = document.querySelector("#counterPlus${product.id}")
                    const minus${product.id} = document.querySelector("#counterMinus${product.id}")
                    const number${product.id} = document.querySelector("#countProductNumber${product.id}")
                    let counter${product.id} = number${product.id}.innerHTML
                    plus${product.id}.addEventListener("click", function (){
                        counter${product.id}++;
                        number${product.id}.textContent = counter${product.id}
                    });
                    minus${product.id}.addEventListener("click", function (){
                        counter${product.id}--;
                        number${product.id}.textContent = counter${product.id}
                    });
                </script>
            </div>
        </div>
    </#list>
    </div>
</div>
</body>
</html>