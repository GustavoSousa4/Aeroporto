public class App {
    public static void main(String[] args) throws Exception {
        String resposta = "", sigla, cidade;
        int codigoAero = 0;
        Aeroporto aeroporto;
        Aeroportos aeroportos;
        Gerenciador gerenciador = new Gerenciador();
        do{
        try{
            System.out.println("Olá, qual função você deseja utilizar? ");
            System.out.println("[A] Incluir Aeroporto \n [B] Deletar Aeropoto \n [C] Incluir Voo \n [D] Excluir Voo \n [E] Selecionar Todos Aeroportos e Voos \n [F] Sair");
            resposta = Teclado.getUmString().toUpperCase();
            if(resposta != "A" || resposta != "B" || resposta != "C" || resposta != "D" || resposta != "E" || resposta != "F")
                throw new Exception("Reposta inválida");
        }
        catch(Exception e)
        {e.getMessage();} 
        switch(resposta.toLowerCase()){
            case "a":
            gerenciador.CriarAeropoto();
            case "b":
            gerenciador.SelecionarAeroporto();
        }
    }while(!resposta.equals("F"));
    }
}
