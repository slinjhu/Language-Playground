class World {
    private static World instance = null;

    private World(){
        System.out.println("Private Constructor called");
    }

    public static World getInstance() {
        if(instance == null){instance = new World();}
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args){
        World world1 = World.getInstance();
        World world2 = World.getInstance();
        World world3 = World.getInstance();
    }
}
