% search2(Elem, List)
% looks for two consecutive occurrences of ELem

search2(E, [E, E|_]).
search2(E, [_|T]) :- search2(E, T).
