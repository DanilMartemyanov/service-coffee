const plus = document.querySelector("#counterPlus")
const minus = document.querySelector("#counterMinus")
const number = document.querySelector("#countProductNumber")
let counter = number.innerHTML
console.log("counter")
plus.addEventListener("click", function (){
    counter++;
    number.textContent = counter
    console.log(counter)
});
minus.addEventListener("click", function (){
    counter--;
    number.textContent = counter
    console.log(counter)
});