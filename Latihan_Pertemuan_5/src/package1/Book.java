package package1;

public class Book {
    public User owner;

    public String getOwnerIdentity() {
        String name = owner.name;
        String id = owner.getId();
        int age = owner.age;

        return  "Owner buku ini adalah : " + name + " umur : " + age + "id : " + id;


    }
}
