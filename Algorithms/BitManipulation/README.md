# Bitwise Operations

## Get 
Get a bit from a certain position. We create a mask such as 00001000 with the 1 in the target position and
AND (&) the num with the mask. The method returns 1 if it's different from 0.

 ```
 boolean getBit(int num, int pos){
      int mask = 1 << pos;
      return (num & mask) != 0;
 }
 ```
 Assuming just 8 bits and pos = 3, in the first line we would get:
 ```
 By shiftting right: 00000000 --> 00001000;
 ```
 and if num = 00100101, the bit in the position 3 is 0:
 ```
 00100101
 &
 00001000
 --------
 00000000
 ```
 
 
 ## Set
 Set a bit into a certain position. We perform an OR with me mask
 
 ```
 boolean setBit(int num, int pos){
      int mask = 1 << pos;
      return num | mask;
 }
 ```
