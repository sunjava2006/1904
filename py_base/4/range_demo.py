# range(n) 给一个参数时，这个数列范围是从0~n(到n之前)
# range(a, b) 给两个参数时，这个数列的范围是从a~b(b之前)
# range(a, b, c) 给三个参数时，这个数列的范围是从a~b(b之前)，c是间隔的步长

for i in range(5):
    print(i, end=",")
print()

for i in range(1, 5):
    print(i, end=",")
print()

for i in range(0, 11 , 5):
    print(i, end=',')
print()

for i in 'china':
    print(i, end=',')