#include<iostream>
#include<vector>
using namespace std;

// Use abstract class as interface
class Observer{
public:
  virtual void notify(string msg) = 0;
};

class Data{
private:
  // Data does not depend on Display
  vector<Observer*> observers;
public:
  void addObserver(Observer* ob){
    observers.push_back(ob);
  }
  void setData(int x){
    for(Observer* ob : observers){
      ob->notify("Data set to " + to_string(x));
    }
  }
};

class Display : public Observer{
private:
  Data* data;
public:
  Display(Data* d) : data(d){
    data->addObserver(this);
    data->setData(6);
  }
  void notify(string msg) override{
    cout << "Notified: " << msg << endl;
  }
};


int main(){
  Data dt;
  Display dis(&dt);
}


