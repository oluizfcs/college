package calculadora;

public class Calculadora {
    
    private Double numero1, numero2;
    
    public Double getNumero1() {
        return this.numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return this.numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public Double somar() {
        return numero1 + numero2;
    }
    
    public Double subtrair() {
        return numero1 - numero2;
    }
    
    public Double multiplicar() {
        return numero1 * numero2;
    }
    
    public Double dividir() {
        return numero1 / numero2;
    }
}