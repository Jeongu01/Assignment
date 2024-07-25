# A.6 서브쿼리를 사용하여  해결 하세요
# [문제 1] HR 부서의 어떤  사원은 급여정보를  조회하는 업무를 맡고  있다. Tucker(last_name) 사원보다
# 급여를 많이 받고 있는 사원의 성과 이름(Name으로 별칭), 업무, 급여를 출력하시오
select concat(first_name, ' ', last_name) Name, job_id, salary
from employees
where salary > (select salary from employees where last_name = 'Tucker');

# [문제 2]  사원의 급여  정보  중 업무별  최소  급여를 받고  있는  사원의 성과  이름(Name으로 별칭), 업무,
# 급여, 입사일을 출력하시오
select concat(first_name, ' ', last_name) Name, job_id, salary, hire_date
from employees e1
where e1.salary =
      (select min(e2.salary)
       from employees e2
       where e1.job_id = e2.job_id
       group by e1.job_id);

# [문제 3] 소속 부서의 평균 급여보다 많은 급여를 받는 사원에 대하여 사원의 성과 이름(Name으로 별칭),
# 급여, 부서번호, 업무를 출력하시오
select concat(first_name, ' ', last_name) Name, salary, department_id, job_id
from employees e1
where salary > (select avg(salary)
                from employees e2
                where e1.department_id = e2.department_id
                group by department_id)
order by department_id;

# [문제 4] 사원들의 지역별 근무 현황을 조회하고자 한다. 도시 이름이 영문 'O' 로 시작하는 지역에 살고
# 있는 사원의 사번, 이름, 업무, 입사일을 출력하시오
select employee_id 사번, concat(first_name, ' ', last_name) 이름, job_id 업무, hire_date 입사일
from employees
where department_id = (select departments.department_id
                       from departments
                       where location_id =
                             (select locations.location_id from locations where city like 'O%'));

# [문제 5] 모든 사원의 소속부서 평균연봉을 계산하여 사원별로 성과 이름(Name으로 별칭), 업무, 급여, 부
# 서번호, 부서 평균연봉(Department Avg Salary로 별칭)을 출력하시오
select concat(e1.first_name, ' ', e1.last_name) Name,
       e1.job_id,
       e1.salary,
       e1.department_id,
       d.`Department Avg Salary`
from employees e1,
     (select department_id, avg(salary) 'Department Avg Salary'
      from employees
      where department_id is not null
      group by department_id) d
where e1.department_id = d.department_id;

# [문제 6] ‘Kochhar’의 급여보다 많은 사원의 정보를 사원번호,이름,담당업무,급여를 출력하시오
select employee_id, concat(first_name, ' ', last_name) Name, job_id, salary
from employees
where salary > (select salary from employees where last_name = 'Kochhar');

# [문제 7] 급여의 평균보다 적은 사원의 사원번호,이름,담당업무,급여,부서번호를 출력하시오
select employee_id, concat(first_name, ' ', last_name) Name, job_id, salary, department_id
from employees
where salary < (select avg(salary) from employees);

# [문제 8] 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하시오
select distinct e.department_id
from employees e,
     (select min(salary) minS, department_id from employees group by department_id) minTbl
where e.department_id = minTbl.department_id
  and minTbl.minS >
      (select min(salary) from employees where department_id = 100);

# [문제 9] 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하시오
#         출력시 업무별로 정렬하시오
select e.employee_id, concat(e.first_name, ' ', e.last_name) Name, e.job_id, e.department_id
from employees e,
     (select min(salary) s, job_id from employees group by job_id) minTbl
where e.job_id = minTbl.job_id
  and e.salary = minTbl.s
order by e.job_id;

# [문제 10] 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하시오
select distinct e.department_id
from employees e,
     (select min(salary) s, department_id from employees group by department_id) minTbl
where e.department_id = minTbl.department_id
  and minTbl.s > (select min(e2.salary) from employees e2 where e2.department_id = 100);

# [문제 11] 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하시오
select concat(first_name, ' ', last_name) Name, job_id, department_name, city
from employees,
     departments,
     locations
where job_id = 'SA_MAN'
  and employees.department_id = departments.department_id
  and locations.location_id = departments.location_id;

# [문제 12] 가장 많은 부하직원을 갖는 MANAGER의 사원번호와 이름을 출력하시오
select e.employee_id, concat(first_name, ' ', last_name) Name
from employees e,
     (select count(e2.employee_id) c, e2.employee_id
      from employees e1,
           employees e2
      where e1.manager_id = e2.employee_id
      group by e2.employee_id) mgrTbl
where mgrTbl.employee_id = e.employee_id
  and c = (select max(c)
           from (select count(e2.employee_id) c, e2.employee_id
                 from employees e1,
                      employees e2
                 where e1.manager_id = e2.employee_id
                 group by e2.employee_id) t);

# [문제 13] 사원번호가 123인 사원의 업무가이 같고
#    사원번호가 192인 사원의 급여(SAL))보다 많은 사원의 사원번호,이름,직업,급여를 출력하시오
select employee_id, concat(first_name, ' ', last_name), job_id, salary
from employees
where job_id = (select job_id from employees where employee_id = 123)
  and salary > (select salary from employees where employee_id = 192);

# [문제 14] 50번 부서에서 최소 급여를 받는 사원보다 많은 급여를 받는 사원의 사원번호,이름,업무,입사일
# 자,급여,부서번호를 출력하시오.  단 50번 부서의 사원은 제외합니다
select employee_id,
       concat(first_name, ' ', last_name) Name,
       job_id,
       hire_date,
       salary,
       department_id
from employees
where salary > (select min(salary) from employees where department_id = 50 group by department_id)
  and not department_id = 50
order by salary;

# [문제 15]  (50번 부서의 최고 급여)를 받는 사원 보다 많은 급여를 받는 사원의 사원번호,이름,업무,입사일
# 자,급여,부서번호를 출력하시오.  단 50번 부서의 사원은 제외합니다.
select employee_id,
       concat(first_name, ' ', last_name) Name,
       job_id,
       hire_date,
       salary,
       department_id
from employees
where salary > (select max(salary) from employees where department_id = 50 group by department_id)
  and not department_id = 50
order by salary;