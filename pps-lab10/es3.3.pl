% sublist(List1,List2)
% List1 should contain elements all also in List2
search(X, cons(X, _)).
search(X, cons(_, Xs)) :- search(X, Xs).

sublist(nil, _).
sublist(cons(H, T), L2) :- search(H, L2), sublist(T, L2).
