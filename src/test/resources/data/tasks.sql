insert into tasks (name, project_id) values ('FB-1', (select project_id from projects where name = 'Facebook'));
insert into tasks (name, project_id) values ('FB-2', (select project_id from projects where name = 'Facebook'));
insert into tasks (name, project_id) values ('MS-11', (select project_id from projects where name = 'Microsoft'));
insert into tasks (name, project_id) values ('MS-12', (select project_id from projects where name = 'Microsoft'));
insert into tasks (name, project_id) values ('TW-101', (select project_id from projects where name = 'Twitter'));
insert into tasks (name, project_id) values ('TW-102', (select project_id from projects where name = 'Twitter'));
