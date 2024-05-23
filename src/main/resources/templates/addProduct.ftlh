<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/cardProduct.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>AddProduct</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<div class="container" id="app">
    <nav class="bg-white dark:bg-gray-900 fixed w-full z-20 top-0 start-0 border-b border-gray-200 dark:border-gray-600">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
            <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Что то будет</span>
            </a>
            <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-sticky">
                <ul class="flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                    <li>
                        <a href="/main"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Home</a>
                    </li>
                    <li>
                        <a href="/signIn"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">SignIn</a>
                    </li>
                    <li>
                        <a href="/signUp"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">SignUp</a>
                    </li>
                    <li>
                        <a href="sms/promoCode"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Получить
                            промокодик</a>
                    </li>
                    <li>
                        <a href="/basket"
                           class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Корзина</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="justify-center flex min-h-full flex-col py-12 px-6 lg: px-8 ">
        <h2 class="text-center mt-10 text-2xl font-normal pt-10">Создать товар</h2>
        <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm bg-white p-4 rounded-lg border">
            <form id="formProduct" @submit="addProducts" class="space-y-6">
                <label for="nameProduct" class="block text-sm font-medium leading-6 text-gray-900">Название</label>
                <div>
                    <input type="text" name="nameProduct" id="nameProduct"
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
                </div>
                <label for="compound" class="block text-sm font-medium leading-6 text-gray-900">Состав</label>
                <div>
                    <input type="text" name="compound" id="compound"
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
                </div>
                <label for="cookingTime" class="block text-sm font-medium leading-6 text-gray-900">Время
                    приготовления</label>
                <div>
                    <input type="number" name="cookingTime" id="cookingTime" placeholder="В минутах"
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
                </div>
                <label for="price" class="block text-sm font-medium leading-6 text-gray-900">Цена</label>
                <div>
                    <input type="number" name="price" id="price"
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
                </div>
                <#--            <label for="category">Категория</label>-->
                <#--                 <div>-->
                <#--                    <select name="category" id="category">-->
                <#--                        <#list categories as category>-->
                <#--                            <option value="${category.id}">${category.name}</option>-->
                <#--                        </#list>-->
                <#--                    </select>-->
                <#--                 </div>-->
                <button type="submit" id="btnSubmit"
                        class="flex w-full justify-center rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                    Добавить товар
                </button>
            </form>
            <div>
                <form id="formFile" class="space-y-6">
                    <label for="file" class="block text-sm font-medium leading-6 text-gray-900 pt-10">Загрузить
                        фото</label>
                    <input type="file" name="file" id="file"
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 p-1">
                    <button type="submit" id="btnSubmitFile"
                            class="flex w-full justify-center rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                        Загрузить фото продукта
                    </button>
                </form>
            </div>
            <script src="/js/uploadFile.js"></script>
            <div id="photoCardProduct"></div>
        </div>
        <div>
            <table class="table-auto px-9">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Compound</th>
                    <th>Cooking Time</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="product in products" >
                    <td>{{product.id}}</td>
                    <td>{{product.name}}</td>
                    <td>{{product.compound}}</td>
                    <td>{{product.cookingTime}}</td>
                    <td><input v-model="product.price" :value="product.price" type="text" :id="priceTable"></td>
                    <td>
                        <button id="bntDeleteProduct" @click="deleteProduct(product.id)"
                                class="flex w-full rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                            Удалить
                        </button>
                    </td>
                    <td>
                        <button @click="changeProductPrice(product)"
                                class="flex w-full rounded-md bg-slate-900 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-red-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                            Изменить цену товара
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script>
    const {createApp, ref} = Vue
    createApp({
        setup() {
            const products = ref([])

            async function updateProducts() {
                const data = await fetch("/allProducts", {method: "GET"}).then(res => res.json())
                products.value = data
            }

            async function addProducts(e) {
                e.preventDefault()

                const formData = new FormData(e.target);
                const data = {};

                formData.forEach((value, key) => {
                    data[key] = value;
                });

                const res = await fetch('/addProduct', {
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data)
                }).then((response) => response.json())

                const cardUrl = window.location.origin + "/cardProduct/" + res.id;
                const el = document.querySelector("#photoCardProduct");
                const link = document.createElement("a");

                link.href = cardUrl;
                link.textContent = "Карточка товара";

                el.append(link);

                updateProducts();
            }

            async function deleteProduct(productId) {
                let data = {
                    "productId": productId
                }
                await fetch("/deleteProduct", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data),
                });
                updateProducts();
            }

            async function changeProductPrice(product) {
                const data = {
                    "productId": product.id,
                    "productPrice": product.price
                }
                await fetch("/changeProductPrice", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data),
                });
                updateProducts();
            }

            updateProducts();

            return {
                changeProductPrice,
                deleteProduct,
                products,
                addProducts,
                updateProducts
            }
        }
    }).mount('#app')
</script>
</body>
</html>