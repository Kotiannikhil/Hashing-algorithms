# Hashing-algorithms

For the description of the project, kindly refer to project1.pdf.

Description of the files and how to run them:

There are 3 java files, one for each type of hashing algorithm.
1. multihashing.java for the multi hashing table
2. cuckoo.java for the cuckoo hash table 
3. dleft.java for the dleft hash table

There are 3 text files, one for each algorithm's output (Note: These text files will be overwritten each time you run the code)
1. multihashing.txt for the multi hashing table
2. cuckoo.txt for the cuckoo hash table 
3. dleft.txt for the dleft table 

There is one README.md file

To run the programs:
1. To compile the java program,write "javac <file_name>.java". For instance, "javac multihashing.java" for the multihashing program.
2. To run the program, write "java <file_name>".  For instance, "java multihashing" for the multihashing program.
3. When you run it, you will be asked to enter the number of flows, the number of table entries and the number of hashes (and the number of steps in case of cuckoo hash table).
4. Once you enter that, the program will execute and the output will be added to a text file (for example: dleft.txt for dleft hash table).
5. The output file contains the number of flows in the hash table.
6. Repeat the above process for all three algorithms.
