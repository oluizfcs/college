const textarea = document.querySelector("textarea");
const p = document.querySelector("p");
const charCounter = document.getElementById("char-count");


textarea.addEventListener("keyup", () => {
    p.innerText = textarea.value;
    charCounter.innerText = textarea.value.length;
});
