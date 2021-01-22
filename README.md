# Renteapp

An interactive application to calculate savings and compounding interest. Adjusting the sliders allows you to change the amount of € that you want to save each month, and the interest rate on your accumulated savings. From the graph you can interpret what your savings would be either with interest and without interest. You can readjust the sliders to your likings at any time and the graph will recalculate the amounts.

## Tech

*Used:* IntelliJ, JavaFX, Maven, Java 11

![Renteapp](https://i.imgur.com/Q4a6u3C.png)




The easiest way to run Renteapp, and to avoid any missing JavaFx depencies, is setting up a simple project in IntelliJ

File -> new -> project -> click on Maven -> check box create from archetype ->  add Archetype 

fill in

 GroupId:    
 > org.openjfx

ArtficatId: 
> javafx-archetype-simple

Version:   
> 0.0.3

press next -> next -> finish

Now copy code in Renteapp.java to App.java located in your project. Make sure you change the package name on line 1 to the corresponding package and change classname on line 17 and 19. Now you can run the application.



- [x] @mentions, #refs, [links](), **formatting**, and <del>tags</del> supported
- [x] list syntax required (any unordered or ordered list supported)
- [x] this is a complete item
- [ ] this is an incomplete item
