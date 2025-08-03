% anypath(+Graph, +Node1, +Node2, -ListPath)
% a Path from Node1 to Node2
% if there are many path, they are showed 1-by-1

anypath(G, F, T, [e(F, T)]) :- member(e(F,T), G).
anypath(G, F, T, [e(F, N) | P]) :- member(e(F, N), G), anypath(G, N, T, P).
