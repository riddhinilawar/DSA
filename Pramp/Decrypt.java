function decrypt(word):
    secondStep = 1
    decryption = ""

    for i from 0 to word.length - 1:
        newLetterAscii = asciiValue(word[i])
        newLetterAscii = newLetterAscii - secondStep

        while (newLetterAscii < asciiValue('a')):
            newLetterAscii += 26
         
        decryption = decryption + asciiToChar(newLetterAscii)
        secondStep += newLetterAscii

    return decryption
