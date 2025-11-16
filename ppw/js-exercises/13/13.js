const dark = document.getElementById("dark");
const imgExtraZoom = document.getElementById("img-extra-zoom");

document.querySelectorAll("img").forEach(e => {
    e.addEventListener("mouseover", function () {
        e.classList.add("zoom");
    });
    e.addEventListener("mouseout", function () {
        e.classList.remove("zoom");
    })

    e.addEventListener("click", function () {
        dark.style.display = "flex"
        imgExtraZoom.src = e.src;
    });
});

document.getElementById("close").addEventListener("click", () => {
    dark.style.display = "none";
})