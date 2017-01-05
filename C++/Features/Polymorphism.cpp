#include<iostream>
using namespace std;

class Animal{
public:
  virtual void say(){cout << "Sound\n";}
};

class Cat : public Animal{
public:
  void say(){cout << "Meow\n";}
};

class Dog : public Animal{
public:
  void say(){cout << "Bark\n";}
};

int main(){
  Animal cat = Cat();
  Animal dog = Dog();
  cat.say();
  dog.say();

  // Use pointer for polymorphism
  Animal* pcat = new Cat();
  Animal* pdog = new Dog();
  pcat->say();
  pdog->say();

}
