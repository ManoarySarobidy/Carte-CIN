insert into personne values
	( default, '00001', 'RANDRIA', 'Olombelona Haha', to_date('2000-04-01', 'YYYY-MM-DD') ,'A'),
	( default, '00002', 'RANDRIA', 'Olombelona Haha2', to_date('2001-05-01', 'YYYY-MM-DD'),'B' ),
	( default, '00003', 'RANDRIA', 'Olombelona Haha3', to_date('2000-06-01', 'YYYY-MM-DD'),'A' ),
	( default, '00004', 'RANDRIA', 'Olombelona Haha4', to_date('2000-03-01', 'YYYY-MM-DD'),'O' ),
	( default, '00005', 'RANDRIA', 'Olombelona Haha5', to_date('2000-02-01', 'YYYY-MM-DD'),'AB' ),
	( default, '00006', 'RANDRIA', 'Olombelona Haha6', to_date('2000-03-01', 'YYYY-MM-DD'),'O' ),
	( default, '00007', 'RANDRIA', 'Olombelona Haha7', to_date('2000-05-01', 'YYYY-MM-DD'),'AB' ),
	( default, '00008', 'RANDRIA', 'Olombelona Haha8', to_date('2000-08-01', 'YYYY-MM-DD'),'B' );


insert into allergie values
	(default, 'Peniciline'),
	(default, 'Pollen'),
	(default, 'Cacahouete'),
	(default, 'Farine'),
	(default, 'Oeufs'),
	(default, 'Soja');

insert into allergies values
	(default, 1, '00001'),
	(default, 2, '00001'),
	(default, 3, '00001'),
	(default, 2, '00002'),
	(default, 4, '00002'),
	(default, 3, '00003'),
	(default, 5, '00003'),
	(default, 6, '00003');

insert into devise values
	('DEV0001', 'AR'),
	('DEV0002', 'EUR'),
	('DEV0003', 'USD'),
	('DEV0004', 'YEN');

insert into cours_devise values
	(default, 'DEV0001', 1, to_date('2023-10-10','YYYY-MM-DD')),
	(default, 'DEV0002', 3500, to_date('2023-10-10','YYYY-MM-DD')),
	(default, 'DEV0003', 3347.98, to_date('2023-10-10','YYYY-MM-DD')),
	(default, 'DEV0004', 100, to_date('2023-10-10','YYYY-MM-DD'));


