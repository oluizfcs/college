const input = document.querySelector("input");
const addButton = document.getElementById("add");
const list =  document.querySelector("ul");

const tasks = JSON.parse(localStorage.getItem("tasks") || "[]");

listTasks();

function listTasks() {

    list.innerHTML = "";

    tasks.forEach((e, i)=> {
        const li = document.createElement("li");
        const span = document.createElement("span");
        const button = document.createElement("button");

        span.innerText = e;
        button.innerText = "x";
        button.addEventListener("click", () => {
            tasks.splice(i, 1);
            save();
            listTasks();
        });

        li.appendChild(span);
        li.appendChild(button);
        list.appendChild(li);
    });
}

function save() {
    localStorage.setItem("tasks", JSON.stringify(tasks));
}

addButton.addEventListener("click", () => {
    const value = input.value.trim();
    if(!value) {
        return;
    }

    tasks.push(value);
    input.value = "";
    input.focus();
    save();
    listTasks();
});