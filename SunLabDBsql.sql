drop table accessTable;
drop table SunLabLogs;

create table SunLabLogs(
                           s_id varchar(9),
                           name varchar(50),
                           job_role Varchar(3),
                           DATE_OF_ENTER Date,
                           TIME_OF_ENTER Timestamp,
                           primary key(s_id, TIME_OF_ENTER)

);

create table accessTable(
    s_id varchar(9),
    allowed varchar(50)
);

insert into SunLabLogs values('943733130', 'John Smith', 'STU', SYSDATE, SYSTIMESTAMP);

Select * from SunLabLogs;


insert into SunLabLogs values('976554123', 'Bill Anderson', 'STU', TO_DATE('2022-05,17', 'YYYY-MM-DD'), TO_TIMESTAMP('17-MAY-22 14:10:10.123000','DD-MON-RRHH24:MI:SS.FF'));

Select * from SunLabLogs;

insert into SunLabLogs values('966453784', 'Derick Carr', 'STU', TO_DATE('2022-06,21', 'YYYY-MM-DD'), TO_TIMESTAMP('21-JUN-22 08:35:17.202000','DD-MON-RRHH24:MI:SS.FF'));

Select * from SunLabLogs where s_id like '%00002%';
Select * from SunLabLogs where DATE_OF_ENTER like TO_DATE('2022-06,21', 'YYYY-MM-DD');
Select * from SunLabLogs where TIME_OF_ENTER BETWEEN TO_TIMESTAMP('01-JAN-22 00:00:00.000000','DD-MON-RRHH24:MI:SS.FF') and TO_TIMESTAMP('30-DEC-22 00:00:00.000000','DD-MON-RRHH24:MI:SS.FF');

insert into accessTable values('943733130', 'Activated');
insert into accessTable values('976554123', 'Activated');
insert into accessTable values('966453784', 'Activated');