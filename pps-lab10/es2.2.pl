%Peano Sum
sum(X, zero, X).
sum(X, s(Y), s(Z)) :- sum(X, Y, Z).

sum_list(nil, zero).
sum_list(cons(N, T), NS) :- sum_list(T, S), sum(N, S, NS).