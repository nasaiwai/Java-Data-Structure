Program: ListFiles

This program lists the names and sizes of all "normal files" from a given set of directories. 
(A normal file is a file that is not a directory.) 

 Here is an example use of ListFiles when it is given a single directory (in this case, for an album): 

$ java ListFiles "${HOME}/Music/iTunes/iTunes Media/Music/Fiona Apple/Tidal"
     8688885  01 Sleep to Dream.m4a
     8320056  02 Sullen Girl.m4a
    11405829  03 Shadowboxer.m4a
    12716967  04 Criminal.m4a
    13402000  05 Slow Like Honey.m4a
    10277362  06 The First Taste.m4a
    12268338  07 Never Is a Promise.m4a
     9060294  08 The Child Is Gone.m4a
    12189510  09 Pale September.m4a
    12311889  10 Carrion.m4a

The above shows two columns: The first is the size of each file in bytes, and the second is the name of the file. (In this case, the names of the files just happen to begin with a track number and a space.) 


Sorting By Name:

By default, the files within each directory should be sorted by name, consistent with the behavior of the String.compareTo method.


Sorting By Size First, Then Name:

Your ListFiles command must accept a special -size flag, which you can assume will always be the first element in the args array whenever it is used. When -size is present, the files will be listed from largest to smallest. When two files have the same size, their ordering is then determined by-name, as before. 


Gathering All Results:

Finally, your ListFiles command must accept an additional flag, -gather, that causes the sorting to be applied once, over all files from all of the directories given. (When -gather is not specified then each directory is sorted independently, as observed from the examples below.)

When -gather is specified, it will be either the first or the second element of the args array, depending on if the -size flag was also used or not. The -gather operation must work as expected in both cases.  
