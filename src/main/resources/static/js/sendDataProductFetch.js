
const form  = document.querySelector("#formProduct")

form.addEventListener("submit",  function (event) {
    event.preventDefault()

    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });


     fetch('/addProduct', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then((response) => response.json())
        .then(function (data){
            const cardUrl = `${window.location.origin}/cardProduct/${data.id}`;
            const el = document.querySelector("#photoCardProduct");
            const link = document.createElement("a");
            link.href=cardUrl;
            link.textContent="Карточка товара";
            el.append(link);
            updateProducts();
        });
});

