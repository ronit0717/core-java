## Disease prevention

An infectious disease is spreading in a city. The Mayor of the city wants to take strict action to ensure that the disease is prevented from spreading. 

There are *N* persons in the city who stay side by side in increasing order of their index, that is, the *ith* person has the *(i-1)th* and *(i+1)th* person staying next to him or her.

Initially, it is found that among **N** persons, exactly **M** are infected with the disease. Further, it was found the disease is contagious and it spreads from an infected person to his or her neighbors. It means that if the **ith** person is infected, then the **(i-1)th** person and **(i+1)th** person staying just next to the **ith** person can get infected from him or her.

Also, it is observed that people who are not infected (people apart from initial **M** infected people) get infected in a particular sequence. This sequence provides the order in which people (who are not infected initially) get infected with the increasing span of time. It may be possible that the **xth** person gets infected only after the **yth** person and this defines a particular order among them, that is, **y** must always be placed before **x** in the sequence.

For example, **N=6** and person 3 and 5 are infected. Here, person 2 gets infected before person 1. Similarly, person 2 and 4 can be placed with any relative order as they can get infected from 3 directly.

The Mayor wants you to determine the number of unique sequences in which the other persons can get infected. Since the answer can be large, print it modulo *1000000007* **(10^9 + 7)** .

**Note**: Two sequences are said to be different if there exists at least *one* position among sequences where a person present is different.

**Input format**
* The first line contains two space-separated integers **N** and **M**.
* The next line contains **M** space-separated integers denoting infected people.

**Output format**
Print a single integer denoting the number of unique sequences.

**Constraints**
1 <= N <= ( 2 x (10^5) )
1 <= M <= (N-1)

*Sample Input*

5 2

1 5

*Sample Output*

4

**Explanation**
Person 2 and 4 can get pencils after Person 1 and 5 respectively.
Person 3 can only get pencils after either Person 2 or Person 4 get pencils.

The possible sequences are as follows:
[2,3,4]
[2,4,3]
[4,3,2]
[4,2,3]

Time Limit: 5.0 seconfs for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
