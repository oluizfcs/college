const div = document.querySelector("div");
const color = div.style.backgroundColor;

div.style.transition = "0.2s";

function randomInt(max) {
    return Math.floor(Math.random() * max);
}

div.addEventListener("mouseover", function () {
    div.style.backgroundColor = `rgb(${randomInt(256)}, ${randomInt(256)}, ${randomInt(256)})`;
});

div.addEventListener("mouseout", function () {
    div.style.backgroundColor = color;
});