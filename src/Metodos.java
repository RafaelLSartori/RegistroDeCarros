import javax.swing.JOptionPane;
import java.io.*;

public class Metodos {
    public Carro[] FGravarCarro(Carro[] carro) throws IOException{
        String fileName = "RegistroDeCarros.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < 5; i++){
            carro[i].modelo = JOptionPane.showInputDialog("Digite o modelo: ");
            gravar.write(carro[i].modelo);
            gravar.newLine();
            carro[i].chassi = Integer.parseInt(JOptionPane.showInputDialog("Digite o chassi: "));
            gravar.write(Integer.toString(carro[i].chassi));
            gravar.newLine();
            carro[i].ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro: "));
            gravar.write(Integer.toString(carro[i].ano));
            gravar.newLine();
            carro[i].placa = Integer.parseInt(JOptionPane.showInputDialog("Digite a placa: "));
            gravar.write(Integer.toString(carro[i].placa));
            gravar.newLine();
        }
        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!");
        gravar.close();
        return carro;
    }
    public Carro[] FLerCarro(Carro[] carro) throws IOException{
        String fileName = "RegistroDeCarros.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        for (int i = 0; i > 5; i++){
            carro[i].modelo = ler.readLine();
            carro[i].chassi = Integer.parseInt(ler.readLine());
            carro[i].ano = Integer.parseInt(ler.readLine());
            carro[i].placa = Integer.parseInt(ler.readLine());
        }
        JOptionPane.showMessageDialog(null,"Leitura realizada com sucesso!");
        return carro;
    }

    public void PLocaliza(Carro[] carro, int n){
        int verifica = FRecChassi(carro, n, 0);

        if (verifica > 5){
            JOptionPane.showMessageDialog(null,"Erro!");
        } else {
            System.out.println(carro[verifica].chassi);
        }
    }

    public int FRecChassi(Carro[] carro, int n, int i){
        if (i > 5 || carro[i].chassi == n){
            return i;
        } else {
            return FRecChassi(carro, n, (i+1));
        }
    }

    public void PClassifica100(Carro[] carro) throws IOException{
        String fileName2 = "Antigos.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName2));

        Carro[] cadastro = new Carro[3];

        for (int i = 0; i < 3; i++){
            cadastro[i] = new Carro();
        }

        Carro aux;
        for (int i = 0; i < 4; i++){
            for (int j = (i+1); j < 5; j++){
                if (carro[i].ano > carro[j].ano){
                    aux = carro[i];
                    carro[i] = carro[j];
                    carro[i] = aux;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            cadastro[i].modelo = carro[i].modelo;
            gravar.write(cadastro[i].modelo);
            gravar.newLine();
            cadastro[i].chassi = carro[i].chassi;
            gravar.write(Integer.toString(cadastro[i].chassi));
            gravar.newLine();
            cadastro[i].ano = carro[i].ano;
            gravar.write(Integer.toString(cadastro[i].ano));
            gravar.newLine();
            cadastro[i].placa = carro[i].placa;
            gravar.write(Integer.toString(cadastro[i].placa));
        }
        JOptionPane.showMessageDialog(null,"Gravação realizada com sucesso!");
        gravar.close();
    }
}
