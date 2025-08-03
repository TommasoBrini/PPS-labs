% reaching(+Graph, +Node, -List)

% all the nodes that can be reached in 1 step from Node
% possibly use findAll, looking for e(Node, _) combined
% with member(?Elem, ?List)

reaching(G, N, L) :- findall(E, member(e(N, E), G), L).