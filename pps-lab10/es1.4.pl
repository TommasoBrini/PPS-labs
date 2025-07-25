% search_anytwo(Elem, List)
% looks for any Elem that occurs two times, anywhere

search(X, cons(X, _)).
search(X, cons(_, Xs)) :- search(X, Xs).

search_anytwo(E, cons(E, T)) :- search(E, T).
search_anytwo(E, cons(_, T)) :- search_anytwo(E, T).
