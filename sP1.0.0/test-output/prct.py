class Student:
    no_of_students = 10
    def __init__(self, name, age):
       self.name = name
       self.age = age
    def birthday(self):
       self.age += 1
       return f"{self.name} has now turned {self.age}\n" \
              f"{self.no_of_students - 1} students of his" \
              f" class have sent Birthday gifts."
student1 = Student("Chan", 13)
print(student1.birthday())