# Write your MySQL query statement below
select employee_id, 
Case
When employee_id%2!=0 And name not like 'M%'
Then
salary
else
0
End
As
Bonus from Employees
order by
employee_id;
