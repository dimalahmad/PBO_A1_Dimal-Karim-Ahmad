package package2;

import package1.*;

public class Library {

    public User admin;

    public String getOwnerIdentity() {
        String name = admin.name;
        String id = admin.getId();
        int age = admin.age;

        admin.printUserIdentity();

        return  "Owner buku ini adalah : " + name + " umur : " + age + "id : " + id;
    }


}
