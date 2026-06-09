import java.util.ArrayList;
import java.util.Scanner;

public class UltimateTeam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Jogador> time = new ArrayList<>();

        Jogador capitao = null;

        while (true) {

            System.out.println("\n=== ULTIMATE TEAM ===");
            System.out.println("Jogadores: " + time.size() + "/11");
            if (capitao != null) {

                System.out.println("Capitão: " + capitao.nome);

                }
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Ver time");
            System.out.println("3 - Calcular overall");
            System.out.println("4 - Melhor jogador");
            System.out.println("5 - Definir capitão");
            System.out.println("6 - Estatísticas do elenco");
            System.out.println("7 - Remover jogador");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                if (time.size() >= 11) {

                    System.out.println("Elenco completo! Máximo de 11 jogadores.");

                    continue;
                }

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

                if (time.size() == 0) {

                    System.out.println("Time vazio!");

                } else {

                    for (Jogador j : time) {

                        System.out.println(
                            j.nome + " | " +
                            j.overall + " | " +
                            j.posicao
                        );

                    }

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

            else if (opcao == 4) {

                if (time.size() > 0) {

                    Jogador melhor = time.get(0);

                    for (Jogador j : time) {

                        if (j.overall > melhor.overall) {

                            melhor = j;

                        }

                    }
                    

                    System.out.println("\n⭐ MELHOR JOGADOR");

                    System.out.println(
                        melhor.nome + " | " +
                        melhor.overall + " | " +
                        melhor.posicao
                    );

                } else {

                    System.out.println("Time vazio!");

                }

            }

            else if (opcao == 5) {

    if (time.size() == 0) {

        System.out.println("Time vazio!");

    } else {

        System.out.println("\n=== ESCOLHER CAPITÃO ===");

        for (int i = 0; i < time.size(); i++) {

            Jogador j = time.get(i);

            System.out.println(
                (i + 1) + " - " +
                j.nome + " | " +
                j.overall + " | " +
                j.posicao
            );

        }

        System.out.print("Escolha o número do jogador: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha >= 1 && escolha <= time.size()) {

            capitao = time.get(escolha - 1);

            System.out.println(
                capitao.nome + " agora é o capitão do time!"
            );

        } else {

            System.out.println("Jogador inválido!");

                }

            }

        }

        else if (opcao == 6) {

    if (time.size() == 0) {

        System.out.println("Time vazio!");

    } else {

        Jogador melhor = time.get(0);
        Jogador pior = time.get(0);

        int soma = 0;

        for (Jogador j : time) {

            soma += j.overall;

            if (j.overall > melhor.overall) {
                melhor = j;
            }

            if (j.overall < pior.overall) {
                pior = j;
            }

        }

        int media = soma / time.size();

        System.out.println("\n=== ESTATÍSTICAS DO ELENCO ===");

        System.out.println("Jogadores: " + time.size());

        System.out.println("Overall Médio: " + media);

        System.out.println(
            "Melhor Jogador: " +
            melhor.nome +
            " (" + melhor.overall + ")"
        );

        System.out.println(
            "Pior Jogador: " +
            pior.nome +
            " (" + pior.overall + ")"
        );

        if (capitao != null) {

            System.out.println(
                "Capitão: " +
                capitao.nome
            );

        }

        else if (opcao == 7) {

    if (time.size() == 0) {

        System.out.println("Time vazio!");

    } else {

        System.out.println("\n=== REMOVER JOGADOR ===");

        for (int i = 0; i < time.size(); i++) {

            Jogador j = time.get(i);

            System.out.println(
                (i + 1) + " - " +
                j.nome + " | " +
                j.overall + " | " +
                j.posicao
            );

        }

        System.out.print("Escolha o número do jogador: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha >= 1 && escolha <= time.size()) {

            Jogador removido = time.remove(escolha - 1);

            if (capitao == removido) {

                capitao = null;

                System.out.println(
                    removido.nome +
                    " foi removido e deixou de ser capitão."
                );

            } else {

                System.out.println(
                    removido.nome +
                    " removido do elenco."
                );

            }

        } else {

            System.out.println("Jogador inválido!");

        }

    }

}

    }

}

            else if (opcao == 0) {

                break;

            }

            else {

                System.out.println("Opção inválida!");

            }

        }

        sc.close();

    }

}