package com.example;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Foo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void setupHibernate(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
            .addAnnotatedClass(Foo.class)
            .buildMetadata()
            .buildSessionFactory();

        Session session = sessionFactory.openSession();
        var tr = session.beginTransaction();
        Foo foo = new Foo();
        foo.id = UUID.randomUUID();
        foo.name = "jesus";
        foo.dni="12345A";
        
        //Foo foo = session.get(Foo.class,1);
        //session.remove(Foo.class, 1);
        // if (foo!= null){
        //     session.remove(Foo.class,1);    
        //  }
        session.persist(foo);
        tr.commit();
        session.close();

    }
}
