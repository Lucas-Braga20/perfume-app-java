package br.unigran.perfume.projeto.models;

import br.unigran.perfume.projeto.models.Cargo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T18:04:53", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ extends Usuario_ {

    public static volatile SingularAttribute<Funcionario, String> nome;
    public static volatile SingularAttribute<Funcionario, Cargo> cargo;

}