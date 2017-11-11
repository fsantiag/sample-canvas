
# Sample Canvas

This is a simple canvas command line tool made in Java.

##1. Building
In order to build:

```./graglew build```

##2. Running the app
```./graglew run```

OR

in the *build/libs* folder:

```java -jar sample-canvas-1.0-SNAPSHOT.jar ```

##3. Running the tests
```./graglew test```

## Usage
In order to use the Sample Canvas, just type on terminal the desired command.
Sample Canvas is not case sensitive.


Commands:
```
C 10 30    // create a canvas 10x30
L 3 5 3 8  // create a line from point (3,5) to (3,8)
R 3 5 5 10 // create a rectangle from point (3,5) to (5,10)
B 7 6 c    // Bucket fill the canvas starting on point (7,6) with color 'c'
Q          // quit the sample canvas
```

## License

Sample Canvas is an open source project under the [MIT License](https://opensource.org/licenses/MIT).