package sekth.droid.lvPersonalizado;

public class Item {
	private long id;
	private String name;
	
	public Item(long id, String nombre){
		this.id = id;
		this.name = nombre;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
