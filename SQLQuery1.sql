CREATE TABLE Team (
	team_id SMALLINT PRIMARY KEY,
	name VARCHAR(50)
)

CREATE TABLE Player (
	player_id SMALLINT PRIMARY KEY,
	name VARCHAR(50),
	born VARCHAR(50),
	prefer_foot VARCHAR(5),
	total_goal SMALLINT,
	team_id SMALLINT
	FOREIGN KEY (team_id) REFERENCES Team(team_id) ON UPDATE CASCADE ON DELETE CASCADE
)

INSERT INTO Team VALUES (1, 'Arsenal')
INSERT INTO Team VALUES (2, 'Manchester City')	
INSERT INTO Team VALUES (3, 'Crystal Palace')
INSERT INTO Player VALUES (1, 'Joe Willock', 'England', 'RIGHT', 9, 1)
INSERT INTO Player VALUES (2, 'Matteo Guendouzi', 'France', 'RIGHT', 1, 1)
INSERT INTO Player VALUES (3, 'Alexandre Lacazette', 'France', 'LEFT', 8, 1)
INSERT INTO Player VALUES (4, 'Wayne Hennessey', 'Wales', 'LEFT', 12, 3)
INSERT INTO Player VALUES (5, 'Wilfried Zaha', 'Affrica', 'RIGHT', 39, 3)
INSERT INTO Player VALUES (6, 'Cenk Tosun', 'Turkey', 'LEFT',  18, 3)
INSERT INTO Player VALUES (7, 'John Stone', 'England', 'RIGHT', 21, 2)
INSERT INTO Player VALUES (8, 'Pontus Jansson', 'Sweden', 'LEFT', 9, 2)
INSERT INTO Player VALUES (9, 'Jack Clarke', 'England', 'RIGHT', 19, 2)
TRUNCATE TABLE Player