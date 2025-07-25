% seqR(N, List)

seqR(zero, nil).
seqR(s(N), cons(N, T)) :- seqR(N, T).