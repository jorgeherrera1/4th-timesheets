create table billable_time (
  billable_time_id integer not null auto_increment,
  task_id          integer not null,
  date             date    not null,
  time             smallint,
  overtime         smallint,
  timesheet_id     integer,

  primary key (billable_time_id)
);