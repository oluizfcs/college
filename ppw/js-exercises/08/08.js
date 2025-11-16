const container = document.getElementById("container");
const square = document.getElementById("square");

square.style.left = 0;
square.style.top = 0;

document.addEventListener("keydown", (e) => {
    switch (e.key) {
        case "ArrowLeft":
            if (parseInt(square.style.left) > 0) {
                square.style.left = (parseInt(square.style.left) - 50) + "px";
            }
            break;
        case "ArrowRight":
            if (parseInt(square.style.left) < parseInt(container.style.width) - parseInt(square.style.width)) {
                square.style.left = (parseInt(square.style.left) + 50) + "px";
            }
            break;
        case "ArrowUp":
            if (parseInt(square.style.top) > 0) {
                square.style.top = (parseInt(square.style.top) - 50) + "px";
            }
            break;
        case "ArrowDown":
            if (parseInt(square.style.top) < parseInt(container.style.height) - parseInt(square.style.height)) {
                square.style.top = (parseInt(square.style.top) + 50) + "px";
            }
            break;
    }
});