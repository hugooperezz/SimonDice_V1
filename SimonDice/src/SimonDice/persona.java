package SimonDice;

public class persona {
	private String nombre;
	private int puntuacion;

	// Método para establecer el nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Método para obtener el nombre
	public String getNombre() {
		return this.nombre;
	}

	// Método para establecer la puntuación
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	// Método que retorna la puntuación
	public int getPuntuacion() {
		return this.puntuacion; 
	}
}
