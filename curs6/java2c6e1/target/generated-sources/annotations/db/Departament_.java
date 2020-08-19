package db;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departament.class)
public abstract class Departament_ {

	public static volatile SingularAttribute<Departament, Integer> id;
	public static volatile CollectionAttribute<Departament, Programator> programatori;

	public static final String ID = "id";
	public static final String PROGRAMATORI = "programatori";

}

