insert into timesheets (week_ending,
                        resource_id)
  values (
    date('2013-9-7'),
    (select resource_id from resources where name = 'Facebook Developer')
  );

insert into timesheets (week_ending,
                        resource_id)
  values (
    date('2013-9-14'),
    (select resource_id from resources where name = 'Microsoft Developer')
  );

insert into timesheets (week_ending,
                        resource_id)
  values (
    date('2013-9-14'),
    (select resource_id from resources where name = 'Twitter Developer')
  );