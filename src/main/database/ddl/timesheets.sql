create table timesheets (
  timesheet_id integer not null auto_increment,
  week_ending  date    not null,
  resource_id  integer not null,

  primary key (timesheet_id)
);