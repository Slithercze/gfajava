const main = document.querySelector("main");

document.querySelectorAll("header button").forEach(function (button) {
    button.addEventListener("click", async function () {
        const type = button.getAttribute("value");
        await getTasks(type);
    })
})

/*
let url;
if (type) {
    url = "/api/notes?" + new URLSearchParams({ type: type });
} else {
    url = "/api/notes";
}
 */
async function getTasks(type) {
    main.innerHTML = "";
    const url = `/api/notes${type ? `?${new URLSearchParams({type})}` : ""}`;
    const tasks = await fetch(url).then(response => response.json());

    tasks.forEach(task => createTask(task));
}

function createTask(task) {
    const taskElement= document.createElement("div");
    const removebutton = document.createElement("button");
    const header = document.createElement("h2");
    const content = document.createElement("p");

    header.innerText = task.title;
    content.innerText = task.content;
    removebutton.innerText = "Remove";
    taskElement.classList.add("note-card");


    const removeTaskHandler = async () => await removeTask(
        task.id,
        taskElement,
        removebutton,
        removeTaskHandler
    );

    removebutton.addEventListener("click", removeTaskHandler)

    taskElement.appendChild(header);
    taskElement.appendChild(content);
    taskElement.appendChild(removebutton);
    main.appendChild(taskElement)

}

async function removeTask(id, element, removeButton, removeTaskHandler) {
    await fetch("/api/notes/" + id, {
        method: "DELETE"
    });
    removeButton.removeEventListener("click", removeTaskHandler);
    element.remove();
}

getTasks()
