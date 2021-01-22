# Renteapp

An interactive application to calculate savings and compounding interest. Adjusting the sliders allows you to change the amount of € that you want to save each month, and the interest rate on your accumulated savings. From the graph you can interpret what your savings would be either with interest and without interest. You can readjust the sliders to your likings at any time and the graph will recalculate the amounts.

## Tech

*Used:* IntelliJ, JavaFX, Maven, Java 11

*Screenshot*

![Renteapp](https://i.imgur.com/Q4a6u3C.png)


## Set-up

The easiest way to run Renteapp, and to avoid any bothersome missing JavaFX depency errors, is setting up a simple Maven project in IntelliJ. 

File -> new -> project -> click on Maven -> check box create from archetype ->  add Archetype 

*Now fill in the following:*

 GroupId:    
 > org.openjfx

ArtficatId: 
> javafx-archetype-simple

Version:   
> 0.0.3

press next -> next -> finish

Now copy code in Renteapp.java to App.java located in your project. Make sure you change the package name on line 1 to the corresponding package and change classname on line 17 and 19. You can now run the application.
