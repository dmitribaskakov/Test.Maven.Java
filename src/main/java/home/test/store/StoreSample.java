package home.test.store;

// Пример даботы тредов
public class StoreSample {

    public static void test () {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
