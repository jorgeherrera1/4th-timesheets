create table resources (
   resource_id    integer     not null auto_increment,
   resource_name  varchar(32) not null,
   resource_email varchar(64) not null unique,
   resource_lead  varchar(32),

   primary key (resource_id)
);