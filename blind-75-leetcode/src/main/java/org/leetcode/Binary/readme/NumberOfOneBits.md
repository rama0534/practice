# [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
Given a positive integer `n`, write a function that returns the number of set bits (A set bit refers to a bit in the binary representation of a number that has a value of `1`) in its binary representation (also known as the [Hamming weight](https://en.wikipedia.org/wiki/Hamming_weight)).

#### Example 1:
- **Input:** `n = 11`
- **Output:** `3`
- Explanation: The input binary string `1011` has a total of three set bits.

#### Example 2:
- **Input:** n = 128
- **Output:** 1
- **Explanation:** The input binary string `10000000` has a total of one set bit.

#### Example 3:
- **Input:** `n = 2147483645`
- **Output:** `30`
- **Explanation:** The input binary string `1111111111111111111111111111101` has a total of thirty set bits.

#### Constraints:
`1 <= n <= 231 - 1`