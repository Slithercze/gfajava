# OtocyonSIC Foundation Normal Exam

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
- Use the correct class names, i.e. `GreatestValuesInMatrices`, `MostProductiveYear`, `Contestant` etc.
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


### Greatest values in matrices

Write a `mergeMatrix` function which takes two matrices as parameters and returns a new matrix.
The method should compare each element in the input matrices and fill the
returned matrix with the greater values.
You only have to deal with square matrices and should throw an `IllegalArgumentException` on invalid input
or if the matrices are not the same size.
A square matrix is a matrix with the same number of rows and columns.

Write 2 different test cases for the method.

#### Example 1

Input 1

```text
[
  [2, 1],
  [0, 1]
]
```

Input 2

```text
[
  [0, 3],
  [-1, 1]
]
```

Output

```text
[
  [2, 3],
  [0, 1]
]
```

#### Example 2

Input 1

```text
[
  [-1, 1, 0],
  [0, 1, 0],
  [0, 1, 0]
]
```

Input 2

```text
[
  [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0]
]
```

Output

```text
[
  [0, 1, 0],
  [0, 1, 0],
  [0, 1, 0]
]
```

### Most productive year

We have a very simple database consisting of only csv files (comma separated values).
Write a method called **mostProductiveYear()** which can read and parse a file containing information about movies.
This method takes **one argument**, which is the string path of the csv file of a film studio
and returns the most productive year for the film studio.
The most productive year is a year in which studio produced the **highest** number of movies.

If we do not have any data about the studio,
the method **returns** an error message:
"Cannot find studio {studio name}, please try again later."

In case of `null` input the function should throw an `IllegalArgumentException`.

There are two example files, take a look at them in raw format (either download it or click on **raw** here on github).
These are csv files with comma separated values:

- [Marvel](./assets/marvel.csv)
- [Paramount](./assets/paramount.csv)

Please note that the inputs of the following examples expect that the csv files are in the `assets` folder
of the project. If you placed these files to a different location, you should change the input paths accordingly.

#### Example 1

Input

```text
assets/marvel.csv
```

Output

```text
2017
```

#### Example 2

Input

```text
assets/paramount.csv
```

Output

```text
2008
```

#### Example 3

Input

```text
assets/ghibli.csv
```

Output

```text
Cannot find studio ghibli, please try again later.
```

### Online betting system

In this exercise you will create an online betting system.
We need to track the result of a race and evaluate the bets.
You can read the specification below.

#### Contestant

Create a `Contestant` class, this will represent
a contestant attending the race.
It has 2 private fields

- `name` - the name of the contestant, set through constructor

- `placement` - an integer, it represents the place
  the contestant finished at the race. It's default value is 0.

and three public methods

- `getPlacement()` - returns the value of the placement field

- `setPlacement(value)` - sets the placement field of the contestant to the given value,
expect if the given value is negative. if it's negative, keep the previous value.

- `toString()` - the method should return a string formatted like the following:

  - `{name} has finished on place: {placement}`

#### Bet

Create a `Bet` class, this will represent the bets made by the `Player`.
It has 4 private fields:

- `betId` - a random number between 1000 - 9999, set automatically when a Bet object is created
- `amount` - an integer, it represents the amount of money made on the bet
- `player` - it represents the owner of the bet
- `contestant` - it represents the contestant the bet was made on

The `Bet` class has contructor where we can pass the `amount`, the `player` and the `contestant`
(in this order).

The `Bet` class has the following public getters:

- `getBetId` - returns the value of the `betId` field
- `getAmount` - returns the value of the `amount` field
- `getPlayer` - returns the value of the `player` field
- `getContestant` - returns the value of the `contestant` field

#### Player

Create a `Player` class with 3 private fields:

- `name` - a string, the name of the player
- `account` - an integer, it represents the amount of money the player has
- `bets` - a `Bet` list which stores the bets made by the player

The `Player` class has contructor where we can pass the `name` and the `account` (in this order).

The `Player` class has 4 public methods

- `makeBet(contestant, amount)`
  
  - it makes a bet with the given amount of money and the given contestant
  
  - store the `bet` in the `bets` list if the player
    has enough money to make the bet, and reduces the amount from the player's account
  
  - if the player does not have sufficient amount of money just ignore the bet

