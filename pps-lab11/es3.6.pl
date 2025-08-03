% allreaching(+Graph, +Node, -List)
% all the nodes that can be reached from Node
% Suppose the graph is Not circular
anypath(G, F, T, [e(F, T)]) :- member(e(F,T), G).
anypath(G, F, T, [e(F, N) | P]) :- member(e(F, N), G), anypath(G, N, T, P).

allreaching(G, N, L) :- findall(E, anypath(G, N, E, _), L).