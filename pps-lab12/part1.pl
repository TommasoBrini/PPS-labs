% Part 1

% map(+L, +Mapper,-Lo)
% where Mapper=mapper(I,O,UNARY_OP)
% e.g. Mapper=mapper(X, Y, Y is X+1)
map([], _, []).
map([H|T], M, [H2|T2]) :-
	map(T, M, T2), copy_term(M, mapper(H, H2, OP)), call(OP).
