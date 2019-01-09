package pru03e07;

public class Article {
	String codi = "LLIURE";
	String descripcio;
	double preuDeCompra;
	double preuDeVenda;
	int stock;
	
	public String getCodi() {
		return codi;
	}
	
	public void setCodi(String codi) {
		this.codi = codi;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	public double getPreuDeCompra() {
		return preuDeCompra;
	}
	
	public void setPreuDeCompra(double preuDeCompra) {
		this.preuDeCompra = preuDeCompra;
	}
	
	public double getPreuDeVenda() {
		return preuDeVenda;
	}
	
	public void setPreuDeVenda(double preuDeVenda) {
		this.preuDeVenda = preuDeVenda;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		String cadena = "-----------------------------------------";
		cadena += "\nCodi: " + this.codi;
		cadena += "\nDescripcio: " + this.descripcio;
		cadena += "\nPreu de compra: " + this.preuDeCompra;
		cadena += "\nPreu de venda: " + this.preuDeVenda;
		cadena += "\nStock: " + this.stock + " unitats";
		cadena += "\n------------------------------------------";
		return cadena;
	}	
}