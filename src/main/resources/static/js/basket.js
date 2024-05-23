
function sendProductInBasket(productId) {
    const number = document.querySelector("#countProductNumber" + productId)
    const countProduct = number.innerHTML
    console.log(countProduct)

    const data = {
        "productId": productId,
        "countProduct": countProduct
    }
    fetch("/basket", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
}