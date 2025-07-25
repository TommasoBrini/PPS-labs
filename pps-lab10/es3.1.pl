% same(List1, List2)
% are the two lists exactly the same?

same(nil, nil).
same(cons(E, T1), cons(E, T2)) :- same(T1, T2).