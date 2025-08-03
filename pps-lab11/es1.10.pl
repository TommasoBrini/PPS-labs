% three_dice(L).
% Generates all possible outcomus of throwing three dices
dice(X) :- member(X, [1,2,3,4,5,6]).

three_dice([X, Y, Z]) :- dice(X), dice(Y), dice(Z).