INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (1, 'telegram:abcd', 'vasya pupkin', 3, '11', 100)on conflict do nothing;
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (3, 'telegram:ecb', 'vasya vasya', 4, '10', 55)on conflict do nothing;
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (7, 'ф', 'temkarus0070', 1, '11', 0)on conflict do nothing;
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (9, 'telega:1234', 'artyom ivanov', 3, '11', 100)on conflict do nothing;
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (2, 'telegram:ebgh', 'vasya ivanov', 3, '11', 24)on conflict do nothing;


INSERT INTO public.mentor (id, contact_data, full_name, job_name)
VALUES (1, 'telegram:1234', 'Ivan Ivanov', 'Java-developer')on conflict do nothing;
INSERT INTO public.mentor (id, contact_data, full_name, job_name)
VALUES (2, 'telegram:12346790', 'Ivan vASILIEV', 'JS-developer')on conflict do nothing;


INSERT INTO public.programming_language (name, id)
VALUES ('html', 30)on conflict do nothing;
INSERT INTO public.programming_language (name, id)
VALUES ('JS', 31)on conflict do nothing;
INSERT INTO public.programming_language (name, id)
VALUES ('Java', 32)on conflict do nothing;

INSERT INTO public.practice_task (task_name, task_text, id)
VALUES ('calculator', 'операции:плюс, минус, умножить', 34)on conflict do nothing;
INSERT INTO public.practice_task (task_name, task_text, id)
VALUES ('framework', 'что то вроде реакта', 35)on conflict do nothing;
INSERT INTO public.practice_task (task_name, task_text, id)
VALUES ('landing page',
        'интернет магазин с товарами, технологииon conflict do nothing; css(flexbox, grid, нельзя использовать float),html',
        36)on conflict do nothing;


INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, programming_language_id, final_mark,
                                    recommend_to_hire, student_id, mentor_id, final_mentor_review_id, practice_task_id)
VALUES ('2022-06-01', '2022-07-01', 32, null, false, 1, 1, null, 34)on conflict do nothing;
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, programming_language_id, final_mark,
                                    recommend_to_hire, student_id, mentor_id, final_mentor_review_id, practice_task_id)
VALUES ('2022-05-22', '2022-06-11', 31, null, false, 2, 2, null, 35)on conflict do nothing;
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, programming_language_id, final_mark,
                                    recommend_to_hire, student_id, mentor_id, final_mentor_review_id, practice_task_id)
VALUES ('2022-05-22', '2022-06-11', 30, 3, false, 3, 2, null, 36)on conflict do nothing;
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, programming_language_id, final_mark,
                                    recommend_to_hire, student_id, mentor_id, final_mentor_review_id, practice_task_id)
VALUES ('2022-05-22', '2022-06-11', 30, 2, true, 2, 2, null, 36)on conflict do nothing;



INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (10, 'все хорошо', '2022-05-22', '2022-06-11', 2, 30, 3)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (9, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 3)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (8, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 3)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (7, 'все хорошо', '2022-05-22', '2022-06-11', 2, 30, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (6, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (5, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (3, 'все хорошо', '2022-05-22', '2022-06-11', 2, 31, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (2, 'все классно', '2022-05-22', '2022-06-11', 2, 31, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (1, 'все классно', '2022-05-22', '2022-06-11', 2, 31, 2)on conflict do nothing;
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (4, 'все хорошо', '2022-06-01', '2022-07-01', 1, 32, 1)on conflict do nothing;


INSERT INTO public.final_study_review (id, text_review)
VALUES (3, 'все классно')on conflict do nothing;
INSERT INTO public.final_study_review (id, text_review)
VALUES (2, 'все классно')on conflict do nothing;
INSERT INTO public.final_study_review (id, text_review)
VALUES (1, 'все классно')on conflict do nothing;


UPDATE practice_ticket
set final_mentor_review_id=3
where begin_of_practice = date '2022-05-22'
  and end_of_practice = date '2022-06-11'
  and mentor_id = 2
  and programming_language_id = 30
  and student_id = 3;

UPDATE practice_ticket
set final_mentor_review_id=2
where begin_of_practice = date '2022-05-22'
  and end_of_practice = date '2022-06-11'
  and mentor_id = 2
  and programming_language_id = 30
  and student_id = 2;

UPDATE practice_ticket
set final_mentor_review_id=2
where begin_of_practice = date '2022-05-22'
  and end_of_practice = date '2022-06-11'
  and mentor_id = 2
  and programming_language_id = 31
  and student_id = 2;
/*
 SET next sequence value if not set before to right work sequence generation after insert init-data.sql rows
 3 is max student id in init-data.sql rows
 */
SELECT setval('hibernate_sequence', 100)
from student;
