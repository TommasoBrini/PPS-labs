% sum(List, Sum)
sum([], 0).
sum([H|T], S) :- sum(T, N), S is N + H.