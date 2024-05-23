async function booking(products, counts){
    await fetch("/booking/pay",{
        method:"POST",
    }).then(res => fetch("/booking/pay"),{
        method: "GET",

    });
}