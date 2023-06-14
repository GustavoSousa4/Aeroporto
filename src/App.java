public class App {
    public static void main(String[] args) throws Exception {
        try {
            Gerenciador.adicionarTodos();
            Gerenciador.menu();
            // // Escolhido: GTL GustavoLandia
            // // Lista de voos: [ BRL 090 -> MGL 800 ]
            // Aeroporto aerostavo = new Aeroporto("GustavoLandia", "GTL");
            // Aeroporto aeruno = new Aeroporto("BrunoLandia", "BRL");

            // aerostavo.guardeUmVoo(new Voo("BRL", "090"));
            // aeruno.guardeUmVoo(new Voo("GTL", "800"));

            // System.out.println(aerostavo.getListaDeVoos());
            // System.out.println(aeruno.getListaDeVoos());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
