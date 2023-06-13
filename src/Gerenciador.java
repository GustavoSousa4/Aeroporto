
public class Gerenciador{
    private static Lista<Aeroporto> listaAeros = new Lista<Aeroporto>();
    
    public static void CriarAeropoto(){
        String sigla, cidade;
        try{
                System.out.println("Digite a  cidade em que fica o Aeroporto");
                cidade = Teclado.getUmString();
                System.out.println("Digite a sigla do Aeroporto [***]");
                sigla = Teclado.getUmString();
                System.out.println("Digite o código do Aeroporto");
                listaAeros.guardeUmItemNoFinal(new Aeroporto(cidade,sigla));

            }
            catch(Exception e){System.err.println(e.getMessage());}
    }
    public static void DeletarAeroporto(){
        String sigla;
        System.out.println("Digite a sigla do aeroporto que deseja excluir [***]");
        sigla = Teclado.getUmString();
        
    }
    public static void SelecionarAeroporto(){
        try{
            Aeroportos aeroportos = new Aeroportos();
            aeroportos.getListaAeroporto().toString();
        }
        catch(Exception e){System.err.println(e.getMessage());}
    }
    public static boolean siglaJaExiste(String sigla) throws Exception{
        for(int i = 0; i < listaAeros.getTamanhoLista(); i++){
            if(listaAeros.getIezima(i).getSigla().equals(sigla)) 
                return true;
        }
        return false;
    }
    public static void menu(){
        limparTela();
        String resposta = "";
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
                CriarAeropoto();
                case "b":
                SelecionarAeroporto();
            }
        }
        while(!resposta.equals("F"));
    }
    public static void limparTela(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}