% search_two(Elem, list)
% looks for two occurrences of Elem with any element in between

search_two(E, [E, _, E | _]).
search_two(E, [_|T]) :- search_two(E, T).


