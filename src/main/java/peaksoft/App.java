package peaksoft;

import peaksoft.config.HibernateConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HibernateConfig.getEntityManager();
        HibernateConfig.creatSessionFactory();
    }
}
