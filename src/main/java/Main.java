import ru.netology.managers.ProductManager;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Book(1, "Crime and Punishment", 345, "Dostoevsky");
        Product product2 = new Smartphone(2, "Galaxy", 24567, "Samsung");
        Product product3 = new Book(3, "For whom the Bell Tolls", 567, "Hemingway");
        Product product4 = new Smartphone(4, "Iphone", 45897, "Apple");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        repo.removeById(2);

        Product[] all = repo.findAll();
    }

}
