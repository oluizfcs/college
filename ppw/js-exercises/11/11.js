const div = document.querySelector("div");

div.addEventListener("mousemove", (e) => {
    div.innerText = `x:${e.clientX}  y:${e.clientY}`;
});