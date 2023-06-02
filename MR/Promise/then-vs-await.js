async function thenVsAwait() {
    fetch("https://jsonplaceholder.typicode.com/todos/1")
    // az mi das response, vyndam ti z toho json, bracho
        .then(response => response.json())
        .then(json => json.userId)
        .then(userId => fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
            .then(response => response.json())
            .then(json => console.log(json.name))
        )

    let userId = await fetch("https://jsonplaceholder.typicode.com/todos/1")
    // az mi das response, vyndam ti z toho json, bracho
        .then(response => response.json())
        .then(json => json.userId)

    setTimeout(() => console.log("UserID: ", userId), 1000)
    
    let name = await fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
        .then(response => response.json())
        .then(json => json.name)
    
    console.log(name)
}

thenVsAwait()