create table billable_time (
  billable_time_id integer not null auto_increment,
  task_id          integer not null,
  date             date    not null,
  time             smallint,
  overtime         smallint,
  timesheet_id     integer,

  primary key (billable_time_id),
  foreign key (task_id) references tasks (task_id),
  foreign key (timesheet_id) references timesheets (timesheet_id)
);