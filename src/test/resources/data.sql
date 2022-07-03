INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (1, 'telegram:abcd', 'vasya pupkin', 3, '11', 100);
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (3, 'telegram:ecb', 'vasya vasya', 4, '10', 55);
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (7, 'ф', 'temkarus0070', 1, '11', 0);
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (9, 'telega:1234', 'artyom ivanov', 3, '11', 100);
INSERT INTO public.student (id, contact_data, full_name, study_course, study_group, test_result)
VALUES (2, 'telegram:ebgh', 'vasya ivanov', 3, '11', 24);


INSERT INTO public.mentor (id, contact_data, full_name, job_name)
VALUES (1, 'telegram:1234', 'Ivan Ivanov', 'Java-developer');
INSERT INTO public.mentor (id, contact_data, full_name, job_name)
VALUES (2, 'telegram:12346790', 'Ivan vASILIEV', 'JS-developer');


INSERT INTO public.programming_language (name, id)
VALUES ('html', 30);
INSERT INTO public.programming_language (name, id)
VALUES ('JS', 31);
INSERT INTO public.programming_language (name, id)
VALUES ('Java', 32);


INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, final_mark, recommend_to_hire, student_id,
                                    programming_language_id, mentor_id)
VALUES ('2022-06-01', '2022-07-01', 1, true, 1, 32, 1);
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, final_mark, recommend_to_hire, student_id,
                                    programming_language_id, mentor_id)
VALUES ('2022-05-22', '2022-06-11', 3, false, 3, 30, 2);
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, final_mark, recommend_to_hire, student_id,
                                    programming_language_id, mentor_id)
VALUES ('2022-05-22', '2022-06-11', 2, true, 2, 30, 2);
INSERT INTO public.practice_ticket (begin_of_practice, end_of_practice, final_mark, recommend_to_hire, student_id,
                                    programming_language_id, mentor_id)
VALUES ('2022-05-22', '2022-06-11', null, false, 2, 31, 2);



INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (10, 'все хорошо', '2022-05-22', '2022-06-11', 2, 30, 3);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (9, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 3);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (8, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 3);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (7, 'все хорошо', '2022-05-22', '2022-06-11', 2, 30, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (6, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (5, 'все классно', '2022-05-22', '2022-06-11', 2, 30, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (3, 'все хорошо', '2022-05-22', '2022-06-11', 2, 31, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (2, 'все классно', '2022-05-22', '2022-06-11', 2, 31, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (1, 'все классно', '2022-05-22', '2022-06-11', 2, 31, 2);
INSERT INTO public.weekly_study_review (id, text_review, practice_ticket_begin_of_practice,
                                        practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                        practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (4, 'все хорошо', '2022-06-01', '2022-07-01', 1, 32, 1);


INSERT INTO public.final_study_review (id, text_review, practice_ticket_begin_of_practice,
                                       practice_ticket_end_of_practice, practice_ticket_student_id,
                                       practice_ticket_mentor_id, practice_ticket_programming_language_id)
VALUES (3, 'все классно', '2022-05-22', '2022-06-11', 3, 2, 30);
INSERT INTO public.final_study_review (id, text_review, practice_ticket_begin_of_practice,
                                       practice_ticket_end_of_practice, practice_ticket_student_id,
                                       practice_ticket_mentor_id, practice_ticket_programming_language_id)
VALUES (2, 'все классно', '2022-05-22', '2022-06-11', 2, 2, 30);


/*
 SET next sequence value if not set before to right work sequence generation after insert init-init-data.sql rows
 3 is max student id in init-init-data.sql rows
 */

INSERT INTO public.practice_task (id, task_name, task_text, practice_ticket_begin_of_practice,
                                  practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                  practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (34, 'calculator', 'операции:плюс, минус, умножить', '2022-06-01', '2022-07-01', 1, 32,
        1);
INSERT INTO public.practice_task (id, task_name, task_text, practice_ticket_begin_of_practice,
                                  practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                  practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (37, 'landing page', 'кофейня', '2022-05-22', '2022-06-11', 2, 30, 3);
INSERT INTO public.practice_task (id, task_name, task_text, practice_ticket_begin_of_practice,
                                  practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                  practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (36, 'landing page',
        'интернет магазин с товарами, технологии - css(flexbox, grid, нельзя использовать float),html', '2022-05-22',
        '2022-06-11', 2, 30, 2);
INSERT INTO public.practice_task (id, task_name, task_text, practice_ticket_begin_of_practice,
                                  practice_ticket_end_of_practice, practice_ticket_mentor_id,
                                  practice_ticket_programming_language_id, practice_ticket_student_id)
VALUES (35, 'framework', 'что то вроде реакта', '2022-05-22', '2022-06-11', 2, 31, 2);
