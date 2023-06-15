const p = document.querySelector("p");

function addTask(e) {
    e.preventDefault();

    const formData = new FormData(e.target);
    const task = Object.fromEntries(formData);

    fetch("/api/notes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(task)
    }).then(response => {
        if (response.ok) {
            p.innerHTML = "";
            p.innerText = "New note was saved.";
            e.target.reset();
        }
    });
}

document.querySelector("form").addEventListener("submit", addTask);
