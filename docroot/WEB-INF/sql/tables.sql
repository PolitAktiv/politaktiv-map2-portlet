create table politaktivmaptwo_Coordinate (
	coordinateId LONG not null primary key,
	shapeId LONG,
	longitude VARCHAR(75) null,
	latitude VARCHAR(75) null
);

create table politaktivmaptwo_Shape (
	shapeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	abstractDescription VARCHAR(75) null,
	url VARCHAR(75) null,
	shapeType VARCHAR(75) null,
	radius LONG,
	layer VARCHAR(75) null
);