# JavaProject

This is a Java Project for QuickSort algorithm.
In order to run it in IDEA you need to download (checkout) 
it from this directory and open it in any Java IDEA (preferably IntelliJ IDEA).

When you open the project in IDEA you need to mark this project as a "Maven project". 
If you are using IntelliJ IDEA it would do it for you by clicking "Trust this project".
You need to make sure you are connected to the Internet because Maven use it.
Then you can run it and see how it works.

First thing you will notice a message 'Please enter absolute file path 
on your own computer for file for what you want to proceed:'. Enter filepath for it. 
If file not found it will give you a message that error occurred and ask if you want to try 
to input again? If no type n or no, otherwise enter anything else.

If you typed a valid filePath, the program begin to read the file. If the data in file 
is not valid (missing some elements or using wrong data type), the program will print you 
the reason of invalid data + ask you if you want to drop the value or stop the program to 
make changes to file and try again.

At the end it prints you itemNumbers of each valid element in sorted form. If you also
want all attributes to be printed, uncomment 2 functions call printArrayItem(list) in main;