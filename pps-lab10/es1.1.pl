% search (Elem, List)

search(X, cons(X, _)).
search(X, cons(_, Xs)) :- search(X, Xs).