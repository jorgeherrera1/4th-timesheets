create table resources (
  resource_id    integer     not null auto_increment,
  name           varchar(32) not null,
  email          varchar(64) not null unique,
  lead_name      varchar(32),

  primary key (resource_id)
);