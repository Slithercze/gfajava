document.querySelector("form").addEventListener("submit", (e) => {
    e.preventDefault();

    const form = new FormData(e.target);
    const order = Object.fromEntries(form);

    fetch("/api/orders", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(order)
    })
        .then(response => response.json())
        .then(json => {
            const p = document.querySelector("p");
            p.innerHTML = "";
            p.innerText = json.id;
            e.target.reset();
        })
})
