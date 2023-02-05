# interview-questions
My implementation of interview questions

# Question: Airplane Seat Selector

## Write a program that seats passengers in an airplane according to the following rules:
1- Seat passengers starting from the front row to the back, left to the right.

2- Fill aisle seats, then window seats, then center seats.

## Example:

### Input: 

Seats: [[3,2], [4,3], [2,3], [3,4]]

(first block of seats on the left has 3 columns and 2 rows, second block to the right of it has 
4 columns and 3 rows, etc.

Passengers total: 30

### Output: 

\* means empty seat

```
[19][25][1]  [2][26][27][3]  [4][5]    [6][28][20]

[21][29][7]  [8][30][*][9]   [10][11]  [12][*][22]

             [13][*][*][14]  [15][16]  [17][*][23]
             
                                       [18][*][24]
```
