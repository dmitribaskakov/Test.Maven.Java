package home.test.Singleton;

public class SingletonImpl {
    private static SingletonImpl self = null;

    private SingletonImpl() {
        super();
        // perform initialization here
        self = this;
    }

//    окончательный вариант реализации Singleton в случае отложенной инициализации.
//    public static synchronized SingletonImpl getInstance(){
//        return (self == null) ? new SingletonImpl() : self;
//    }

    //Double-checked locking
    public static SingletonImpl getInstance() {
        if (self == null) {
            synchronized(SingletonImpl.class) {
                if (self == null) {
                    self = new SingletonImpl();
                }
            }
        }
        return self;
    }
}
