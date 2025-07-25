greater(s(A), zero). 
greater(s(A), s(B)) :- greater(A, B).

% last
last(cons(E, nil), E).
last(cons(H, T), E) :- last(T, E).

% map (_ + 1)
map(nil, nil).
map(cons(H1, T1), cons(s(H1), T2)) :- map(T1, T2).

% filter (_ > 0)
filter(nil, nil).
filter(cons(zero, T), L) :- filter(T, L).
filter(cons(H, T1), cons(H, T2)) :- H \= zero, filter(T1, T2).

% count (_ > 0)
count(nil, zero).
count(cons(zero, T), N) :- count(T, N).
count(cons(E, T), s(N)) :- greater(E, zero), count(T, N).
