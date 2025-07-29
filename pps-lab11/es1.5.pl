%max_min(List, Max, Min)
max_min([], Max, Max, Min, Min).
max_min([H|T], TMAX, MAX, TMIN, MIN) :- H >= TMAX, max_min(T, H, MAX, TMIN, MIN).
max_min([H|T], TMAX, MAX, TMIN, MIN) :- H =< TMIN, max_min(T, TMAX, MAX, H, MIN).
max_min([H|T], MAX, MIN) :- max_min(T, H, MAX, H, MIN), !.

%max_min2
max_min2([H], H, H).
max_min2([H|T], Max, H) :- max_min2(T, Max, Min), H =< Min, !.
max_min2([H|T], H, Min) :- max_min2(T, Max, Min), H >= Max, !.
max_min2([H|T], Max, Min) :- max_min2(T, Max, Min).

