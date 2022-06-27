with id1 as (
    insert into practice_task(task_name, task_text,id) values ('calculator','операции:плюс, минус, умножить',nextval('hibernate_sequence')) on conflict do nothing returning id)
update practice_ticket
set practice_task_id = (select id from id1)
where exists(select * from programming_language pl where programming_language_id = pl.id and name like '%Java');

with id2 as (insert into practice_task(task_name, task_text,id) values ('framework','что то вроде реакта',nextval('hibernate_sequence')) on conflict do nothing returning id)
update practice_ticket
set practice_task_id=(select id from id2)
where exists(select * from programming_language pl where programming_language_id = pl.id and name like '%JS');

WITH id3 as (insert into practice_task(task_name, task_text,id) values ('landing page','интернет магазин с товарами, технологии; css(flexbox, grid, нельзя использовать float),html',nextval('hibernate_sequence')) on conflict do nothing returning id)
update practice_ticket
set practice_task_id=(select id from id3)
where exists(select * from programming_language pl where programming_language_id = pl.id and name like '%html');
