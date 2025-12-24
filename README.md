# CipherSystem
***Not for real security implementations***

Poly-alphabetic Substitution cipher.
IOC around 0.03875

Scramble 52 alphabets(26 AlphabetZeros and 26 AlphabetOnes), Choose between them with a keyword/phrase converted to binary code to perform letter substitutions.

0 in the key substitutes a letter from the zeroArray, 1 in the key substitutes fropm the oneArray.

Repeated values in the binaryKey, shifts the alphabet array of the repeating value. Ex: 00000 = shift the "zero" array N(N is set by user) times after X(X is set by user) repeats of 0.
