% search_two(Elem, List)
% looks for two occurrences of Elem with any element in between

search_two(X, cons(X, cons(_, cons(X, _)))).
search_two(X, cons(_, Xs)) :- search_two(X, Xs).
