# Домашняя работа по теме: Magics, DRY, SOLID

## Описание

Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.

Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется 
свобода в продумывании функциональности вашей программы, как и в проектировании её структуры.
В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум
4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать 
по одному примеру применения каждого принципа в вашем решении.

## Решение

* **Single-responsibility principle.** Применяется во многих классах. Например: 
 [ReaderCSV](src/main/java/ru/netology/reader_writer/ReaderCSV.java), 
 [Bill](src/main/java/ru/netology/bill/Bill.java),
 [CountPrice](src/main/java/ru/netology/CountPrice.java),
 [Product](src/main/java/ru/netology/Product.java).
* **Open-Closed principle.** Например, в классе 
  [Product](src/main/java/ru/netology/Product.java) переопределен метод toString. Так же
этот метод переопределен в 
  [Products](src/main/java/ru/netology/Products.java). 
  Но вместо того, чтобы писать код заново, используется toString из Product.
* **Liskov substitution principle.** В конструкторе класса
  [Bill](src/main/java/ru/netology/bill/Bill.java) в качестве типа
  аргумента используется родитель 
  [TaxTypeCountry](src/main/java/ru/netology/bill/tax_type/TaxTypeCountry.java).
  Принимает же конструктор экземпляр класса наследника 
  [TaxTypeRu](src/main/java/ru/netology/bill/tax_type/TaxTypeRu.java).
* **Interface segregation principle.** В пакете 
  [reader_writer](src/main/java/ru/netology/reader_writer) интерфейсы MyReader, MyWriter
  разделены. Но в то же время оба реализуются в классе ReaderWriterJSON. И только MyReader
  реализуется в классе ReaderCSV.
* **Dependency inversion principle.** В методе main класса
 [Main](src/main/java/ru/netology/Main.java) данные о товарах считываются
из файла CSV. Для этого объявляется reader типа MyReader. А инициализируется он уже
конструктором класса ReaderCSV.