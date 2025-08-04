% search2(Elem, List)
search2(E, [E, E | _ ]).
search2(E, [ _ | T]) :- search2(E, T).

%search_two(Elem, List)
search_two(E, [E, _, E | _]).
search_two(E, [_|T]) :- search_two(E, T).

%size
size([], 0).
size([_|T], N) :- size(T, M), N is M + 1.

%sum
sum([], 0).
sum([H | T], N) :- sum(T, M), N is M + H.

%maxMin
max_min([], Max, Max, Min, Min).
max_min([H|T], TMax, Max, TMin, Min) :- H > TMax, max_min(T, H, Max, TMin, Min).
max_min([H|T], TMax, Max, TMin, Min) :- H < TMin, max_min(T, TMax, Max, H, Min).
max_min([H|T], TMax, Max, TMin, Min) :- max_min(T, TMax, Max, TMin, Min).
max_min([H|T], Max, Min) :- max_min(T, H, Max, H, Min), !.


max_min2([H], H, H).
max_min2([H|T], H, MIN) :- max_min2(T, MAX, MIN), H > MAX, !.
max_min2([H|T], MAX, H) :- max_min2(T, MAX, MIN), H < MIN, !.
max_min2([_|T], MAX, MIN) :- max_min2(T, MAX, MIN).

% sublist
split(T, 0, [], T).
split([H|T], N, [H|S1], S2) :- N > 0, M is N - 1, split(T, M, S1, S2).

% rotate
rotate([H|T], L) :- append(T, [H], L).

% count occurrences(E, L, C)
count_occurrences(_, [], 0).
count_occurrences(E, [E|T], N) :- count_occurrences(E, T, M), N is M + 1, !.
count_occurrences(E, [_|T], N) :- count_occurrences(E, T, N).

% dice(X)
dice(X) :- member(X, [1,2,3,4,5,6]).

% three_dice(L)
three_dice([X, Y, Z]) :- dice(X),dice(Y),dice(Z).

% distinct
distinct([], []).
distinct([H|T], T2) :- member(H, T), distinct(T, T2).
distinct([H|T], [H|T2]) :- \+ member(H, T), distinct(T, T2).

