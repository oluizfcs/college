if (localStorage.getItem("theme") === null) {
    localStorage.setItem("theme", "light");
}

document.querySelector("body").style.backgroundColor = localStorage.getItem("theme") === "light" ? "white" : "gray";

document.getElementById("toggle").addEventListener("click", () => {
    const theme = localStorage.getItem("theme");

    document.querySelector("body").style.backgroundColor = theme === "light" ? "gray" : "white";
    localStorage.setItem("theme", theme === "light" ? "dark" : "light");
});
