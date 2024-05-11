<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/uploadFile.js"></script>
    <script src="/js/cardProduct.js"></script>
    <title>AddCoffe</title>
</head>
<body>
<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<div class="container">
    <div>
        <h2>Добавить товар</h2>
    </div>
    <div>
        <form action="/addProduct" method="post" enctype="multipart/form-data">
            <label for="nameProduct">Название</label>
            <div>
                <input type="text" name="nameProduct" id="nameProduct">
            </div>
            <label for="compound">Состав</label>
            <div>
                <input type="text" name="compound" id="compound">
            </div>
            <label for="cookingTime">Время приготовления</label>
            <div>
                <input type="number" name="cookingTime" id="cookingTime" placeholder="В минутах">
            </div>
            <label for="price">Цена</label>
            <div>
                <input type="number" name="price" id="price">
            </div>
            <label for="category">Категория</label>
                 <div>
                    <select name="category" id="category">
                        <#list categories as category>
                            <option value="${category.id}">${category.name}</option>
                        </#list>
                    </select>
                 </div>
            <label for="file">Добавить фото товара</label>
            <div>
                <input type="file" name="file" id="file">
            </div>
            <button type="submit">Добавить товар</button>
        </form>
    </div>
    <div>
        <button onclick="cardProduct($('#nameProduct').val())">Посмотреть карточку товара</button>
    </div>
</div>
</body>
</html>