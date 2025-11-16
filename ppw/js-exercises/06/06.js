const input = document.querySelector("input");
const button = document.getElementById("add");
const ul = document.querySelector("ul");

let tasks = localStorage.getItem("tasks");

function updateList() {

    if (tasks === null || tasks === "") {
        tasks = [];
    }

    if (typeof (tasks) == "string") {
        tasks = tasks.split(",");
    }

    ul.innerHTML = "";

    tasks.forEach(e => {
        if (e != null) {
            const li = document.createElement("li");
            const btn = document.createElement("button");
            const span = document.createElement("span");

            span.innerText = e;
            btn.type = "button";
            btn.innerText = "x";
            btn.addEventListener("click", function () {
                tasks[tasks.indexOf(e)] = null;
                this.parentElement.remove();
                save();
            });

            li.appendChild(span);
            li.appendChild(btn);
            ul.appendChild(li);
        }
    });
}

updateList();

function save() {

    tasks = [];

    ul.childNodes.forEach(e => {
        if (e.nodeName == "LI") {
            tasks.push(e.firstChild.innerText);
        }
    });

    localStorage.setItem("tasks", tasks.join(","));
}

button.addEventListener("click", () => {
    tasks.push(input.value);
    input.value = "";
    input.focus();
    updateList();
    save();
});