const button = document.querySelector("button");

button.style.position = "absolute";
button.style.top = (window.innerHeight / 2) + "px";
button.style.left = (window.innerWidth / 2) + "px";

function randomInt(max) {
    return Math.floor(Math.random() * max);
}

button.addEventListener("mouseenter", function () {
    this.style.top = randomInt(window.innerHeight) + "px";
    this.style.left = randomInt(window.innerWidth) + "px";
});

button.addEventListener("click", () => {
    alert("Congrats!");
})