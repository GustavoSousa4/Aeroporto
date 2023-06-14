
public class Gerenciador {
    private static Lista<Aeroporto> listaAeros = new Lista<Aeroporto>();

    public static void criarAeropoto() {
        String sigla, cidade;
        try {
            System.out.println("Digite a  cidade em que fica o Aeroporto: ");
            cidade = Teclado.getUmString();
            System.out.println("Digite a sigla do Aeroporto [***]");
            sigla = Teclado.getUmString();
            if (siglaJaExiste(sigla)) {
                System.out.println("Sigla já existente. O aeroporto não pode ser criado com esta sigla");
                criarAeropoto();
            }
            listaAeros.guardeUmItemNoFinal(new Aeroporto(cidade, sigla));
            System.out.println("Aeroporto criado com sucesso");
            System.out.println("Pressione enter");
            Teclado.getUmString();
            menu();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void criarVoo() throws Exception {
        String destino, codVoo;
        listarAeroportos();
        System.out.println("Em qual aeroporto deseja fazer a adição?: ");
        Aeroporto escolhido = listaAeros.getIezima(Teclado.getUmInt() - 1);

        System.out.println("Qual será o aeroporto de destino ?");
        destino = Teclado.getUmString();
        System.out.println("Qual o número deste voo? ");
        codVoo = Teclado.getUmString();
        if (!siglaJaExiste(destino)) {
            System.out.println("Sigla inexistente. Deseja criar um novo Aeroporto? (s/n): ");
            if (Teclado.getUmString().toLowerCase().equals("s")) {
                criarAeropoto();
            } else {
                menu();
            }
        }
        try {
            escolhido.guardeUmVoo(new Voo(destino, codVoo));
            menu();
        } catch (Exception e) {
            System.err.println("Algum dado está incorreto. Vamos criar novamente!");
            criarVoo();
        }
    }

    public static void excluirUmVoo() throws Exception {
        listarAeroportos();
        System.out.println("Em qual aeroporto deseja fazer a adição?: ");
        Aeroporto escolhido = listaAeros.getIezima(Teclado.getUmInt() - 1);
        String codVoo, sigla;
        System.out.println("Digite o a sigla de destino do voo que deseja excluir: ");
        sigla = Teclado.getUmString();
        System.out.println("Digite o codigo do voo que deseja excluir: ");
        codVoo = Teclado.getUmString();
    }

    public static void listarVoosDeUmAeroporto() throws Exception {
        listarAeroportos();
        System.out.println("De qual aeroporto deseja listar os voos? ");
        Aeroporto atual = listaAeros.getIezima(Teclado.getUmInt() - 1);
        System.out.println(atual + "Lista de voos: " + atual.getListaDeVoos());
    }

    public static void listarTodosOsVoos() throws Exception {
        Aeroporto atual;
        for (int i = 0; i < listaAeros.getTamanhoLista(); i++) {
            atual = listaAeros.getIezima(i);
            System.out.println((i + 1) + " - " + atual + "Lista de voos: " + atual.getListaDeVoos());
        }
    }

    public static void listarAeroportos() throws Exception {
        for (int i = 0; i < listaAeros.getTamanhoLista(); i++)
            System.out.println((i + 1) + " - " + listaAeros.getIezima(i));
    }

    public static boolean siglaJaExiste(String sigla) throws Exception {
        for (int i = 0; i < listaAeros.getTamanhoLista(); i++) {
            if (listaAeros.getIezima(i).getSigla().equals(sigla))
                return true;
        }
        return false;
    }

    public static void menu() {
        limparTela();
        String resposta = "";
        do {
            try {
                System.out.println("Olá, qual função você deseja utilizar? ");
                System.out.println(
                        "[A] Incluir Aeroporto\n[B] Listar Todos Aeroportos\n[C] Listar um Aeroporto  \n[D] Incluir Voo  \n[E] Excluir Voo  \n[F] Sair");
                resposta = Teclado.getUmString().toLowerCase();
                if (resposta != "A" || resposta != "B" || resposta != "C" || resposta != "D" || resposta != "E"
                        || resposta != "F")
                    throw new Exception("Reposta inválida");
            } catch (Exception e) {
                e.getMessage();
            }
            try {
                switch (resposta.toLowerCase()) {
                    case "a":
                        limparTela();
                        criarAeropoto();
                        break;
                    case "b":
                        limparTela();
                        listarTodosOsVoos();
                        break;
                    case "c":
                        limparTela();
                        listarVoosDeUmAeroporto();
                        break;
                    case "d":
                        limparTela();
                        criarVoo();
                        break;
                    case "e":
                        limparTela();
                        excluirUmVoo();
                        break;

                    case "f":
                        limparTela();
                        System.out.println("Até logo!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!resposta.equals("F"));
    }

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}