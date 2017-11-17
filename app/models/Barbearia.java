package models;

import play.data.*;
import javax.persistence.*;
import io.ebean.*;

public class Barbearia extends Model {
    
    public String nome;
    public int numero;

    public static final Finder<Long, Barbearia> find = new Finder<>(Barbearia.class);
    
}