#include<iostream>
#include<assert.h>
using namespace std;

class Singleton{
private:
  Singleton(){
    cout << "Private Constructor\n";
  }
public:
  static Singleton* getInstance(){
    static Singleton instance;
    return &instance;
  }
};

int main(){
  Singleton* s1 = Singleton::getInstance();
  Singleton* s2 = Singleton::getInstance();
  assert(s1 == s2);
}
