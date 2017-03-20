package hello;

public class Greeting {
  private String name = "name";

  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getMessage(){
    return "Hello " + this.name;
  }
}
