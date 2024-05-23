async function addFavoritesProduct(productId){
    let data = {
        "productId": productId
    }
    let existProduct;
    await fetch("/addFavoriteProducts", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(response => existProduct = response.json)
        .then(function (data){
            if (data != null){
                const el = document.querySelector("#btnAddProduct")
                const  dis = document.createAttribute("disabled:bg-slate50")
                el.setAttribute("disabled", "")
                alert("товар добавлен в избранное")
            }else{
                alert("ошибка")
            }
        });
}