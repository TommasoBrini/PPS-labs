% dice(X)
% generates all possible outcomes of throwing a dice
dice(X) :- member(X, [1,2,3,4,5,6]).
