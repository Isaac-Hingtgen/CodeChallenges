
# This problem was asked by Microsoft.

# You have n fair coins and you flip them all at the same time. Any that come up tails you set aside. 
# The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains?

# Write a function that, given n, returns the number of rounds you'd expect to play until one coin remains.
import random as Random

def numberOfRounds(coins):
    rounds = 0
    extraCoin = False
    while(coins > 1):
        if(coins % 2 == 1):
            if(extraCoin):
                coins += 1
            else:
                coins -= 1
            extraCoin = not extraCoin
        coins /= 2
        rounds += 1
    if(extraCoin):
        rounds = rounds if Random.random() < 0.5 else rounds + 1
    return rounds

print("number of rounds:", numberOfRounds(49843454132))

        
