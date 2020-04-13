ci = ['自古逢秋悲寂寥','我言秋日胜春朝','晴空一鹤排云上','便引诗情到碧霄']

ci.insert(0, '秋词')
ci.append('————刘禹锡')
del ci[0]

ci.remove('————刘禹锡')

# ci[0] = '自古逢秋悲寂寥,'


for i, item in enumerate(ci):
    if i%2 == 0:
        ci[i] = item+','
    else:
        ci[i] = ci[i]+'。'

for i in ci[:]:
    print(i)

print('“晴空一鹤排云上”出现次数{}'.format(ci.count('晴空一鹤排云上,')))

print('晴空一鹤排云上,在第{}句出现'.format(ci.index('晴空一鹤排云上,')+1))


print('*' * 20)

# ci.sort()
ci = sorted(ci)
for i in ci:
    print(i)

