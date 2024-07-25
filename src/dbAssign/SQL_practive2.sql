-- A.5
-- Q 0
select 'Han-Bit', concat(first_name, ' ', last_name) Name, job_id, department_name, city
from employees, departments, locations
where city = 'Oxford' and locations.location_id = departments.location_id and employees.department_id = departments.department_id;
-- Q 1
select department_name, count(employee_id)
from employees, departments
where employees.department_id = departments.department_id
group by employees.department_id
having count(employees.department_id) >= 5;
-- Q 2
select concat(first_name, ' ', last_name) Name, job_id, department_name, hire_date, salary, grade_level
from departments, employees left outer join job_grades on salary between lowest_sal and highest_sal
where employees.department_id = departments.department_id
order by grade_level;
-- Q 3
select concat(concat(emp.first_name, ' ', emp.last_name), 'report to ', upper(concat(mgr.first_name, ' ', mgr.last_name)))
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id;