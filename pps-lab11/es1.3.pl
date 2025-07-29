% size(List, Size)
% Size will contain the number of elements in List
size([], 0).
size([_|T], S) :- size(T,N), S is N + 1.
