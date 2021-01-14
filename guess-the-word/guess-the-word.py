class Solution(object):
    def findSecretWord(self, wordlist, master):
        """
        :type wordlist: List[Str]
        :type master: Master
        :rtype: None
        """
        wordIndexes = set(range(len(wordlist)))
        while wordIndexes:
            wordIndex = wordIndexes.pop()
            nextGuess = wordlist[wordIndex]
            guessScore = master.guess(nextGuess)
            
            #prune all word indexes of words that dont have the same score with the guessed word
            wordIndexes = {i for i in wordIndexes if self.score(wordlist[i], nextGuess) == guessScore}
    
    def score(self, word1, word2):
        totalScore = 0
        for i in xrange(len(word1)):
            if word1[i] == word2[i]:
                totalScore += 1
        
        return totalScore
