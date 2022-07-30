# MessageDecoder

Professor Potter, a punning pedantic, practices puzzling her students. She has left a secret message, of unknown length, encoded in a file for you to unravel. The setup is simple: each line of the file contains one char and one non-negative integer. The key to reading the message is organizing the characters in the proper order. The integer indicates the position of the character within the message.

For example:

e 2
b 1
a 3
h 5
c 4
spells 'beach' when unraveled.

Write a program that will:
Ask the user for the name of a file
Check to see that the file exists and contains some data.
Open and read this file exactly once
Using your MessageDecoder class, unravel and display the message
Offer to do it again on another file
Required classes:
You will create and submit 2 classes:

MessageDecoder class:

Responsible for converting a scrambled message file into plain text.
Contains a public method getPlainTextMessage() that returns the String object.
The scrambled file must be scanned only once and must be scanned inside this class.
Must utilize the linked list data structure to accomplish the decoding work. (See Lab 4 & Lab 5)
Does not call any methods of SecretMessage class
SecretMessage class:

Contains the main() method
All of printing to console must be done in this class
All of user input from the keyboard must be performed in this class
Uses the public methods of your MessageDecoder class to accomplish the decoding.
