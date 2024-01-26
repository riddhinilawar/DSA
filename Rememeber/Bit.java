//Find the rightmost differentiating bit number:
int number = (xr & ~(xr - 1)); 
int number = (xr & -xr);

//for getting bit reprentation of any integer:
Integer.toBinaryString(seen)

//to convert negative decimal to binary
ex:6
get binary representation:00000000000000000000000000000110(first bit respresent its positive else all 31 bits represents its value)
get 1's compliment:11111111111111111111111111111001
                                                  1
                   ================================
                   11111111111111111111111111111010
get 2's compliment(means adding 1 in 1's compliment):11111111111111111111111111111010(first bit respresent its negative else all 31 bits represents its value)
