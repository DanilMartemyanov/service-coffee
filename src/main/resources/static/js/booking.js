async function booking(){
    console.log("booking")
    await fetch("/bookingPay",{
        method:"POST",
    }).then(res => alert("Приступили к готовке заказа"));
}