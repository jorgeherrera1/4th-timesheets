create table projects (
  project_id   integer     not null auto_increment,
  name         varchar(64) not null unique,
  manager_name varchar(32),

  primary key (project_id)
);