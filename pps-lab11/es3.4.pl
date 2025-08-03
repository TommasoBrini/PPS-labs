
prepend_if_missing(L, E, L) :- member(E, L), !.
prepend_if_missing(L, E, NL) :- append([E], L, NL).

% nodes(+Graph, -Nodes)
% create a list of all nodes (no duplicates) in the graph (inverse of fromlist)

nodes([], []).
nodes([e(H1, H2)|T], NL) :- nodes(T, L), prepend_if_missing(L, H1, TL), prepend_if_missing(TL, H2, NL).

