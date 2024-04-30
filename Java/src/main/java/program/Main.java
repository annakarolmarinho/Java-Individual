package program;

import bancoDeDados.CriarTabelas;
import bancoDeDados.InserirDadosNaTabela;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import util.ApresentarDados;
import util.Usuario;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CriarTabelas criarTabelas = new CriarTabelas();
        InserirDadosNaTabela inserindo = new InserirDadosNaTabela();
        ApresentarDados apresentarDados = new ApresentarDados();
        Usuario usuario = new Usuario();
        Boolean estaLogado = false;


        while (!estaLogado) {
            System.out.println("""
                      _____        __     _______     __        _____    _____    _____    _    _   _______
                     |  __ \\      /  \\   |__   __|   /  \\      / ____|  |_   _|  / ____|  | |  | | |__   __|
                     | |  | |    / /\\ \\     | |     / /\\ \\    | |         | |   | |  __   | |__| |    | |
                     | |  | |   / /__\\ \\    | |    / /__\\ \\    \\____ \\    | |   | | |_ |  |  __  |    | |
                     | |__| |  /  ____  \\   | |   /  ____  \\   _____) |  _| |_  | |__| |  | |  | |    | |
                     |_____/  /_/      \\_\\  |_|  /_/      \\_\\ |______/  |_____|  \\_____|  |_|  |_|    |_|                
                    """);

            System.out.println("Realizar Login");
            System.out.print("Email:");
            String email = sc.nextLine();
            System.out.print("Senha:");
            String senha = sc.nextLine();


            if (usuario.verificarUsuario(email, senha).equals(true)) {
                System.out.println("Acesso permitido");
                criarTabelas.criarTabelaBanco();
//            while (usuario.verificarUsuario(email, senha).equals(true)){
                inserindo.inserindoDadosNaTabela();
//                apresentarDados.pegarDadosTabela();
                dadosAtuais();
                estaLogado = true;

//            }
            } else {
                System.out.println("Acesso negado, email ou senha invalidos, tente novamente. \n");
            }
        }
    }
    public static void dadosAtuais(){
        Looca looca = new Looca();
        Timer coletaDados = new Timer();
        coletaDados.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                System.out.println("*------------------------------------*\n" +
                        " |           Dados Coletados          |\n" +
                        " *------------------------------------*\n" +
                        "                        " +
                        "\n|Nome máquina:" + looca.getRede().getParametros().getHostName() +
                        "\n|Tempo máquina ativa:" + formatarTempo(looca.getSistema().getTempoDeAtividade()) +
                        "\n|Consumo da CPU:" +  looca.getProcessador().getUso() +
                        "\n|Temperatura atual:" +  looca.getTemperatura() +
                        "\n|Consumo da RAM:" + Conversor.formatarBytes(looca.getMemoria().getEmUso()) +
                        "\n*------------------------------------*");
            }
        }, 0, 5000); // Agendado para iniciar imediatamente e repetir a cada 5000 ms (5 segundos)

    }

    public static String formatarTempo(long segundosTotal) {
        long segundos = segundosTotal % 60;
        long minutosTotal = segundosTotal / 60;
        long minutos = minutosTotal % 60;
        long horasTotal = minutosTotal / 60;
        long horas = horasTotal % 24;
        long dias = horasTotal / 24;

        return String.format("%d dias, %d h, %d m e %d s", dias, horas, minutos, segundos);
    }
}


