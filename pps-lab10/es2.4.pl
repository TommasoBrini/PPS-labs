% max(List, Max)
% Max is the biggest element in List
% suppose the list has at least one element
greater(s(_), zero).
greater(s(N), s(M)) :- greater(N, M).

greater_equals(N, zero).
greater_equals(s(N), s(M)) :- greater_equals(N, M).

max(cons(H, T), Max) :- max(T, H, Max).
max(nil, Max, Max).
max(cons(E, L), Temp, M) :- greater(E, Temp), max(L, E, M).
max(cons(E, L), Temp, M) :- greater_equals(Temp, E), max(L, Temp, M).