public class App {
    public static void main(String[] args) throws Exception {
        try {
            Gerenciador.adicionarTodos();
            Gerenciador.menu();
        } 
        catch (Exception e) {System.err.println(e.getMessage());}
    }
}
