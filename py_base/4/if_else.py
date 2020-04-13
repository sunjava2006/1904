import random

score = random.randint(10, 100)

grad = None 
if score >= 90:
    grad = '优'
elif score >= 80:
    grad = '良'
elif score >= 70:
    grad = '中'
elif score >= 60:
    grad = '及格'
else:
    grad = '差'

print(score, grad)
