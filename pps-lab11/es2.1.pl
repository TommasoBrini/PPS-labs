% dropAny(?Elem, ?List, ?OutList)
dropAny(X, [X|T], T).
dropAny(X, [H|Xs], [H|L]) :- dropAny(X, Xs, L). 