class Solution:
    def average(self, salary) -> float:
        salary.sort()
        salary = salary[1:-1]
        return (sum(salary)/len(salary))