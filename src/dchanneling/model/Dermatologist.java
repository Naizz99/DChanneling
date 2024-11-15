package auroraskincare.model;

public class Dermatologist {
    private int id;
    private String name;
    
    public Dermatologist(String name) {
        this.name = name;
    }
    
    public Dermatologist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getId() { return id; }
    public void setId(int name) { this.id = id; }
}

