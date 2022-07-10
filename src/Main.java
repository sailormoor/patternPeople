public class Main {
    public static void main(String[] args) {
        Person dad = new PersonBuilder()
                .setName("Гарри")
                .setSurname("Поттер")
                .setAge(31)
                .setAddress("Лондон")
                .build();
        Person son = dad.newChildBuilder()
                .setName("Альбус Северус")
                .build();
        System.out.println("У " + dad + " есть сын " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}