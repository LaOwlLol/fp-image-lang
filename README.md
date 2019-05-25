# fp-image-lang

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

At this time the interpreter can assign and evaluate image variables with assignment statements, or execute expressions on image variables and image paths.

```java
image = /home/user/test.png
```

Image paths must end in a image file extension '.png', '.bmp', '.jpeg', or '.jpg'.

Both unix and windows style root paths are valid ("\<DriveLetter\>:/" or "/"), './' can also be used.

Paths must be in the system agnostic single '/' java style meaning don't use '//' or other style between directory names.

There are a variety of binary operations and operation method calls. 

```java
// Binary operations:
i = img1 + img2                                     //Combine color values by component wise addition for each pixel.
i = img1 - img2                                     //Blend color values by component wise (c1-c2)/2 for each pixel.
i = img1 * img2                                     //Reflect color values by component wise multiplication for each pixel

// Operation method calls.
sobel( image , float )                              //Edge Detection.  Args: target, threshold
canny( image , float , float  )                     //Edge Detection. Args: target, lowerthreshold, upperthreshold
chromaKey( image , int , int , int, float )         //Filter specific color to transparency. Args: target, red, blue, green, deltaThreshold  
gaussianBlur( image , int , float )                 //Blur. Args: target, convolutionSize, standardDeviation
grayScale( image )                                  //Gray scale.
redist( image , float )                             //Redistrubute color values (like dodge/burn) Args: target, power
translucent( image )                                //Pixel intensity becomes alpha value.
```

### Interactive Test Environment ITE:

As a temporary way to run the interpreter for tests the entry point for the project is a JavaFx Application with basic script selection and execute controls, as well as an ImageView for results.

Since there is no output operation in the languages the results of the last assignment in a script is stored and displayed.

This is a temporary hack, and a write to file operation will be added to upcoming versions.