import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SitemaPrincipal {


    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean coninuarTentando;
        boolean atendeu;
        do{
            atendeu = atender();
            coninuarTentando = !atendeu;
            if(coninuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("contato Realizado Com Sucesso");
        }while (coninuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Cnsegumos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("nõ consegumos contato com" + candidato + ", numero maximo de tentativas alcançados " + tentativasRealizadas);
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("imprimindo a lista de candidatos informando o indice do elemento");
                for(int indice = 0; indice< candidatos.length;indice++){
                    System.out.println("o candidato de nº "+ (indice +1)+ " é "+ candidatos[indice]);
                }
        System.out.println("Forma abrevia de intereção for each ");
                for(String candidato: candidatos){
                    System.out.println("O candidato selecionado foi " + candidato);
                }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        int canditatosSelecionados=0;
        int candidatoAtual =0;
        double salarioBase = 2000.0;
        while(canditatosSelecionados<5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O Candidato" + candidato + "solicitou este valor de salario"+ salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + "Foi selecionado");
                canditatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar Para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar Para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");

        }
    }
}
