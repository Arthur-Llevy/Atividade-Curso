package meusclientes;

public class Cliente {
    private int ID;
    private String NOME;
    private String TELEFONE;
    private String CELULAR;
    private String EMAIL;
    
    public Cliente(int id, String nome, String telefone, String celular, String email){
        this.ID = id;
        this.NOME = nome;
        this.TELEFONE = telefone;
        this.CELULAR = celular;
        this.EMAIL = email;
    }
    
    public Cliente(){}
    
    public Cliente(String nome, String telefone, String celular, String email){
        this.NOME = nome;
        this.TELEFONE = telefone;
        this.CELULAR = celular;
        this.EMAIL = email;
    }
    
    public int getId(){
        return ID;
    }
    
    public void setId(int id){
        this.ID = id;
    }
    
    public String getNome(){
        return NOME;
    }
    
    public void setNome(String nome){
        this.NOME = nome;
    }
    
    public String getCelular(){
        return CELULAR;
    }
    
    public void setCelular(String celuluar){
        this.CELULAR = celuluar;
    }
    
    public String getTelefone(){
        return TELEFONE;
    }
    
    public void setTelefone(String telefone){
        this.TELEFONE = telefone;
    }
    
    public String getEmail(){
        return EMAIL;
    }
    
    public void setEmail(String email){
        this.EMAIL = email;
    }
    
    
    
}
