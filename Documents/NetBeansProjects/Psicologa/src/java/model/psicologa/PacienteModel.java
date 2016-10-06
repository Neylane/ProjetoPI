package model.psicologa;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "Tb_Paciente")
public class PacienteModel{
   
    @Id
    private String nome;
    private int telefone;
    private String endereco;
    private int idade;
    private int rg;
    private String cpf;
    private String numConsultas;
    private int codigo;
    
    public PacienteModel(String nome , int telefone , String endereco ,
            int idade, int rg , String cpf , String numConsultas,int codigo){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade;
        this.rg = rg;
        this.cpf = cpf;
        this.numConsultas = numConsultas;
        this.codigo = codigo;
    }
@Deprecated
    public PacienteModel() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumConsultas() {
        return numConsultas;
    }

    public void setNumConsultas(String numConsultas) {
       this.numConsultas =  numConsultas;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
   
        
        
    }

