import java.io.Console;

public class Gerenciador{
    private int codigoAero, codViagem;
    private String sigla, cidade;
    public void CriarAeropoto(){
            try{
                System.out.println("Digite a  cidade em que fica o Aeroporto");
                this.cidade = Teclado.getUmString();
                System.out.println("Digite a sigla do Aeroporto [***]");
                this.sigla = Teclado.getUmString();
                System.out.println("Digite o código do Aeroporto");
                this.codigoAero = Teclado.getUmInt();
                Aeroporto aeroporto = new Aeroporto(this.cidade,this.sigla,this.codigoAero);
                Aeroportos aeroportos = new Aeroportos(aeroporto);
            }
            catch(Exception e){System.err.println(e.getMessage());}
    }
    public void DeletarAeroporto(){
        System.out.println("Digite a sigla do aeroporto que deseja excluir [***]");
        this.sigla = Teclado.getUmString();
    }
    public void SelecionarAeroporto(){
        try{
            Aeroportos aeroportos = new Aeroportos();
            aeroportos.getListaAeroporto().toString();
        }
        catch(Exception e){System.err.println(e.getMessage());}
    } 
}