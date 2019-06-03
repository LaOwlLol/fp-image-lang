# fp-image-lang v0.2.1

A language and interpreter for the fp-image api.


### Setup:

Clone repo:

```
$ git clone https://github.com/LaOwlLol/fp-image-lang.git
```

Generate antlr parser:

```
$ ./gradlew generateGrammarSource
```

If you plan to modify the grammar and interpreter you may find the clean up task useful.  It will remove all the generated parser files

```
$ ./gradlew clean
```

### Scripting:

This language exists to provide a framework for repeating image manipulations (Filters and Mixers in the fp-image API).  An fp-image-lang script is like a line by line image processing pipeline.

#### Image paths and variable assignment:

A script can define variables by assigning an image file path literal (or an expression) to a variable identifier. 

```java
image = /home/user/test.png
```

Image paths must end in a image file extension '.png', '.bmp', '.jpeg', or '.jpg'.

Both unix and windows style root paths are valid ("\<DriveLetter\>:/", "./" or "/"). Paths must be in the system agnostic single '/' java style (as seen in example above). 

#### For each image in Directory:

fp-image-lang supports special for each looping mechanism for processing every image in a file system directory.  Like many languages the identifier following the 'for' keyword will take the value of the current iterator.  The interpreter maintains a counter internally and will append the current counter value to any write command paths so that each iteration (and therefore each image process) will have a unique output file path.  

That is all to say the following script:

```java
    for i in /home/user/myphotos/ {
        /home/user/myphotos/out/filtered.png << chromaKey(i, 29, 145, 74, .06)
    }
```

results in each image in the user's myphotos directory having the green colored pixels transformed into transparent pixels (chromaKey operation) and out put to a new image 'filtered_<n>.png'. 

#### Write to file:

The double chevron symbol ("<<") is a binary operator which is interpreted aa a write command. The left operand is the output file path (out side a for each loop there will be no "_<n>" appended).  Right operand is an expression resulting in an image.



There are a variety of binary operations and operation method calls. 

```java
// Binary operations:
i = img1 + img2                                     //Combine color values by component wise addition for each pixel.
i = img1 - img2                                     //Blend color values by component wise (c1-c2)/2 for each pixel.
i = img1 * img2                                     //Reflect color values by component wise multiplication for each pixel

// Operation method calls.
sobel( image , float (, bool (, bool)? )? )         //Edge Detection.  Args: target, threshold, preserveSaturation, manhattanDistance
canny( image , float , float  )                     //Edge Detection. Args: target, lowerthreshold, upperthreshold
chromaKey( image , int , int , int, float )         //Filter specific color to transparency. Args: target, red, green, blue, deltaThreshold  
gaussianBlur( image , int , float )                 //Blur. Args: target, convolutionSize, standardDeviation
grayScale( image (, int, int, int )? )              //Gray scale Args: target, red, green, blue.
redist( image , float )                             //Redistrubute color values (like dodge/burn) Args: target, power
translucent( image )                                //Pixel intensity becomes alpha value.
```

#### boolean values:

The syntax for boolean values is '#true' or '#false'.

### Interactive Test Environment ITE:

As a temporary way to run the interpreter for tests the entry point for the project is a JavaFx Application with basic script selection and execute controls, as well as an ImageView for results.

Output operations are not intended to affect the ImageView When the script completes the interpreter will return the final result, which may or may not reflect the last image manipulation performed, and that image will be set as the active image for the main ImageView.  You should rely on the write command (see above) to output files for results you'd like to save.

Again the ITE is just a stop gap to run scripts. You may use the fp.image.lang.Interpreter and it's interp(String script) method in any application you'd like.


### More to come:

Thanks for reading, and I hope you find this project interesting.  I have a lot more ideas to come (and some changes likely).  Feel free to contact me with suggestions and keep an eye on the prjects sections of my github.io (https://laowllol.github.io/) where i hope to have a more through write up and demo (with pictures) of how I use this project.