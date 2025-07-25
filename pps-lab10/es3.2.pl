% all bigger(List1, List2)
% all elements in List1 are bigger than those in List2, 1 by 1
greater(s(_), zero).
greater(s(N), s(M)) :- greater(N, M).

all_bigger(nil, nil).
all_bigger(cons(H1, T1), cons(H2, T2)) :- greater(H1, H2), all_bigger(T1, T2). 