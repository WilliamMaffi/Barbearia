package models;

import play.data.*;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class Produto extends Model {
    
    @Id
    public long id;
    public String nome, descricao, unidade;
    public Double preco;
    public String especificacao;

    public static final Finder<Long, Produto> find = new Finder<>(Produto.class);
}