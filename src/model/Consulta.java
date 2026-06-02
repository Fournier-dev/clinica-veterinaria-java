package model;

public class Consulta {

    private Animal animal;
    private String data;
    private String status;

    public Consulta(
            Animal animal,
            String data,
            String status) {

        this.animal = animal;
        this.data = data;
        this.status = status;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}