- `addMoney(int amount)`

  - if the amount is positive, it adds the given amount to the player's account

  - otherwise keep the previous account

- `getName()` - returns the value of the `name` field

- `getBets()` - returns the value of the `bets` field

#### Race

Create a `Race` class. This class will simulate a race.
It has 2 private fields which should be set through the constructor.

- `contestants` - it will store all of the contestants attending the race
- `players` - it will store all of the players

and 1 public method

- `startRace()` - this will simulate a race
  
  - first you need to evaluate the race by setting the placement
    field of the contestants to a random number (`1 <= x <= contestants.length`)
  
  - please keep in mind that every contestant's placement should be unique
  
  - after the evaluation, write the placements to the console
    in increasing order (use the contentants' `toString()` method)
  
  - to keep things simple a bet is won if the contestant won the race
    and the player will win the double price of the money he made the bet with

  - the price that each player won should be added to the player's account
  
  - finally you need to write the winners to the console in the following format
  
    - `{name} has won {money}$ with the bet: {betId}`


#### Example

We have 3 contestants: `Contestant 1`, `Contestant 2`, `Contestant 3`
We have 4 players:
 
- `Player 1` with 1000$
- `Player 2` with 2000$
- `Player 3` with 3000$
- `Player 4` with 1000$

The players make bets:

- `Player 1` is betting on `Contestant 1` with 500$ --> now they have 500$
- `Player 2` is betting on `Contestant 2` with 500$ --> now they have 1500$
- `Player 3` is betting on `Contestant 3` with 5000$, but it's ignored, because thay don't have enough money
- `Player 3` is betting on `Contestant 3` with 1000$ --> now they have 2000$
- `Player 4` is betting on `Contestant 2` with 1000$ --> now they have 0$

We create a race with all the players and contestants above, then we start the race.
A possible outcome on the console:

```
Contestant 2 has finished on place: 1
Contestant 1 has finished on place: 2
Contestant 3 has finished on place: 3
Player 2 has won 1000$ with the bet: 5478
Player 4 has won 2000$ with the bet: 5214
```

In this case `Player 2` now has 2500$, and `Player 4` has 2000$ on their account.

Test input you can use
```java
List<Contestant> contestants = new ArrayList<>();
contestants.add(new Contestant("Contestant 1"));
contestants.add(new Contestant("Contestant 2"));
contestants.add(new Contestant("Contestant 3"));

List<Player> players = new ArrayList<>();
players.add(new Player("Player 1", 1000));
players.add(new Player("Player 2", 2000));
players.add(new Player("Player 3", 3000));
players.add(new Player("Player 4", 1000));

players.get(0).makeBet(contestants.get(0), 500);
players.get(1).makeBet(contestants.get(1), 500);
players.get(2).makeBet(contestants.get(2), 5000);
players.get(2).makeBet(contestants.get(2), 1000);
players.get(3).makeBet(contestants.get(1), 1000);

new Race(contestants, players).startRace();
```

## Command line exercise

- Take a look at this directory structure:

```text
restaurant
 |--storage
 |   |--.git
 |   |--drygoods.csv
 |   |--vegnfruit.csv
 |   |--chilledprods.csv
 |   └--acount
 |       |--2019-sum.csv
 |       └--2020-sum.csv
 └--delivery
     |--drivers
     |   └--john-working-hours.csv
     |--jessica-working-hours.csv
     └--account
         └--2019-sum.csv
```

- Your task is to write commands in the correct order from the directory given below.
- Do it with the smallest number of commands possible without chaining them together.
- Assume that the following files are currently in the staging area:
  - `storage/acount/2020-sum.csv`
  - `storage/acount/2019-sum.csv`
- Your current directory is `restaurant/`
  1. Remove every file from the staging area
  1. Rename `storage/acount` to `storage/account`
  1. Commit the changes
  1. Change the `delivery` directory into a Git repository
  1. Move `delivery/jessica-working-hours.csv` file to `delivery/drivers` directory

- Solution:

```text
*type your answer here*
```
