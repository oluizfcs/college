document.addEventListener("click", (e) => {
    if (e.target.nodeName != "BUTTON") {
        return;
    }

    let color = "";

    switch (e.target.style.backgroundColor) {
        case "red":
            color = "hsla(0, 79%, 54%, 1.00)";
            break;
        case "green":
            color = "rgba(76, 226, 114, 1)";
            break;
        case "blue":
            color = "#4444f7ff"
            break;
        default:
            return;
    }

    document.querySelector("body").style.backgroundColor = color;
    document.querySelector("p").innerText = e.target.innerText + " theme";
});