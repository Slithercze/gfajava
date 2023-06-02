// chci pouzivat await, proto pisu async
async function letsfuckshitup() {
    // slibuju ze ti dam response ze serveru
    let nekdy = fetch("https://jsonplaceholder.typicode.com/todos/2")
    // az mi das response, vyndam ti z toho json, bracho
        .then(response => response.json())
        // zde chybi error handling

    // await "zastavi" vykonavani dalsiho kodu nez vyresi tyto promises
    let result = await fetch("https://jsonplaceholder.typicode.com/todos/1")
        // az mi das response, vyndam ti z toho json, bracho
        .then(response => response.json())
        // az mi das json, vyndej z nej userId
        .then(json => console.log(json.userId))
        // hele kluci, neco se vam tam rozbilo - error handling
        .catch(err => console.error(err))

    // vypisou se v poradi tak, jak je vidime
    console.log("nulty")
    nekdy.then(json => console.log(json))
    console.log("prvni")
    console.log(result)
    console.log("druhy")
    console.log("treti")
    console.log(result)
    console.log("ctvrty")
    console.log("paty")
  

    // vysledkem bude: pred, po, uvnitr 1, venku 1
    // pokud na radek 33 dame await, vysledek bude: pred, uvnitr 1, venku 1, po
    console.log("pred")
    let mujJson;
    (async () => {
        let promise = await fetch("https://jsonplaceholder.typicode.com/todos/1")
        // console.log(promise)
        let json = await promise.json()
        mujJson = json.userId;
        console.log("uvnitr", json.userId)
    })().then(() =>  console.log("venku", mujJson))
    // console.log(mujJson)
    console.log("po")




    let fetchWithAwaitAndThen = await fetch("https://jsonplaceholder.typicode.com/todos/1")
        .then(response => response.json())
    // vysledek bude JSON, nikoliv Promise.pending(), protoze delame await
    console.log(fetchWithAwaitAndThen)

    let pending = fetch("https://jsonplaceholder.typicode.com/todos/1")
    // vysledek bude Promise.pending()
    console.log(pending)
    setTimeout(() => {
        // vysledek bude JSON, uz dobehlo event loopem
         console.log(pending)
    }, 3000)

    // pseudokod, napsani vlastni Promise, coz neni typicky pripad
    // jak cca. funguje fetch, neberte me za slovo
    let fetchPromise = new Promise((resolve, reject) => {
        const response = ziskejOdpoved();
        if (response.ok) {
            return resolve(response)
        }
        return reject(response.status)
    })
    console.log(fetchPromise)
}

letsfuckshitup()