# Project 1: DFA Design

* Author: Patrick Santana, Austin Nelson
* Class: CS361 Section #002
* Semester: Fall 2022

## Overview

A program in which simulates a Deterministic Finite Automata machine, given a 
specific formatted input file. Given a certain definition about a machine,
the program is able to read in an input string and decide whether or not 
the string is valid. 

## Reflection

Getting the class structure setup was quite simple and really didn't take 
much troubleshooting at all. It was nice to have the inputs already handled for 
us as usually there is some debugging that comes along with that but since it 
was already done, it sped the process up by a lot. It was a bit of a struggle
at first to understand how to implement the map with the transition functions
but after drawing it out and brainstorming, it become much more clear. There isn't
any concept in particular that we are still confused about; something we discovered
later on is we could remove our final states set and still have our program work as 
we figured out a more efficient way to handle the final states (with some null pointers). 

There wasn't a ton of code that was needed for this project, so we used print lines when we 
would implement a different feature just as a sanity check on what we were doing was valid.
Another thing that worked well for debugging was we setup our toString() method early on so 
that when we would implement the transition method, it was much easier to see if what we were
doing was correct. Something we agreed on was a little difficult about the design process
was working with one other partner for this project as splitting up the work was difficult
so we used a lot of communication on what features we were working indiviually. This wasn't
anything drastic but we would probably figure out a better way to work on the project together
next time. If we could go back in time, we would have defintely started earlier as some unexpected
circumstances came up that made it a little more stressful. But besides that, we felt everything went 
pretty smoothly. 

## Compiling and Using

Compiling:

$javac fa/dfa/*.java

To Run:

$java fa/dfa/DFADriver.java <Input file name>

Input File Structure:
First line - names of the final states
Second line - name of the start state
Third line - Any other DFA states
Fourth line - consists of the transitions inputted as three characters followed by a space (EX: 'a1b')
Fifth line on - strings for the machine to test if valid 

## Sources used
