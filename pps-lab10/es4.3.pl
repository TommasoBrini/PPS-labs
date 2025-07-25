% seqR2(N, List) --> is [0,1,...,N-1]

%seqR2(s(N), L) :- seqR2(s(N), nil, L).
%seqR2(zero, L, L).
%seqR2(s(N), TL, L) :- seqR2(N, cons(N, TL), L).

last(nil, E, cons(E, nil)).
last(cons(H, T1), E, cons(H, T2)) :- last(T1, E, T2).
seqR2(s(N), L) :- seqR2(s(N), nil, L).
seqR2(zero, L, L).
seqR2(s(N), TL, L) :- seqR2(N, TL, RL), last(RL, N, L).
