import java.util.Observable;
import java.util.Observer;

class Model extends Observable{
    private int data;

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
        // Notify all observers
        super.setChanged();
        super.notifyObservers();
    }
}

class View implements Observer{
    private static int count = 0;
    private final int id;

    public View(){
        id = count++;
    }

    @Override
    public void update(Observable o, Object arg){
        Model model = (Model) o;
        System.out.println("View " + this.id + " received update: " + model.getData());
    }
}

public class ObserverPattern{
    public static void main(String[] args){
        Model model = new Model();

        model.addObserver(new View());
        model.addObserver(new View());
        model.addObserver(new View());

        model.setData(5);
    }
}
