public class Carro {
    String modelo;
    int chassi;
    int ano;
    int placa;

    Carro(){
        this( "", 0, 0, 0);
    }

    Carro(String modelo, int chassi, int ano, int placa){
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.placa = placa;
    }
}
