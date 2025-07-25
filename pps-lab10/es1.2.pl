% search2(Elem, List)
% Search for two consecutive occurrences of Elem

search2(X, cons(X, cons(X, _))).
search2(X, cons(_, Xs)) :- search2(X, Xs).