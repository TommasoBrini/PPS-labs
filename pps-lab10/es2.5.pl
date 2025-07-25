% min-max(List,Min,Max)
% Min is the smallest element in List
% Max is the biggest element in List
% Suppose the list has at least one element
greater(s(_), zero).
greater(s(N), s(M)) :- greater(N, M).

min-max(cons(E, T), Min, Max) :- min-max(T, E, E, Min, Max).
min-max(nil, MIN, MAX, MIN, MAX).
min-max(cons(E, T), TMin, TMax, Min, Max) :- greater(E, TMax), min-max(T, TMin, E, Min, Max).
min-max(cons(E, T), TMin, TMax, Min, Max) :- greater(TMin, E), min-max(T, E, TMax, Min, Max).
min-max(cons(E, T), TMin, TMax, Min, Max) :- greater(TMax, E), greater(E, TMin), min-max(T, TMin, TMax, Min, Max).
