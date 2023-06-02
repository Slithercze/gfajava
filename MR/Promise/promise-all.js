// advanced methods: Promise.all or Promise.allSettled

const promise1 = Promise.resolve(3);
const promise2 = 42;
const promise3 = new Promise((resolve, reject) => {
  setTimeout(reject, 100, 'foo');
});

Promise.allSettled([promise1, promise2, promise3]).then((values) => {
  console.log(values);
})
// .catch(err => console.error(err));