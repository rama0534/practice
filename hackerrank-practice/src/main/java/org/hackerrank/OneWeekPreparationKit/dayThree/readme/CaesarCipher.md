# Caesar Cipher
Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. 
If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
````
Original alphabet:   abcdefghijkl
Alphabet rotated +3: defghijklmno
````
#### Example
`s = There's-a-starman-waiting-in-the-sky`
`k = 3`
The alphabet is rotated by 3, matching the mapping above. The encrypted string is
`Wkhuh'v-d-vwdupdq-zdlwlqj-1q-wkh-vnb.`
Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
#### Function Description
Complete the caesar Cipher function in the editor below.
caesar Cipher has the following parameter(s):
- strings: cleartext
- int k: the alphabet rotation factor
#### Returns
- string: the encrypted string
#### Input Format
- The first line contains the integer, in, the length of the unencrypted string.
- The second line contains the unencrypted string, s.
- The third line contains k, the number of letters to rotate the alphabet by.
#### Constraints
````
1 < n ≤ 100
0 ≤ k ≤ 100
s is a valid ASClI string without any spaces.
````
#### Sample Input
````
11
middle-Outz
2
````
#### Sample Output
``` okffng-Qwvb ```

#### Explanation
````
Original alphabet:    abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:  cdefghijklmnopqrstuvwxyzab
m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
- -> -
o -> Q
u -> W
t -> V
z -> b

````
[Link](https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-three
)