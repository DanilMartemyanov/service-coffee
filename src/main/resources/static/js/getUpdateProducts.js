
 async function updateProducts(){
    const  data = await fetch("/allProducts",{

        method: "GET",
        headers:{
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
     console.log(data)

}
// function renderTable(product, table){
//     console.log("renderTable")
//     console.log(product)
//     // const table = document.querySelector("#table")
//     let innerHtml = '<tr>\n' +
//         '               <th>ID</th>' +
//         '               <th>Name</th>' +
//         '               <th>Compound</th>' +
//         '               <th>Cooking Time</th>' +
//         '               <th>Price</th>' +
//         '            </tr>';
//     for (let i = 0; i < product.length; i++) {
//         console.log(product[i]['name'])
//         innerHtml += '<tr>';
//         innerHtml += '  <td>' + product[i]['id'] + '</td>';
//         innerHtml += '  <td>' + product[i]['name'] + '</td>';
//         innerHtml += '  <td>' + product[i]['compound'] + '</td>';
//         innerHtml += '  <td>' + product[i]['cookingTime'] + '</td>';
//         innerHtml += '  <td>' + product[i]['price'] + '</td>';
//         // innerHtml += '  <button onclick="deleteProduct(i)">Удалить</button>';
//         innerHtml += '</tr>';
//     }
//     table.html(innerHtml);
// }