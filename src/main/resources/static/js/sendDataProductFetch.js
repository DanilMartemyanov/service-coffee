// $(document).ready(function () {
//     $("#btnSubmit").click(function (event) {
//         event.preventDefault();
//         addProductSubmit();
//     });
// });

//  async function addProductSubmit() {
//     const form = document.querySelector("#form")
//     const formData = new FormData(form);
//     const data = new URLSearchParams(formData);
//     //  let data = {
//     //      "nameProduct" : "что то ",
//     //      "compound": "ssss",
//     //      "cookingTime": 4,
//     //      "price": 232
//     //  }
//      console.log("--------------")
//      console.log(form)
//      console.log("--------------")
//      console.log(formData)
//      console.log("--------------")
//     console.log(data)
//     let response =  await fetch("/addProduct", {
//         method: "POST",
//         headers:{
//             'Content-Type': 'application/json'
//         },
//         body: data
//     })
// }

// function addProductSubmit(){
//     const form = document.querySelector("#form")
//     const formData = new FormData(form);
//     // const data = new URLSearchParams(formData);
//
//     $.ajax({
//         type: "POST",
//         url: "/addProduct",
//         // data: JSON.stringify(Object.fromEntries(formData)),
//         contentType: "application/json",
//         dataType: "json",
//         data: JSON.stringify(Object.entries(formData)),
//         processData: false
//     });
// }


const form  = document.querySelector("#formProduct")

form.addEventListener("submit", async  function (event) {
    event.preventDefault()

    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    let productId;
    fetch('/addProduct', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then((response) => response.json())
        .then((data) => {productId=data.id});


});