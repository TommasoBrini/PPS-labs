% dropAny
dropAny(E, [E|T], T).
dropAny(E, [H|T], [H|L]) :- dropAny(E, T, L).

% dropFirst
dropFirst(E, L, OL) :- dropAny(E, L, OL), !.

% dropLast
dropLast(E, [H|T], [H|L]) :- dropLast(E, T, L), !.
dropLast(E, [E|T], T).

% dropAll
dropAll(E, [], []).
dropAll(E, [E|T], L) :- !, dropAll(E, T, L).
dropAll(E, [H|T], [H|L]) :- dropAll(E, T, L).

