import java.util.ArrayList;
import java.util.Scanner;

public class UltimateTeam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Jogador> time = new ArrayList<>();

        while (true) {

            System.out.println("\n=== ULTIMATE TEAM ===");
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Ver time");
            System.out.println("3 - Calcular overall");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Overall: ");
                int overall = sc.nextInt();
                sc.nextLine();

                System.out.print("Posição: ");
                String posicao = sc.nextLine();

                Jogador jogador = new Jogador(nome, overall, posicao);

                time.add(jogador);

                System.out.println("Jogador adicionado!");

            }

            else if (opcao == 2) {

                System.out.println("\n=== SEU TIME ===");

                for (Jogador j : time) {
                    System.out.println(
                        j.nome + " | " +
                        j.overall + " | " +
                        j.posicao
                    );
                }

            }

            else if (opcao == 3) {

                int soma = 0;

                for (Jogador j : time) {
                    soma += j.overall;
                }

                if (time.size() > 0) {

                    int media = soma / time.size();

                    System.out.println(
                        "Overall do time: " + media
                    );

                } else {
                    System.out.println("Time vazio!");
                }

            }

            else if (opcao == 0) {
                break;
            }

        }

        sc.close();
    }
}