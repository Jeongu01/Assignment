-- A.1
-- Q 0
select employee_id,
       concat(first_name, ' ', last_name) as Name,
       salary,
       job_id,
       hire_date,
       manager_id
from employees;
-- Q 1
select employee_id,
       concat(first_name, ' ', last_name) as Name,
       salary,
       job_id,
       hire_date,
       manager_id
from employees;
-- Q 2
select concat(first_name, ' ', last_name, ': 1 Year Salary = ', salary * 12) as '1 Year Salary'
from employees;
-- Q 3
select distinct department_name
from departments;

-- A.2
-- Q 0
select concat(first_name, ' ', last_name) Name, salary
from employees
where salary between 7000 and 10000
order by salary;
-- Q 1
select concat(first_name, ' ', last_name) as 'e and o Name'
from employees
where last_name like '%e%'
   or '%o%';
-- Q 2
select concat(first_name, ' ', last_name) as 'Name', employee_id, hire_date
from employees
where hire_date between '2006-05-20' and '2007-05-20';
-- Q 3
select concat(first_name, ' ', last_name) Name, salary, job_id, commission_pct
from employees
where commission_pct is not null
order by salary desc, commission_pct;

-- A.3
-- Q 0
select concat(first_name, ' ', last_name) Name,
       salary,
       round(salary + salary * 12.3) as   'Increased Salary'
from employees
where department_id = 60;
-- Q 1
select concat(upper(left(first_name, 1)), substr(first_name, 2), ' ', upper(left(last_name, 1)),
              substr(last_name, 2), ' is a ', upper(job_title)) as 'Employee JOBs'
from employees,
     jobs
where last_name like '%s'
  and jobs.job_id = employees.job_id;
-- Q 2
select concat(first_name, ' ', last_name) as                                              Name,
       salary                                                                             급여,
       if(commission_pct is not null, salary * 12 + salary * commission_pct, salary * 12) 연봉,
       if(commission_pct is not null, 'Salary + Commission', 'Salary only')               수당여부
from employees
order by if(commission_pct is not null, salary * 12 + salary * commission_pct, salary * 12) desc;
-- Q 3
select concat(first_name, ' ', last_name) Name,
       hire_date,
       CASE WEEKDAY(hire_date)
           WHEN 0
               THEN '월'
           WHEN 1
               THEN '화'
           WHEN 2
               THEN '수'
           WHEN 3
               THEN '목'
           WHEN 4
               THEN '금'
           WHEN 5
               THEN '토'
           WHEN 6
               THEN '일'
           END as                         요일
from employees;

-- A.4
-- Q 0
select count(distinct manager_id)
from employees;
-- Q 1
select concat('$', format(sum(salary), '#,#')) '급여 합계',
        concat('$', format(avg(salary), '#,#')) '급여 평균',
        concat('$', format(max(salary), '#,#')) '급여 최대값',
        concat('$', format(min(salary), '#,#')) '급여 최소값'
from employees
where department_id is not null
group by department_id
order by department_id;
-- Q 2
select job_id, avg(salary)
from employees
where not job_id like '%CLERK'
group by job_id
having avg(salary) >= 10000;