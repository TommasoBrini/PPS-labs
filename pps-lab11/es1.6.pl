% split(List1, Elements, SubList1, SubList2)
% splits a list into two sublists based on a given set of elements

split(T, 0, [], T).
split([H|T], M, [H|T2], L2) :- N is M-1, split(T, N, T2, L2).