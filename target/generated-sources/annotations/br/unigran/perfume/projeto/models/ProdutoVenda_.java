package br.unigran.perfume.projeto.models;

import br.unigran.perfume.projeto.models.Produto;
import br.unigran.perfume.projeto.models.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T18:04:52", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(ProdutoVenda.class)
public class ProdutoVenda_ { 

    public static volatile SingularAttribute<ProdutoVenda, Venda> venda;
    public static volatile SingularAttribute<ProdutoVenda, Produto> produto;
    public static volatile SingularAttribute<ProdutoVenda, Float> valor;
    public static volatile SingularAttribute<ProdutoVenda, Integer> id;
    public static volatile SingularAttribute<ProdutoVenda, Integer> quantidade;

}