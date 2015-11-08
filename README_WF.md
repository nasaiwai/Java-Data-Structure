Program: Word Frequency

This processes text files and produce text output. 
Specifically, the WordFrequency program counts how many times each word from the input appears, and then outputs a sequence of word/count pairs.
 Here, a "word" is any token of a text file composed of only letters (plus the apostrophe). For example, the following input:

$ cat the-way-things-are.txt 
I'm much better off, the way things are
Much much better off, better by far

 could be provided as input to the program (along with a flag) to produce: 

$ java WordFrequency --by-freq the-way-things-are.txt 
            better: 3
              much: 3
               off: 2
               are: 1
                by: 1
               far: 1
               i'm: 1
               the: 1
            things: 1
               way: 1

 There are three different orderings that WordFrequency can output, as should be documented by the program itself when it is run with no command-line arguments:


$ java WordFrequency
Error: Mode and filename expected.
Usage: java WordFrequency <MODE> [--threshold=NUM] <TEXTFILE>
Utility to count the occurrences of each word in a text file.
MODE is one of:
  --by-freq  sort by frequency count, from highest to lowest
  --by-word  sort by words, alphabetically
  --by-orig  show words in order of first appearance



