function cardProduct(nameProduct){
    let data = {
        "nameProduct": nameProduct
    }
    $.ajax({
        type:"POST",
        url:"/cardProduct",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json"
    })
}