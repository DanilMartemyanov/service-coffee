function deleteProduct(productId){
    console.log("delete product")
    let data = {
        "productId": productId
    }
    console.log("---------------")
    console.log(data)
    fetch("/deleteProduct", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data),
        success: updateProducts()
    })
}