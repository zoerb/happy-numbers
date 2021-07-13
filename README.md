# "Happy numbers" exercise

Given a number *n = n<sub>0</sub>*, define a sequence where *n<sub>i+1</sub>* is the sum of the squares of the digits of *n<sub>i</sub>*. Then *n* is happy if and only if there exists an *i* such that *n<sub>i</sub> = 1*.

For example, 19 is happy, as the associated sequence is:  
1<sup>2</sup> + 9<sup>2</sup> = 82  
8<sup>2</sup> + 2<sup>2</sup> = 68  
6<sup>2</sup> + 8<sup>2</sup> = 100  
1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1

When passed a number between 1 and 1000 as an argument, the program should identify whether this is a happy number. If passed no parameters, the program should return a list of all happy numbers between 1 and 1000.
