# OtocyonSIC Foundation Retake Exam

## Getting Started

- **Fork** this repository under your own account
- Clone your forked repository to your computer
- Create a `.gitignore` file so generated files won't be committed
- Commit your progress frequently and with descriptive commit messages
- All your answers and solutions should go in this repository
- Take care of style guide
- Take care of the naming of classes, fields, variables, files, etc.

## Keep in mind

- You can use any resource online, but **please work individually**
- AI help is not allowed (eg. chatGPT, copilot, ...)
- **Don't just copy-paste** your answers and solutions,
  you need to understand every line of your code
- **Don't push your work** to GitHub until your mentor announces
  that the time is up
- At the end of the exam push your solution to **GitHub** and upload it to GradeScope

### Java

- Use [JDK 8 (Java 1.8)](## "Using API from versions newer than Java 1.8 may result in syntax errors on Gradescope")
- All of your classes should be in the `com.gfa.exam` package
- Do not use more packages
- Use the correct class names, i.e. `TextFromMatrix`, `WeeklyFeedbackEvaluator`, `Toy` etc.
- Make sure to declare all required classes and methods as `public`
- Using of `Stream` is **not allowed** in this exam
- At the end of the exam upload your solution to **Gradescope** too

### TypeScript

- Make sure to export all of your classes and functions.
- Use 3rd party libraries only for converting/running TypeScript, linting, and testing.
Other libraries are not allowed.
- At the end of the exam upload your solution to **Gradescope** too

### C#

- Method names should start with capital letter
- Using of `LINQ` is **not allowed** in this exam

## GradeScope notes for Java and TypeScript

- Half an hour before the end of the exam you can push your solution to **Gradescope** too
- You may upload to GradeScope multiple times in the allocated time
- You may upload your solution to GradeScope as a **zip** file

## Exercises


### Text from matrix

Write a `textFromMatrix` method which takes a `2D array / matrix` containing letters (strings)
and returns a text.
The method creates the text from the letters found in the matrix.

Which letters to select: 

- from every even row, select the letter found in the even columns
- from every odd row, select the letter found in the odd columns

The letters should be concatenated in this order: from left-top to right-bottom.

If the given `2D array / matrix` is `null`, the function should throw an `IllegalArgumentException`.

Note, that the given `2D array / matrix` is not necessarily a square matrix,
the number of rows and columns can differ from each other.

Write 2 different unit test cases for the method.

#### Example 1

Input

```text
[
  ["n", "x"],
  ["m", "o"]
]
```

Output

```text
"no"
```

#### Example 2

Input

```text
[
  ["h", "p", "e"],
  ["k", "l", "a"],
  ["l", "m", "o"]
]
```

Output

```text
"hello"
```

### Weekly feedback evaluator

Write an `evaluateFeedback` function which can read and parse a file containing information about
weekly feedback from apprentices about a mentor.

The method takes a string `filePath` as a parameter.

The mentor is _rated_ in 4 different metrics, those are respectively (_`matReview`_, _`presSkills`_, _`helpfulness`_, _`explanation`_) separated with 1 space:

- m = `matReview`
- p = `presSkills`
- h = `helpfulness`
- e = `explanation`

```text
m p h e   // this is just an info line which is not in the actual file
1 3 5 3   // this line is an answer from an apprentice
2 3 4 3   // this is another response
...
```

The method should return a map/dictionary containing the average rating
(in each metric) of the mentor.

- If the file is not found, it should write the following to the console: `File not found: `_`filename`_
- If the file is empty, the output values should be 0.

#### Example

[Example file can be found here.](./responses.txt)

Output

```js
{
  "matReview": 2.25,
  "presSkills": 4.0, // or 4 is fine as well
  "helpfulness": 4.5,
  "explanations": 3.75
}
```

Output when the file is empty or not found

```json
{
  "matReview": 0.0,
  "presSkills": 0.0,
  "helpfulness": 0.0,
  "explanations": 0.0
}
```

Since the method returns a map/dictionary the order of the keys may differ from the examples above

### Santa Factory

You are going to create a Santa's Toy Factory and help Santa bring
the remaining toys to the poor children.

#### Toy

- It has cost (integer), color (string) and owner (string).
- When a toy is produced the owner should be null.
- Note: the owner will be assigned later by `Santa`

##### Doll

- It costs 25 and each of them could have different color. 
  The color must be set at creation.

##### DottedBall

- It costs 10, and each of them could have different color and *size* (integer). 
  Both of them must be set at creation.

##### JumpingRope

- It costs 15, and each of them could have different color and *size* (integer). 
  Both of them must be set at creation.

#### Toy Factory

- It has a balance (integer): 200 by default.

- It has a `produce(color, size)` method where you can produce a `Toy`. 

  - The `Toy` can be of any type which has size (choose randomly).
  - It shall return a toy if there is sufficient money for it.
  - Otherwise return null.
  - Update the balance accordingly.

- It has a `produce(color)` method where you can produce a `Doll`. 

  - It shall return a `Doll` only if there is sufficient money for it.
  - Otherwise return null.
  - Update the balance accordingly.

#### Santa

- Has a `factory`, which is of course a toy factory.

- Has a `bag` as a list of toys.

- Has a `children` list with names. This list represents all children in the word.

- When we create Santa, we have to provide a `factory` and the `children` names. Santa's bag is empty at the beginning.

- Has an `addToyToBag(color, size)` method which calls any of the the Santa factory's
  `produce` method randomly, and adds the produced toy to the `bag`.
  - If the factory ran out of its balance and couldn't produce a toy, don't modify the `bag`.
  - When the one parameter produce() version is called, ignore the size parameter.

- Has a `bringToChildren()` method which

  - Takes a list with the names of children e.g.: `["Lacika", "Sanyika"]`.
    This list represents the children who gets presents when
    the method is called (this is a sub list of the children list).
    Imagine that Santa can transfer a limited amount of toys in one round.
  
  - Santa brings the toys to the children until the bag is not empty
    or there are no more children left.
  
  - When a toy is being delivered, it gets its owner
    (a random children name from the parameter list).
  
  - The owner should be removed from both of the children lists
    and the toy should be removed from the bag too.

## Command line exercise

- Take a look at this directory structure:

```text
homework
 |--math
 |   |--.git
 |   |--calculus
 |   |   |--jacobian_matrix.md
 |   |   └--exercises
 |   |       └--week01_hw.txt
 |   └--geometry
 |       |--week01_hw.txt
 |       └--pithagorean_theorem.md
 └--history
     |--.git
     |--taylor_polynomial.md
     |--history_of_rome.md
     └--history_of_greece.md
```

- Your task is to write commands in the correct order from the directory given below.
- Do it with the smallest number of commands possible without chaining them together.
- Assume that the following files are currently in the staging area:
  - `math/calculus/jacobian_matrix.md`
  - `math/geometry/pithagorean_theorem.md`
- Your current directory is `homework/`
  1. Create an `exercises` directory in `math/geometry/`
  1. Move `geometry/week01_hw.txt` to `math/geometry/exercises/`
  1. Move `history/taylor_polynomial.md` to `math/calculus/`
  1. Remove `math/geometry/pithagorean_theorem.md` from the staging area
  1. Rename `math/geometry/pithagorean_theorem.md` to `math/geometry/pythagorean_theorem.md`
  1. Commit all the changes

- Solution:

```text
- mkdir math/geometry/excercises
- mv math/geometry/week01_hw.txt math/geometry/exercises/
- mv history/taylor_polynomial.md math/calculus/
- cd math
- git reset
- git mv math/geometry/pithagorean_theorem.md math/geometry/pythagorean_theorem.md
- git add .
- git commit -m "Create new exercise directory and fix name of pythagorean theorem file"
- cd ../history
- git add .
- git commit -m "Move taylor_polynomial.md out of this repository"

```
