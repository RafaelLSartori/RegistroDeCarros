import javax.swing.JOptionPane;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Metodos m = new Metodos();
        Carro[] carro = new Carro[5];

        for (int i = 0; i < 5; i++){
            carro[i] = new Carro();
        }

        int num = 0;
        int opc = 0;
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar carro\n2 - Ler carro\n3 - Busca chassi\n4 - Cadastrar\n9 - FIM"));
            switch (opc){
                case 1: carro = m.FGravarCarro(carro);
                    break;
                case 2: carro = m.FLerCarro(carro);
                    break;
                case 3: num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do chassi"));
                    m.PLocaliza(carro, num);
                    break;
                case 4: m.PClassifica100(carro);
                    break;
                case 9: JOptionPane.showMessageDialog(null,"FIM");
                    break;
                default:JOptionPane.showMessageDialog(null,"INVALIDO");
            }
        }
    }
}