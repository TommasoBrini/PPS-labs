% count_occurrences(Element, List, Count)
% count is the number of times Element appears in List.

count_occurrences(_, [], 0).
count_occurrences(E, [E|T], N) :- count_occurrences(E, T, M), N is M + 1, !.
count_occurrences(E, [_|T], N) :- count_occurrences(E, T, N).
