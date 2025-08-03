% fromList(+List, -Graph)
fromList([_], []).
fromList([H1, H2|T], [e(H1, H2)|L]) :- fromList([H2|T], L).


