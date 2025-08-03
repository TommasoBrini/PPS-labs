% distinct(List, DistintList)
% DistinctList contains all distinct elements from List.

distinct([], []).
distinct([H|T], L) :- member(H, T), distinct(T, L).
distinct([H|T], [H|R]) :- \+ member(H, T), distinct(T, R).
