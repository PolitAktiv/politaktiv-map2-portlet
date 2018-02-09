-- create index IX_CCA407DC on politaktivmap_Marker (userId);

create index IX_C9C94E1E on politaktivmaptwo_Coordinate (shapeId);

create index IX_5C31031D on politaktivmaptwo_Layer (label);
create index IX_7B7766E3 on politaktivmaptwo_Layer (portlet);
create index IX_7B48651E on politaktivmaptwo_Layer (portletId);
create index IX_8ED0CCE1 on politaktivmaptwo_Layer (userId);
create index IX_A8234CA3 on politaktivmaptwo_Layer (userId, label);
create index IX_65B18167 on politaktivmaptwo_Layer (userId, label, portlet);
create index IX_BF65EEA2 on politaktivmaptwo_Layer (userId, label, portletId);
create index IX_A9361BDC on politaktivmaptwo_Layer (userId, label, portletInstance);
create index IX_93FD66E9 on politaktivmaptwo_Layer (userId, portlet);
create index IX_DE8D5F5E on politaktivmaptwo_Layer (userId, portletInstance);

-- create index IX_499830EA on politaktivmaptwo_Marker (userId);

create index IX_558C55EA on politaktivmaptwo_Shape (layer);
create index IX_999DA331 on politaktivmaptwo_Shape (userId);
create index IX_D2FBEF70 on politaktivmaptwo_Shape (userId, layer);
create index IX_63EB53A on politaktivmaptwo_Shape (userId, layer, portlet);
create index IX_717579B5 on politaktivmaptwo_Shape (userId, layer, portletId);
create index IX_4347CCAF on politaktivmaptwo_Shape (userId, layer, portletInstance);