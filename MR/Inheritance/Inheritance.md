- [Packages in Java](#packages-in-java)
    - [Import](#import)
    - [Naming](#naming)
    - [Example](#example)
    - [Questions](#questions)
- [Inheritance](#inheritance)
    - [Example: Zoo](#example-zoo)
        - [Example: Zoo - Animal](#example-zoo---animal)
        - [Example: Zoo - Mammal, Bird, Fish](#example-zoo---mammal-bird-fish)
        - [Example: Zoo - Bear, Elephant, Penguin, Shark](#example-zoo---bear-elephant-penguin-shark)
        - [Example: Zoo - Add animals](#example-zoo---add-animals)
        - [Example: Zoo - Print animals](#example-zoo---print-animals)
            - [Question](#question)
        - [Example: Zoo - Dolphin](#example-zoo---dolphin)
            - [Question](#question-1)
    - [Method Overriding](#method-overriding)
    - [Modifiers](#modifiers)
        - [Access Modifiers](#access-modifiers)
        - [Non-Access Modifiers](#non-access-modifiers)
        - [Usage](#usage)
    - [Inheritance vs. Composition](#inheritance-vs-composition)
- [Polymorphism](#polymorphism)
    - [Example](#example-1)
    - [Advanced Example](#advanced-example)
- [Naming](#naming-1)
    - [Packages](#packages)
    - [Classes](#classes)
    - [Interfaces](#interfaces)
    - [Methods](#methods)
    - [Variables](#variables)
    - [Constants](#constants)
    - [Enums](#enums)
- [TODO](#todo)

# Packages in Java

In projects and workshops written so far, you've created only a handful of java
files all of which had unique names. Nevertheless, large enterprise level
applications can have hundreds if not thousands of java files (classes). It
would be very impractical to keep all these files in a single directory.

Packages are used to write code which is easier to maintain, understand and
extend. They group related classes and prevent name conflicts. One can think
classes as files and packages as directories (folders). Just as it is not
possible to have two files with identical names in a single folder, we cannot
have two Java Class with the same name in a single package.

Advantanges of using packages in Java are:
- **Maintainance**
- **Reusability**: common code can be placed in a common folder or even in a
  separate git repository
- **Name conflicts**: package help to resolve name conflights between two
  classes with identical names
- **Organized code**
- **Access protection (encapsulation)**: methods and variables declared as
  `protected` are accessible by the classes of the same package (and the
  subclasses residing in any package - see [inheritance](#inheritance))

Packages are divided into two categories:
- Built-in packages (packages from the Java API)
- User-defined packages

The Java API (part of the Javva Development Kit = JDK) is a library of classes
(components) for various commons tasks such as managing input, file io, works
with collections and many others. The complete list can be found at Oracles
[website](https://docs.oracle.com/javase/8/docs/api/)

## Import

The API is divided into `packages` and `classes`. We can either import a single
classes (making the class available together with its methods and fields), or
the whole package (which groups classes belonging to the same category)

To use a class or a package from the Java API library, we need to use the
`import` keyword:

```java
import package.name.Class;  // import a single class
import package.name.*;      // import the whole package
```

For example, to use the `Scanner` class to get the user input, we need to
import it with the following code:

```java
import java.util.Scanner;
```

Alternatively, we could specify the full class path in the code where the
Scanner class is used

```java
public class Main {

  public static void main(String[] args){
    
    java.util.Scanner scanner = new java.util.Scanner(System.in);
  }
}
```

## Naming

While developing a project, we should always follow the naming conventions
regarding package declarations.

```java
package com.greenfox.celadon.mr.inheritance;
```
- `package com.greenfox.celadon.mr.inheritance;`
    - keyword
    - reverse domain (company name)
    - client name
    - project name
    - module name

## Example

Let's go ahead and create the `com.greenfox` package in our demo folder.

First, right-click on the `src` folder, then select `new` and `Package`

<img src="assets/new-package.png" style="border: 2px solid grey">

Then type `com.greenfox`

<img src="assets/new-package-name.png" style="border: 2px solid grey">

Everything we'll add to this demo project will reside inside this package.

Here we'll create the `Demo` class with the `public static void main` method to
run our demo.

Next, let's create a package called `common` and inside it a new class `Random`

```java
package com.greenfox.common;

public class Random {}
```

Let's use this `Random` class in our demo:

```java
package com.greenfox;

public class Demo {

    public static void main(String[] args) {

        Random random = new Random();
    }
}
```

Now IntelliJ is showing an error `Cannot resolve symbol 'Random'` and when we
place the mouse cursor on one of the errors ("inside" one of the "Random")
IntelliJ advices to use press `ALT+Enter` to see the suggestions for how to fix
the error.

<img src="assets/alt-enter.png" style="border: 2px solid grey">

*NOTE:* This is always the case with any compiler error - pressing `ALT+Enter`
while the mouse cursor is somewhere within the code which caused the error will
give us suggestions for fixing it.

<img src="assets/alt-enter-import.png" style="border: 2px solid grey">

Here we can import one of the two `Random` classes:
- `com.greenfox.common`
- `java.util`

Let's import the class which we have just created

```java
package com.greenfox;

import com.greenfox.common.Random;

public class Demo {

    public static void main(String[] args) {

        Random random = new Random();
    }
}
```

If we want/need to use the other Random (java.util.Random) somewhere in this
class, we will have to specify the full class path

```java
package com.greenfox;

import com.greenfox.common.Random;

public class Demo {

    public static void main(String[] args) {

        Random random = new Random();
        java.util.Random javaRandom = new java.util.Random();
    }
}
```

## Questions

Any questions about packages?

# Inheritance

Inheritance is one of the core principles of Object-Oriented Programming. It
enables us to reuse existing code and/or extend existing classes with new
functionality.

In Java a class can inherit only a single class; it can implement many
interfaces. In this section of the Material Review presentation we'll explore
- how inheritance works with classes (and interfaces)-
- how the variable and method access modifiers (`public`, `protected`,
  `private`) affect the members which are inherited
- what it means to inherit a type

## Example: Zoo

Let's create a new `com.greenfox.zoo` package and a very simple implementation
of a Zoo app.

### Example: Zoo - Animal

First, there will be (all sorts of) animals in the Zoo, so let's create a class
called `Animal`.

```java
package com.greenfox.zoo;

public class Animal {}
```

Let's add the `numberOfLegs` variable

```java
package com.greenfox.zoo;

public class Animal {

    private int numberOfLegs;
    
}
```

and then press `ALT+INSERT` a corresponding constructor and a
getter method

<img src="assets/alt-insert.png" style="border: 2px solid grey">

```java
package com.greenfox.zoo;

public class Animal {

    private int numberOfLegs;

    public Animal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}
```

Let's have a quick look at the constructor. The line
`this.numberOfLegs = numberOfLegs;` contains the `this` keyword, which refers
to the current object (current instance). So `this.numberOfLegs` refers to the
`numberOfLegs` class variable, whereas the `numberOfLegs` refers to the local
variable in the constructor - it is the parameter of the constructor!

Please also note the getter name and the `camelCase`! The variable is called
`numberOfLegs` so the getter method should be called `getNumberOfLegs`. This
is the Java naming convention and you should follow it everywhere in your code,
including all workshop exercises, lightning talks, perhaps most importatly,
in your exams!

### Example: Zoo - Mammal, Bird, Fish

Next, let's create another class called `Mammal`

```java
package com.greenfox.zoo;

public class Mammal extends Animal {

    public Mammal() {
        super(4);
    }
}
```

We'll make the Mammal class *inherit* the Animal class by using the keyword
`extends`. Then, in the constructor of Mammal, we'll *delegate* to the
Animal's constructor using the keyword `super`.

We call Mammal a `subclass` of Animal. And Animal is the `superclass` of
Mammal.

Let's create another class called `Bird`

```java
package com.greenfox.zoo;

public class Bird extends Animal {

    public Bird() {
        super(2);
    }
}
```

and another called `Fish`

```java
package com.greenfox.zoo;

public class Fish extends Animal {

    public Fish() {
        super(0);
    }
}
```

In each of these classes, we're reusing the code from the Animal class, namely
the number of legs and the corresponding getter method.

### Example: Zoo - Bear, Elephant, Penguin, Shark

Let's add a few actual animals quickly

```java
public class Bear extends Mammal { }
public class Elephant extends Mammal {}
public class Penguin extends Bird {}
public class Shark extends Fish {}
```

### Example: Zoo - Add animals

Now, let's create a `Zoo` class and add these animals to the Zoo.

```java
package com.greenfox.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private final List<Animal> animals;

    public Zoo() {

        animals = new ArrayList<>();
        animals.add(new Bear());
        animals.add(new Elephant());
        animals.add(new Penguin());
        animals.add(new Shark());
    }
}
```

Now, let's do a very quick refactor: The constructor should really be
responsible *only* for creating and initializing the Zoo class, so let's move
adding the animals elsewhere:

```java
public class Zoo {

    private final List<Animal> animals;

    public Zoo() {

        animals = new ArrayList<>();
        addAnimals();
    }

    private void addAnimals(){

        animals.add(new Bear());
        animals.add(new Elephant());
        animals.add(new Penguin());
        animals.add(new Shark());
    }
}
```

One more refactor I'd like to add at this point is to move all the animal
classes into a separate folder (package). So, let's right click on the `zoo`
package, select `new` and create a package called `animals`.

Let's move all the animal classes there. In the project pane I select all
classes by clicking on `Animal`, pressing the `SHIFT` key and then clicking on
`Shark`, then right click as select `Refactor` and `Move Classes...` (or you
can just press `F6` after selecting the classes)

<img src="assets/move-classes.png" style="border: 2px solid grey">

select "Move specified classes to package" and click on the `...` button

<img src="assets/move-classes-2.png" style="border: 2px solid grey">

expand the zoo folder and select the `animals` subfolder

<img src="assets/move-classes-3.png" style="border: 2px solid grey">

Click "OK" and then "Refactor". IntelliJ will not only move the classes to the
new folder (package) but also update all import and other references throughout
the entire project! For example, when we now look at the `Zoo` class we can see
that there is a new import at the top `import com.greenfox.zoo.animals.*;`

### Example: Zoo - Print animals

Now, let's print all animals in our Zoo. Wwe will add the `printAnimals` method
for that:

```java
public class Zoo {

    // ...

    public void printAnimals(){

        for (Animal animal : animals){
            System.out.println(animal);
        }
    }
}
```

Let's go back to the `Demo` class and create a new Zoo object and work with it
from there

```java
package com.greenfox;

import com.greenfox.common.Random;
import com.greenfox.zoo.Zoo;

public class Demo {

    public static void main(String[] args) {

//        Random random = new Random();
//        java.util.Random javaRandom = new java.util.Random();
        demoZoo();
    }

    private static void demoZoo() {

        Zoo zoo = new Zoo();
        zoo.printAnimals();;
    }
}
```

The output from `zoo.printAnimals();` is not very nice

```text
com.greenfox.zoo.animals.Bear@1540e19d
com.greenfox.zoo.animals.Elephant@677327b6
com.greenfox.zoo.animals.Penguin@14ae5a5
com.greenfox.zoo.animals.Shark@7f31245a
```

To change it we could do something like this:

```java
public class Zoo {

    // ...

    public void printAnimals(){

        for (Animal animal : animals){
            System.out.println(animal.getClass().getSimpleName() + " has " + animal.getNumberOfLegs() + " legs" );
        }
    }
}
```

which outputs

```text
Bear has 4 legs
Elephant has 4 legs
Penguin has 2 legs
Shark has 0 legs
```

That is the correct information we like to display, but it is not implemented
in Object-Oriented way/style. It is the responsibility of the Zoo class to
print its list of Animals, but it shouldn't be the responsibility of the Zoo
class to format the animal data for each instance.

Let's say we create another class called `Aquarium`, which would have animals
such as sharks, killer whalers, or dolphins. If we wanted to list information
about all animals in the aquarium, we would have to duplicate the
`printAnimals` method implementation to display the info correctly (ie. not
just class path with the object's hashcode).

Then, if we create a class `Forest` or `Safari` or a `Park`, all of which could
have any number of animals, we have to duplicate the code yet again.

Now, the issue with code duplication is that it is difficult (and costly) to
maintain and to extend. Let's say we do all that, i.e create all these animals
and forests, safari and parks, each with a fully implemented `printAnimals`
method. But then, some time in the future, we'd like to *improve* our Animal
class to include the animal's weight. And, more importantly, we'd like to
display that info using the `printAnimals` method. To implement this simple
change we would have to go and change the `printAnimals` method in each of
those classes (zoo, aquirium, forest, safari, park)

OOP principles say that the Animal class itself should be responsible for
formatting its data/information correctly. So let's add a method `getInfo`

```java
public class Animal {

    // ...

    public String getInfo(){
        return this.getClass().getSimpleName() + " has " + numberOfLegs + " legs";
    }
}
```

and then let's update the `printAnimals` method in the Zoo class

```java
public class Zoo {

    // ...

    public void printAnimals(){

        for (Animal animal : animals){
            System.out.println(animal.getInfo());
        }
    }
}
```

Now, the output is the same

```text
Bear has 4 legs
Elephant has 4 legs
Penguin has 2 legs
Shark has 0 legs
```

but the difference is that should the animal info ever change (e.g. if we want
to display more data), **all** we have to do is to update the `getInfo` method
without the need to change the `printAnimals` method(s) in any way!

#### Question

Here is an interesting question: why does `this.getClass().getSimpleName()` in
in the `Animal.getInfo()` method say "Bear, "Elephant", "Penguin", and "Shark"
instead of just "Animal" in all four cases?

To answer the question we really just need to understand what "inheriting"
means. We can think of a class as a blueprint which specifies variables and
methods. All `public` and `protected` methods and variables (apart from the
constructors) are inherited from the "superclass", which is to say, copied to
the blueprint of the "subclass".

While `getInfo` method is implemented within the `Animal` superclass, that
implementation is "copied" to the `Bear` subclass. Therefore, during the
runtime, when the code is executing the `printAnimals` loop, the `getInfo`
method is actually a copy within the subclass, e.g. the `Bear`. So the `this`
keyword refers not to the Animal class, but the actual subclass which has been
instantiated and added to the `animals` list.

### Example: Zoo - Dolphin

Let's have a quick look at how one may go about changing some of the inherited
behavior. Let's create a class `Doplhin`

```java
public class Dolphin extends Mammal {}
```

and let's add it to the Zoo

```java
public class Zoo {

    // ...
    private void addAnimals(){

        animals.add(new Bear());
        animals.add(new Elephant());
        animals.add(new Penguin());
        animals.add(new Shark());
        animals.add(new Dolphin());
    }
}
```

When we run the demo again we get the following output

```text
Bear has 4 legs
Elephant has 4 legs
Penguin has 2 legs
Shark has 0 legs
Dolphin has 4 legs
```

The output tells us that a dolphin has 4 legs, which is certainly not true
(it has not been for the last ~50 million years). The issue is that the Mammal
class assumes all mammals have 4 legs. Let's fix that by adding a constructor
which accepts the numberOfLegs as a parameter

```java
public class Mammal extends Animal {

    public Mammal() {
        this(4);
    }
    
    public Mammal(int numberOfLegs){
        super(numberOfLegs);
    }
}
```

Now we can fix the `Dolphin` class as

```java
public class Dolphin extends Mammal {

    public Dolphin() {
        super(0);
    }
}
```

The demo output is now correct.

```text
Bear has 4 legs
Elephant has 4 legs
Penguin has 2 legs
Shark has 0 legs
Dolphin has 0 legs
```

#### Question

Let's make another change, i.e. let's change the dolphin info to "Dolphins have
no legs!"

*Question:* How can we do that?

well, this one is pretty easy... we just have to "override" the `getInfo`
method in the Doplhin class.

Let's click in the empty line in the class and press "ALT+ENTER"

<img src="assets/override-method.png" style="border: 2px solid grey">

select "Override Methods..." and then select "getInfo"

<img src="assets/override-method-2.png" style="border: 2px solid grey">

After clicking "OK", IntelliJ adds the `public String getInfo()` with a default
implementation `return super.getInfo();`. Basically, it just calls the
`getInfo()` method of the superclass! You may also notice the `@Override` tag
which is called an "Annotation" but for now (before we get to the Orientation
part of the course) think of it as just a "comment" which is displaying a
message that a method with the same method signature exists in the superclass
and this method here replaces that implementation - this is called **method
overriding**.

To override a method from the superclass a subclass must have a method with the
exact same method signature!

```java
public class Dolphin extends Mammal {

    public Dolphin() {
        super(0);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
```

Let's change the implementation to the one we want:

```java
public class Dolphin extends Mammal {

    public Dolphin() {
        super(0);
    }

    @Override
    public String getInfo() {
        return "Dolphins have no legs!";
    }
}
```

When we run the demo we get the following output:

```text
Bear has 4 legs
Elephant has 4 legs
Penguin has 2 legs
Shark has 0 legs
Dolphins have no legs
```

## Method Overriding

Let's make one more change. Instead of displaying the info as "-animal- has x
legs", let's change it to "-animals- have x legs". So, the change could be
very simple, let's go to the Animal class and adjust the `getInfo` method

```java
public class Animal {

    // ...

    public String getInfo(){
        return this.getClass().getSimpleName() + "s have " + numberOfLegs + " legs";
    }
}
```

Basically, I just added an `s` at the end of the class name and changed the
"has" to "have".

Now, let's create a new class `Mouse`

```java
package com.greenfox.zoo.animals;

public class Mouse extends Mammal {}
```

and let's add a mouse to the Zoo

```java
public class Zoo {

    // ...

    private void addAnimals(){

        animals.add(new Bear());
        animals.add(new Elephant());
        animals.add(new Penguin());
        animals.add(new Shark());
        animals.add(new Dolphin());
        animals.add(new Mouse());
    }
}
```

This was easy! Now let's run the code ... and we get the following output

```text
Bears have 4 legs
Elephants have 4 legs
Penguins have 2 legs
Sharks have 0 legs
Dolphins have no legs
Mouses have 4 legs
```

That's almost perfect ... but the plural of Mouse is not "Mouses" but "Mice".

**Question**: How could we change/fix that.

OOP offers a very easy solution ... first, let's add a method `getNamePlural`
in the Animal class and use that in the `getInfo` method:

```java
public class Animal {

    public String getInfo(){
        return this.getNamePlural() + " have " + numberOfLegs + " legs";
    }
    
    public String getNamePlural(){
        return this.getClass().getSimpleName() + "s";
    }
}
```

This will work for all Animal subclasses with regular plurals, so just as
before we get the same output

```text
Bears have 4 legs
Elephants have 4 legs
Penguins have 2 legs
Sharks have 0 legs
Dolphins have no legs
Mouses have 4 legs
```

Now, all we have to do to fix the plural for the Mouse class is to override the
`getNamePlural` method

```java
public class Mouse extends Mammal {

    @Override
    public String getNamePlural() {
        return "Mice";
    }
}
```

and the Demo output is now fixed

```text
Bears have 4 legs
Elephants have 4 legs
Penguins have 2 legs
Sharks have 0 legs
Dolphins have no legs
Mice have 4 legs
```

## Modifiers

By now you've seen the keyword `public`, for example in the main class of every
project, there is the `public static void main(String[] args)` method.

The keyword `public` is an **access modifier**, which means that it is used to
set a level of access for classes, variables, methods and constructors.

Access modifier can be divided into two groups:
- Access modifiers - control the level of access
- Non-access modifiers - provide additional functionality

### Access Modifiers

Access modifiers for classes
- **public** - the class is accessible by any other class
- *default* - the class is accessible only withinh the same package

Access modifiers for methods and variables
- **public** - the code is accessible by any other class
- **private** - the code is accessible only within the declared class
- *default* - the code is accessible only within the same package
- **protected** - the code is accessible in the same package and in subclasses

### Non-Access Modifiers

Non-access modifiers for classes
- **final** - the class cannot be extends (inherited) buy other classes
- **abstract** - the class cannot in instantiated (it can only be inherited)

Non-access modifiers for methods and variables
- **final** - variables/methods cannot be modified/overriden
- **static** - variables/methods belong to the class, rather than an object
- **abstract** - can be used only in an *abstract* class; the method does not
  have a body; the body (implementation) must be given in the subclass
- **transient** - variables and methods are skipped when serializing the object
- **synchronized** - methods can be accessed only by one thread at a time
- **volatile** - the value of a variable cannot be cached; but be read from the
  main memory

### Usage

Please note that we should **always** make the fields and methods of our
classes as restrictive as possible. For example, in the Animal class, I have
not made the `numberOfLegs` public, nor have I added a (public) setter method
(which would be  `public void setNumberOfLegs(int value)` btw), because there
is no need to change the number of legs an animal has. I did add the getter
because it is reasonable to assume, we will need to access that value at some
point...

Let's make some changes (by adding modifiers to the existing code) to restrict
the use beyond what we indend.

So, let us look at the Animal class in full.

Currently, we can go to the Zoo class and create a new Animal object and add it
to the list of animals:

```java
public class Zoo {

    // ...

    private void addAnimals(){

        animals.add(new Bear());
        animals.add(new Elephant());
        animals.add(new Penguin());
        animals.add(new Shark());
        animals.add(new Dolphin());
        animals.add(new Mouse());
        
        animals.add(new Animal(3));
    }
}
```

But this is not what we intended. We do not give developers (users) who use the
`zoo` and the `zoo.animals` packages the option to create a new instance of
Animal. The Animal class is just a *template*, if you will, with some common
properties (variables and methods) for all animal subclasses. We can use the
`abstract` class modifier to avoid unintended use of `new Animal()`

```java
abstract public class Animal {

    // ...
}
```

After we have added the `abstract` modifier to the Animal class, we get a
compiler error in the Zoo's `addAnimals` method saying that
> Animal is abstract; cannot be instantiated"

Next, we want to tweak the classes Mammal, Bird, and Fish in the same manner:

```java
abstract public class Bird extends Animal {

    public Bird() {
        super(2);
    }
}

abstract public class Fish extends Animal {

    public Fish() {
        super(0);
    }
}

abstract public class Mammal extends Animal {

    public Mammal() {
        this(4);
    }

    public Mammal(int numberOfLegs){
        super(numberOfLegs);
    }
}
```

Great, now it is no longer possible to instantiate these classes (they can be
only inherited).

Furthermore, consider the variable `numberOfLegs` in the Animal class. Once we
create a new object (of some animal type), the number of its legs should never
change.

Therefore, we should declare the variable to be `final`. That way the compiler
will not let us modify the value once it has been set (initialized);

```java
abstract public class Animal {

    private final int numberOfLegs;

    public Animal(int numberOfLegs) {
        
        this.numberOfLegs = numberOfLegs;
        this.numberOfLegs = 2; // << compiler error
    }
    // ...
}
```

Another access I'd like to change the is `getNamePlural` method. The method is
used internally by the `getInfo` method to get the correct plural of an animal
type. There's really no reason to have it `public`. However, we cannot make it
`private` either, because then we wouldn't be able to override it! Apart from
`public` and `private` there is also the `protected` access modifier which
makes methods accessible by subclasses!

```java
abstract public class Animal {

    // ...
    protected String getNamePlural(){
        return this.getClass().getSimpleName() + "s";
    }
}
```

Finally, we should to change the method's signature in the Mouse class as well

```java
public class Mouse extends Mammal {

    @Override
    protected String getNamePlural() {
        return "Mice";
    }
}
```

## Inheritance vs. Composition

In summary, *inheritance* (in Java) is a mechanism through which an object can
acquire the properties (fields) and behavior (methods) of the parent object
(superclass).

Composition is a design technique in which a class can have an instance of
another class as a field (variable).

In object-oriented programming we (can) use *inheritance* when there is an
**"is a"** relationship between a child and its parent class.

For example, mammal **is** an animal, therefore it makes sense for the Mammal
class to extend the Animal class. Bear is a mammal (and an animal) and so it
makes sense that the Bear class extends the Mammal class.

Basically, each subclass (child) **is a** more *specialized* version/example of
the a superclass (parent).

In OOP we (can) use *composition* when there is a **"has a"** relationship
between classes. For example, an Animal has a color, so it would make sense
to add a variable to type `Color` to the Animal class

```java
abstract public class Animal {

    private final int numberOfLegs;
    private final Color color;

    public Animal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
        this.color = Color.BLACK;
    }
```

Obviously, a better use would be to add a color parameter to the constructor
and modify the constructors of animal subclasses to pass the color value all
the way to the Animal, but that's beyond the scope of this section
(composition).


# Polymorphism

Polymorphism means "many forms", and it occurs when we have many classes which
are related to each other by inheritance.

Inheritance lets us inherit attributes and methods from another class.

**Polymorphism** uses those methods to perform different tasks. This allows us
to perform a single action in different ways.

## Example

Let's go back to the Animal class and add a method `move`

```java
abstract public class Animal {

    // ...
    
    public void move(){
        System.out.println("Animal moves");
    }
}
```

then go to the Zoo class and add the `moveAnimals` method

```java
public class Zoo {

    // ...

    public void moveAnimals(){

        for (Animal animal :animals){
            animal.move();
        }
    }
}
```

and let's call the `moveAnimals` method from our Demo class

```java
public class Demo {

    // ...

    private static void demoZoo() {

        Zoo zoo = new Zoo();
//        zoo.printAnimals();;
        zoo.moveAnimals();
    }
}
```

This code produces the following output

```text
Animal moves
Animal moves
Animal moves
Animal moves
Animal moves
Animal moves
```

Now, let's change that so that animals have their own movements:

```java
public class Bear extends Mammal {

    @Override
    public void move() {
        System.out.println("Bear walks");
    }
}

public class Dolphin extends Mammal {

    // ...

    @Override
    public void move() {
        System.out.println("Dolphin swims");
    }
}

public class Elephant extends Mammal {

    @Override
    public void move() {
        System.out.println("Elephant walks");
    }
}

public class Mouse extends Mammal {

    // ...

    @Override
    public void move() {
        System.out.println("Mouse crawls");
    }
}

public class Penguin extends Bird {

    @Override
    public void move() {
        System.out.println("Penguin swims");
    }
}

public class Shark extends Fish {

    @Override
    public void move() {
        System.out.println("Shark swims");
    }
}
```

Now the output of the Demo code is

```text
Bear walks
Elephant walks
Penguin swims
Shark swims
Dolphin swims
Mouse crawls
```

This is polymorphism! We call the `move` method using the `animal.move()` line
of code and the `animal` object takes different forms based on which subclass
it actually represents (and the corresponding `move` from that subclass is
executed). The key is that we do not have to worry about the details of the
implementation in each subclass. All we care about in the `moveAnimals` method
is that each animal (no matter their runtime type) knows how to *move*.

You will see more examples of polymorphism tomorrow when we'll talk about
*Abstract* classes/methods and *Interfaces*

## Advanced Example

Let's extend the `move` functionality a bit by overloading the method and
adding a parameter `fastMode`

```java
abstract public class Animal {

    // ...
    
    public void move(boolean fastMode){
      
        if (fastMode){
            moveFast();
        }
        else {
            move();
        }
    }

    protected void moveFast(){ move(); }
}
```

We've added an option for animals to move fast. If we call `move(false)` then
the object behaves exactly as when calling `move()` without a parameter. If we
set the `fastMode` to `true`, then the `moveFast()` method is called. The
default implementation just kicks us back to the regular `move()`. We
are leaving it to the subclasses to alter this behavior.

Let's do that for all Mammals.

```java
abstract public class Mammal extends Animal {

    @Override
    protected void moveFast() {
        System.out.println( this.getClass().getSimpleName() + " runs");
    }
}
```

Next, let's change the way we move animals in the Zoo class

```java
public class Zoo {

    // ...

    public void moveAnimals(){

        Random random = new Random();
        for (Animal animal : animals){
            animal.move(random.nextBoolean());
        }
    }
}
```

Here we set the fast mode randomly. One possible output is

```text
Bear walks
Elephant walks
Penguin walks or swims
Shark swims
Dolphin runs
Mouse runs
```

eh ... Dolphins don't run ;) ... let's fix that by overriding the `moveFast()`
in the Dolphin class

```java
public class Dolphin extends Mammal {

    // ...

    @Override
    protected void moveFast() {
        move();
    }
}
```

Great! That fixes the issue

```text
Bear walks
Elephant walks
Penguin walks or swims
Shark swims
Dolphin runs
Mouse runs
```

This is a great example of using method overriding ... first we overrode the
the way Mammals move fast and then we overrode that Mammals `moveFast` again in
the Dolphin class!

# Naming

Java naming conventions are a set of guildelines which you as application
developers are expected to follow to produce a consistent and readable code.

In general, Java uses `camelCase` for naming methods and variables and
`TitleCase` for classes and interfaces.

## Packages

Packages must be all lowercase and the convention is to start with the reverse
domain, e.g. `com.greenfox`, or `org.wikipedia` usually followed by the client
name, project name and module name.

## Classes

In Java, class names should be **nouns** and written in `TitleCase`, for
example:
- `ArrayList`
- `Employee`
- `IndexOutOfBoundsException`

## Interfaces

Interface names should be **adjectives** and written in `TitleCase`, for
example:
- `Printable`
- `Moveable`

Interfaces can also be **nouns** when they present a family of classes, for
example:
- `List`
- `Service`
- `Repository`

## Methods

Method names should always be **verbs** describing the action the method does.
Furthermore, methods which return a value should always have names starting
with `get` and methods setting values should always start with `set`, for
example:
- `getAge`
- `setAge`
- `getNumberOfSecondsInYear`
- `setFirstName`

## Variables

All instance, static and method parameter variable names should be in
`camelCase` notation. Do not be shy to write out the full variable name, for
example:
- `numberOfLegs` is better than `num` or `legsNum` etc ...

Temporary variables can be a sinle character, e.g. the counter in the loops
`for (int i = 0; i < 10; i++){}`

## Constants

Java constants should be all `UPPERCASE` where words are separaters by
underscore. The `final` modifier should be used with all constants, for example
- `private final int INITIAL_SIZE = 8;`
- `public static final NUMBER_OF_CARDS = 52;`

## Enums

Similar to class constants, enumeration names should be all uppercase letters:
`enum Direction {NORTH, EAST, SOUTH, WEST}`
