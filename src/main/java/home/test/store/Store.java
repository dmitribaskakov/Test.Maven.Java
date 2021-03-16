package home.test.store;

// Класс Магазин, хранящий произведенные товары
public class Store {
    @SuppressWarnings("FieldCanBeLocal")
    final private int maxProduct=3;
    private int product=0;
    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        product--;
        System.out.println("Покупатель " + Thread.currentThread().getName() + " купил 1 товар. Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=maxProduct) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        product++;
        System.out.println("Производитель " + Thread.currentThread().getName() + " добавил 1 товар. Товаров на складе: " + product);
        notify();
    }
}
