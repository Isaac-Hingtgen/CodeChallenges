# cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

# Given this implementation of cons:

# def cons(a, b):
#     def pair(f):
#         return f(a, b)
#     return pair

# Implement car and cdr.


def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair


def F(a,b):
    return [a, b]

def car(con):
    arr = con(F)
    print(arr[0], "\n")

def cdr(con):
    arr = con(F)
    print(arr[1], "\n")
    


car(cons(1, 4))
cdr(cons(3, 8))
