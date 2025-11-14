const p1 = document.getElementById("p1");
const p2 = document.getElementById("p2");
const p3 = document.getElementById("p3");

const bText = document.getElementById("text");
const bColor = document.getElementById("color");
const bHide = document.getElementById("hide");

bText.addEventListener("click", () => {
    p1.innerHTML = `<s style="color: grey">${p1.innerText}</s> Text modified.`;
});

bColor.addEventListener("click", async () => {
    for (let i = 0; i <= 5; i++) {
        p2.style.color = "cyan";
        await new Promise(r => setTimeout(r, 60));
        p2.style.color = "red";
        await new Promise(r => setTimeout(r, 60));
    }
});

bHide.addEventListener("click", function () {
    const hidden = p3.style.display === "none";
    p3.style.display = hidden ? "block" : "none";
    this.innerText = hidden ? "Hide" : "Show";
});
