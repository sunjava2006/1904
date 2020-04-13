print('今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问几何？')

for i in range(200):
    if i%3==2 and i%5==3 and i%7==2:
        print(i)
