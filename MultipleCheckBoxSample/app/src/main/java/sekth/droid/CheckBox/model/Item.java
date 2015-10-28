package sekth.droid.CheckBox.model;

public class Item {
    private long id;
    private String name;
    private String detail;
    private boolean selected;

    public Item(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Item() {
    }

    public Item(String nombre, String detalle) {
        this.name = nombre;
        this.detail = detalle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalles() {
        return detail;
    }

    public void setDetalles(String detalles) {
        this.detail = detalles;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", selected=" + selected +
                '}';
    }
}
