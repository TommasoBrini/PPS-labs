a(1).
a(X) :- b(X), b(X).
b(1).
b(2).
c(X) :- b(X).
c(X) :- b(X), c(X).