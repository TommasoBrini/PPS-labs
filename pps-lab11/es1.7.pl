% rotate(List, RotatedList)
% rotate a list, namely move the first element to the end of the list

rotate([H|T], RL) :- append(T, [H], RL).