package br.unigran.perfume.projeto.models;

import br.unigran.perfume.projeto.models.Cliente;
import br.unigran.perfume.projeto.models.Funcionario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T18:04:53", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Float> valor;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile SingularAttribute<Venda, Funcionario> funcionario;

}