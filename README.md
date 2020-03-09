Coding Assignment for Delta Exchange

Q. Give a large text file(~> 10Mb), write a program to count the number of words in the file.
Use any programming language of your choice.
Benchmark various solutions and send the result along with the github link to the code.
Please do write a readme on running the program.


Solution:
As a java developer,my first instinct was to solve this problem using Java/ multiThreading. Initially i thought of assigning each line to new thread to compute the work, but as it turned out with large files (> 1,000,000 lines of code) it was inefficient to work with this many threads as context switch is time taking between threads. Yes, multithreading increases efficiency by utilising CPU but using large no. of  threads decreases it due to context switching which is time taking, so it finally boiled down to finding a value of n, where n is no of threads, in order to maximize efficiency of my code.
So i created a dynamic java program in which we can set the value of n, as the efficiency may differ on different system with different values of n, following were the results when the code was tested against a File( size - 100MB, no. of lines - 1128024, no. of words - 13302638) and following were the results,


My System Specification - 
cores = 2
logical processor = 4

Result - 
Number of Threads: 1
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 1128024
Number of words in the file: 13302638
time required to execute in sec = 6.239s


Number of Threads: 2
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 564012
Number of words in the file: 13302638
time required to execute in sec = 4.309s



Number of Threads: 3
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 376008
Number of words in the file: 13302638
time required to execute in sec = 3.799s



Number of Threads: 4
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 282006
Number of words in the file: 13302638
time required to execute in sec = 4.133s



Number of Threads: 5
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 225604
Number of words in the file: 13302638
time required to execute in sec = 4.299s


Number of Threads: 6
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 188004
Number of words in the file: 13302638
time required to execute in sec = 4.563s



Number of Threads: 7
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 161146
Number of words in the file: 13302638
time required to execute in sec = 4.888s


Number of Threads: 8
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 141003
Number of words in the file: 13302638
time required to execute in sec = 5.176s


Number of Threads: 9
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 125336
Number of words in the file: 13302638
time required to execute in sec = 5.101s


Number of Threads: 10
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 112802
Number of words in the file: 13302638
time required to execute in sec = 5.273s


Number of Threads: 100
Number of lines in the file: 1128024
Approx No. of lines to be process by each thread: 11280
Number of words in the file: 13302638
time required to execute in sec = 25.469s
