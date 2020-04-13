import datetime

class Human:
    # def __init__(self, name, age, birthdate):
    #     self.name = name
    #     self.age = age
    #     self.birthdate = birthdate

    # def __str__(self):
    #     return "{}name:{}, age:{}, birthdate:{}{}"\
    #     .format("{",self.name, self.age, self.birthdate.strftime('%Y-%m-%d'), "}")
    
    # def work(self):
    #     print("%s工作中..."%(self.name) )
    
    def work(self):
        print('working......')


def a():
    print('--------------')

if __name__ == "__main__":
    h1 = Human()
    # h1 = Human('Wang', 20, datetime.date(2009,6,4))
    # print(h1)
    h1.work()
    h1.name='Li'
    print(h1.name)

    h1.eat=a
    h1.eat()
    

