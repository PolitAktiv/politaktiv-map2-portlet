create table politaktivmap_Marker (
	markerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	content VARCHAR(1024) null,
	longitude VARCHAR(11) null,
	latitude VARCHAR(11) null
);

create table politaktivmaptwo_Marker (
	markerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	content VARCHAR(1024) null,
	longitude VARCHAR(11) null,
	latitude VARCHAR(11) null
);