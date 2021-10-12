# JavaProject

This is a Java Project for the QuickSort algorithm. 
In order to run it in IDEA, you need to download (checkout) 
it from this directory and open it in any Java IDEA (preferably IntelliJ IDEA).

When you open the project in IDEA you need to mark this project as 
a "Maven project". If you are using IntelliJ IDEA it would do it for 
you by clicking "Trust this project". You need to make sure you are 
connected to the Internet because Maven uses it. Then you can run it 
and see how it works.

The first thing you will notice is a message 'Please enter absolute 
file path on your own computer for file for what you want to proceed:'. 
Enter file path for it. If the file is not found it will give you 
a message that an error occurred and ask if you want to try to input again? 
If no type n or no, otherwise enter anything else.

If you typed a valid filePath, the program begins to read the file. 
If the data in the file is not valid (missing some elements or using 
the wrong data type), the program will print you the reason for 
invalid data + ask you if you want to drop the value or stop the program 
to make changes to the file and try again.

In the end, it prints you itemNumbers of each valid element in sorted form. 
If you also want all attributes to be printed, uncomment 2 functions call 
printArrayItem(list) in main;

There is 2 testing files under project directory. 
First: JavaProject/src/main/java/Items.csv
Contains 1 header + 7 record (2 invalid: one missing value, 1 data type mismatch)
Second: JavaProject/src/main/java/Items2.csv
Contains 1 header + 15 records (all valid)