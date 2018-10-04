#!/usr/bin/env python2.7

import unittest
from dnaseqlib import *

### Utility classes ###

# Maps integer keys to a set of arbitrary values.
class Multidict:
    # Initializes a new multi-value dictionary, and adds any key-value
    # 2-tuples in the iterable sequence pairs to the data structure.
    def __init__(self, pairs=[]):
        self.store={}
        for pair in pairs:
          if(self.store.get(pair[0]) is None):
            self.store[pair[0]]=[pair[1]]
          else:
            self.store[pair[0]].append(pair[1])
        
    # Associates the value v with the key k.
    def put(self, k, v):
        if(self.store.get(k) is None):
          self.store[k]=[v]
        else:
          self.store[k].append(v)
    # Gets any values that have been associated with the key k; or, if
    # none have been, returns an empty sequence.
    def get(self, k):
      result=self.store.get(k)
      if(result is None):
        return []
      return result

# Given a sequence of nucleotides, return all k-length subsequences
# and their hashes.  (What else do you need to know about each
# subsequence?)
def subsequenceHashes(seq, k):
    assert(k>0)
    n=0
    currentStr='a'
    hashItem=None
    for i in seq:
      if(n<k-1): 
        currentStr+=i  
        n+=1
        if(n==k-1):
          hashItem=RollingHash(currentStr)
      else:
        hashItem.slide(currentStr[0],i)
        currentStr=currentStr[1:]+i
        yield hashItem.curhash,n-k+1,currentStr
        n+=1

#for s in subsequenceHashes('123456789123456789',3):
#  print(str(s[0])+'  '+str(s[1])+'  '+s[2])

    
# Similar to subsequenceHashes(), but returns one k-length subsequence
# every m nucleotides.  (This will be useful when you try to use two
# whole data files.)
def intervalSubsequenceHashes(seq, k, m):
    assert(k>0)
    n=0
    pos=0
    currentStr=''
    for c in seq:
      if(n<k):
        currentStr+=c
      n+=1
      if(n==m):
        yield RollingHash(currentStr).curhash,pos,currentStr
        currentStr=''
        pos+=m
        n=0
    if(n>=k): yield RollingHash(currentStr).curhash,pos,currentStr
#for s in intervalSubsequenceHashes('123456789123456789',3,5):
#  print(str(s[0])+'  '+str(s[1])+'  '+s[2])


# Searches for commonalities between sequences a and b by comparing
# subsequences of length k.  The sequences a and b should be iterators
# that return nucleotides.  The table is built by computing one hash
# every m nucleotides (for m >= k).
def getExactSubmatches(a, b, k, m):
    print('Building dict begin')  
    akey_value=Multidict()
    for gum in intervalSubsequenceHashes(a,k,m):
      akey_value.put(gum[0],(gum[2],gum[1]))
    print('Buliing Finish!')
    for bGum in intervalSubsequenceHashes(b,k,m):
      possible_matchs=akey_value.get(bGum[0])
      for aStr,aPos in possible_matchs:
        if(bGum[2]==aStr): yield aPos,bGum[1]
    print('Match Finish!')
    
#for i in getExactSubmatches('fsf123fdfg','qwezz123123123',3,0):
#    print(i)

if __name__ == '__main__':
    if len(sys.argv) != 4:
        print ('Usage: {0} [file_a.fa] [file_b.fa] [output.png]'.format(sys.argv[0]))
        sys.exit(1)

    # The arguments are, in order: 1) Your getExactSubmatches
    # function, 2) the filename to which the image should be written,
    # 3) a tuple giving the width and height of the image, 4) the
    # filename of sequence A, 5) the filename of sequence B, 6) k, the
    # subsequence size, and 7) m, the sampling interval for sequence
    # A.
    compareSequences(getExactSubmatches, sys.argv[3], (500,500), sys.argv[1], sys.argv[2], 8, 100)
