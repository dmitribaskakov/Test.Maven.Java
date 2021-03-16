package home.test.store;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

// Класс Магазин, хранящий произведенные товары
public class Store {
    @SuppressWarnings("FieldCanBeLocal")
    final private int maxProduct = 3;
    private int product = 0;

//    public synchronized void get() {
//        while (product<1) {
//            try {
//                wait();
//            } catch (InterruptedException e) {}
//        }
//        product--;
//        System.out.println("Покупатель " + Thread.currentThread().getName() + " купил 1 товар. Товаров на складе: " + product);
//        notify();
//    }
//    public synchronized void put() {
//        while (product>=maxProduct) {
//            try {
//                wait();
//            } catch (InterruptedException e) {}
//        }
//        product++;
//        System.out.println("Производитель " + Thread.currentThread().getName() + " добавил 1 товар. Товаров на складе: " + product);
//        notify();
//    }

    ReentrantLock locker;
    Condition notFull;
    Condition notEmpty;

    Store(){
        locker = new ReentrantLock(); // создаем блокировку
        notFull = locker.newCondition(); // получаем условие, связанное с блокировкой
        notEmpty = locker.newCondition(); // получаем условие, связанное с блокировкой
    }

    public void get() {
        locker.lock();
        try {
            // пока нет доступных товаров на складе, ожидаем
            while (product<1)
                notEmpty.await();

            product--;
            System.out.println("Покупатель " + Thread.currentThread().getName() + " купил 1 товар. Товаров на складе: " + product);

            // сигнализируем
            notFull.signal();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        } finally{
            locker.unlock();
        }
    }
    public void put() {

        locker.lock();
        try {
            // пока на складе maxProduct товара, ждем освобождения места
            while (product>=maxProduct)
                notFull.await();

            product++;
            System.out.println("Производитель " + Thread.currentThread().getName() + " добавил 1 товар. Товаров на складе: " + product);
            // сигнализируем
            notEmpty.signal();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        } finally{
            locker.unlock();
        }
    }
}
