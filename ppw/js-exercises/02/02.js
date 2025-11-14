const counter = document.getElementById("counter");

document.getElementById("increment").addEventListener("click", () => {
    const n = parseInt(counter.innerText);
    counter.innerText = n + 1;
});

document.getElementById("reset").addEventListener("click", () => {
    counter.innerText = "0";
});