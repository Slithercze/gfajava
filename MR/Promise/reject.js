new Promise((resolve, reject) => {
    reject("Something went wrong")
})
    .then(data => {
        console.log(data)
    })
    .catch(err => {
        // zapisNekamDoLogu()
        console.error(err)
    })