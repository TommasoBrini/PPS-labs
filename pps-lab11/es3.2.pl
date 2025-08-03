% outDegree(+Graph, +Node, -Deg)
% Deg is the number of edges which start from Node

outDegree([], _, 0).
outDegree([e(N, _)|T], N, D) :- outDegree(L, N, OD), D is OD + 1, !.
outDegree([_|T], N, D) :- outDegree(T, N, D).