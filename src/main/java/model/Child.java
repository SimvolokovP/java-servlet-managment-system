package model;

public class Child {
    private int id;
    private  String name;
    private int age;
    private String gender;
    private String group;

    public Child() {
        super();
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public Child(int id, String name, int age, String gender, String group) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.group = group;
    }

    public Child(String name, int age, String gender, String group) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
