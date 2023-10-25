
create table personne(

	id_personne serial primary key,
	cin varchar(20) unique,
	firstName varchar(50),
	lastName varchar(50),
	dateNaissance date,
	groupe varchar(50)

);

create table allergie(
	id_allergie serial primary key,
	nom varchar(50)
);

create table allergies(
	id_detail serial primary key,
	id_allergie int not null,
	cin varchar(20),
	foreign key(cin) references personne(cin)
);

create view v_allergies as
	select als.id_detail, als.cin, al.*
	from allergies as als
	join allergie as al
	on als.id_allergie = al.id_allergie;


--- Base Foncier
create table devise(
	id varchar(7) primary key,
	name varchar(20)
);

create table cours_devise(
	id_cours_devise serial primary key,
	id_devise varchar(7) not null,
	montant double precision, --- par rapport amin'ny ariary izany hoe 1 amin'ilay devise equivalent amin'ny valeur en ariary,
	montant_2 double precision,
	date_cours date,
	foreign key(id_devise) references devise(id)
);

-- Inona no ilaina daholo no ilaina
-- atao misy resaka transactions

alter table tany add column addresse


-- Banque database

create table transfert(

	id_transfert serial primary key,
	id_send int not null,
	id_receive int not null,
	montant double precision,
	cours_devise int not null,
	date_transfert timestamp,
	foreign key(id_send) references account(id),
	foreign key(id_receive) references account(id)
);

create table transaction_2(
	id_transaction serial primary key,
	id_compte int not null,
	debit double precision,
	credit double precision,
	par int not null,
	cours_devise int not null,
	date_transaction timestamp,
	foreign key( id_compte ) references account(id),
	foreign key( par ) references account(id)
);


create table borne(
	idBorne serial primary key,
	idTany integer not null,
	longitude double precision,
	latitude double precision,
	foreign key( idTany ) references tany(id)
);

-- Andao andramana zavatra hafa ary

