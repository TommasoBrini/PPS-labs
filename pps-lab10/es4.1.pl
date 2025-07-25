% seq(N,E,List)--> List is [E,E,...,E] with size N
% example: seq(s(s(s(zero))), a, cons(a,cons(a,cons(a,nil)))).

seq(zero, _, nil).
seq(s(N), E, cons(E, T)) :- seq(N, E, T).

