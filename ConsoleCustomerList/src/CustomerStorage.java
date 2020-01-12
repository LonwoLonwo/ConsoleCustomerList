import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if(components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format: add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[0] + " " + components[1];
        if(!components[2].matches("[a-zA-Z0-9_\\-.]+@[a-zA-Z0-9]+?\\.[a-zA-Z]{2,}")){
            throw new IllegalArgumentException("Wrong e-mail format. Try again");
        }
        if(!components[3].matches("[+()0-9-\\s]+")){
            throw new IllegalArgumentException("Wrong phone number. Try again");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if(storage.containsKey(name)) {
            storage.remove(name);
        }
        else{
            throw new IllegalArgumentException("This person " + name + " is not on the list. Try again");
        }
    }

    public int getCount()
    {
        return storage.size();
    }
}