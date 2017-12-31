% APIT - Laboratory Session 2
% Dr. Simon Rogers

# Introduction and Aims

Some more recap work. You'll get a chance to play around with how Java passes primitives, objects, and object references around. Please also use this time to familiarise yourselves with Git if you wish.

# Tasks

- Download Code.zip from the course Moodle page (it's inside the topic 1 page). Compile and run the `CallExamples.java` class (it's in the `CallByReference` folder). Are any of the outputs unexpected? If so, refer to the notes and try and work out why it does what it does!
- `CallExamples.java` uses *inner classes* (also known as *nested* classes). These are classes defined inside another class. In this example, they are declared `static`. Why? What happens if you remove the `static` keyword? Why?
- Assertions: Write a class defining a circle that takes as its input a radius (of type Double) and has a method that computes the area of the circle. Use an assertion to check that the radius provided is positive. Create another class that uses `Circle` objects and try creating them with both positive and negative radius, with assertions switched on and switched off.
- Comment your `Circle` class in the manner accepted by JavaDoc and compile a JavaDoc page for the class (instructions in slides)