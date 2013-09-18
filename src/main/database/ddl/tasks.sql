create table tasks (
  task_id      integer     not null auto_increment,
  name         varchar(64) not null unique,
  project_id   integer,

  primary key (task_id),
  foreign key (project_id) references projects (project_id)
);