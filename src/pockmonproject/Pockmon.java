
package pockmonproject;

public class Pockmon {

    private int id;
    private String name, type;
    private int attak;
    private int defense;
    private int total;

    public Pockmon() {
        id = 0;
        name = "";
        type = "";
        attak = 0;
        defense = 0;
        total = 0;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", name=" + name + ", type=" + type + ", attak=" + attak + ", defense=" + defense + ", total=" + total ;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttak() {
        return attak;
    }

    public void setAttak(int attak) {
        this.attak = attak;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
