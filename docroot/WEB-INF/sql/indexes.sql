create index IX_CCA407DC on politaktivmap_Marker (userId);

create index IX_C9C94E1E on politaktivmaptwo_Coordinate (shapeId);

create index IX_8ED0CCE1 on politaktivmaptwo_Layer (userId);

create index IX_499830EA on politaktivmaptwo_Marker (userId);

create index IX_558C55EA on politaktivmaptwo_Shape (layer[$COLUMN_LENGTH:75$]);
create index IX_D2FBEF70 on politaktivmaptwo_Shape (userId, layer[$COLUMN_LENGTH:75$]);