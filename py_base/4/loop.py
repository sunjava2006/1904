print('今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问几何？')

number = 1

while True:
    if number%3==2 and number%5==3 and number%7==2:
        print(number)
        break
    number += 1


for i in [0,1,2,3,4,5,6,7,8,9]:
    print(i)

print('*'*20)
# for i in 1..10000
r  = range(0, 10) # 使用range函数，产生一个range对象。（包含数值）
for i in r: # 0~9
    print(i)

