function updateBasket(productId){
    console.log("delete product")
    let data = {
        "productId": productId
    }
    console.log(data)
    fetch("/updateBasket", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(res => alert(res.body));
}