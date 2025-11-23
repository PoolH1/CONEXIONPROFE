package clase;

public class Accesorio {
private String codAcce,nomAcce,marcaAcce;
private double preAcce;
private int stockAcce;
public Accesorio(String codAcce, String nomAcce, String marcaAcce, double preAcce, int stockAcce) {
	this.codAcce = codAcce;
	this.nomAcce = nomAcce;
	this.marcaAcce = marcaAcce;
	this.preAcce = preAcce;
	this.stockAcce = stockAcce;
}
public String getCodAcce() {
	return codAcce;
}
public void setCodAcce(String codAcce) {
	this.codAcce = codAcce;
}
public String getNomAcce() {
	return nomAcce;
}
public void setNomAcce(String nomAcce) {
	this.nomAcce = nomAcce;
}
public String getMarcaAcce() {
	return marcaAcce;
}
public void setMarcaAcce(String marcaAcce) {
	this.marcaAcce = marcaAcce;
}
public double getPreAcce() {
	return preAcce;
}
public void setPreAcce(double preAcce) {
	this.preAcce = preAcce;
}
public int getStockAcce() {
	return stockAcce;
}
public void setStockAcce(int stockAcce) {
	this.stockAcce = stockAcce;
}

}
