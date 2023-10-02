package com.burak;

public class Main {
    public static void main(String[] args) {

    }
    /*
    1-NativeQuery Nedir?
NativeQuery bir veritabanı sorgusunu SQL veya başka bir IDE ile çalıştırmak için kullanılan
terimdir.Veritabanı işlemleri gerçekleştirmek için kullanılan işlevler veya ORM araçları ile yapılan
veritabanı işlemlerinden farklıdır.
NativeQuery adımları:
1-Sorgu Olusturmak.Bu sorgu belirli işlemleri gerçekleştirmek için kullanılır.
2-Sorgunun Çalışması
3-Sorgunun Alınması
Avantajları
Veritabanı ile doğrudan iletişim kurması sayesinde daha fazla kontrol sağlamasıdır.Karmaşık sorgularda ve
özel işlemlerde kullanışlı olur.
Dezavantajları
Veritabanına bağımlılığa yol açabilir ve kodun daha az taşınabilir olmasına neden olabilir.Ayrıca güvenlik
riskleri ortaya çıkayabilir.Kullanıcıdan alınan girdiler doğrudan SQL sorgusuna dahil edildiğinde SQL
enjeksiyon saldırılarına neden olabilir.
Genel olarak;
NativeQuery kullanımı belirli durumlarda gereklidir.ORM daha fazla tercih edilendir.Çünkü ORM daha
taşınabilir ve güvenli bir yöntem sunar.
JDBC kütüphanesi kullanarak bir PostgreSQL veritabanına erişim sağlayıp SQL sorgusu çalıştırma
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class NativeQueryExample {
public static void main(String[] args) {
String url = "jdbc:postgresql://localhost:5432/mydatabase";String username = "myuser";String password
= "mypassword";
try {
Connection connection = DriverManager.getConnection(url, username, password);
String sqlQuery = "SELECT * FROM customers WHERE country = 'USA' ”;
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sqlQuery);
while (resultSet.next()) {
int customerId = resultSet.getInt("customer_id");
String customerName = resultSet.getString("customer_name");
String contactName = resultSet.getString("contact_name")
;String country = resultSet.getString("country");System.out.println("Customer ID: " + customerId);
System.out.println("Customer Name: " + customerName);
System.out.println("Contact Name: " + contactName);System.out.println("Country: " + country);
System.out.println("--------------");
}
resultSet.close();
statement.close();
connection.close();
}
catch (Exception e) {
e.printStackTrace();
}
}
}
//Bu örnekte PostgreSQL veritabanına bağlanmak için JDBC kullanılıp SQL sorgusu alınıp ResultSet nesnesi
üzerine işlenmiştir.NativeQuery kullanarak veritabanına erişim sağlama örneğidir.


2.SORU:HQL ve JPQL Nedir? ORNEKLERI İLE AÇIKLAYINIZ
HQL->Hibernate Query Language
JPQL->Java Persistence Query Language
İlişkisel veritabanına sorgular yapmak için kullanılan iki farklı sorgu dili olup,genellikle ORM ile
ilişkilendirirler.
HQL özellikle Hibernate gibi ORM kullanırken JPQL ile birlikte kullanılamaz.
HQL
Hibernate ORM çerçevesinin bir parçası olarak geliştirilen özgün sorgu dili kullanılır.
Tablolarların yerine Java nesneleriyle çalışmayı sağlar.
Veritabanından bağımsızdır.Farklı veritabanlarına geçiş yapmak daha kolaydır.
Orn->Select p FROM Person p WHERE p.age >18
JPQL
JPQL JPA standartlarına uygun olan herhangi bir JPA uyumlu ORM çerçevesi ile kullanılabilir.
JPQL,JPA ile birlikte gelen sorgu dili olarak hizmet eder ve JPA ile uyumlu ORM çerçeveleri ile kullanılır.


--HQL--
public class HQLExample {
public static void main(String[] args) {
SessionFactory sessionFactory = new
Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
Session session = sessionFactory.openSession();
String hql = "FROM Person WHERE age > :age";List<Person> persons =
session.createQuery(hql).setParameter("age", 18).list();
for (Person person : persons) {
System.out.println("ID: " + person.getId() + ", Name:

--JPQL--
public class JPQLExample {
 public static void main(String[] args) {
 // EntityManagerFactory oluşturma
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
 EntityManager em = emf.createEntityManager();
 String jpql = "SELECT p FROM Person p WHERE p.age > :age";
 Query query = em.createQuery(jpql);
 query.setParameter("age", 18);
 List<Person> persons = query.getResultList();
 for (Person person : persons) {
 System.out.println("ID: " + person.getId() + ", Name: " + person.getName() + ", Age: " +
person.getAge());
 } em.close();
emf.close();
 }}
3-NamedQuery Nedir Nasıl kullanılır Ornekleri ile açıkayınız
NameQuery Java Persistence API(JPA) ile ilişkilendirilmiş veritabanı sorgularını adlandırmak ve yönetmek
için kullanılan bir özelliktir.NamedQuery sorguyu adlandırmamıza ve kodda kullanmamıza olanak tanır.
NamedQuery kullanmanın temel adımları;
Entity Sınıfı Olusturma:Sorguyu çalıştırmak istediğiniz veritabanı tablosu temsil eden JPA varlık sınıfı
(entity class) olusturmak gereklidir.
NamedQuery Tanımlama:Entity sınıfının üzerine veya ayrı bir XML dosyasına sorgunuzu tanımlamak
gereklidir.
Xml config
<named-query name="findPersonsByAge">
 <query>SELECT p FROM Person p WHERE p.age > :age</query>
</named-query>
Named Query Kullanma:Sorguyu kullanmak istediğiniz yerde,EntityManager kullanarak adı kullanabiliriz
EntityManager em = entityManagerFactory.createEntityManager();
TypedQuery<Person> query = em.createNamedQuery("findPersonsByAge", Person.class);
query.setParameter("age", 18);
List<Person> persons = query.getResultList();
for (Person person : persons) {
 System.out.println("ID: " + person.getId() + ", Name: " + person.getName() + ", Age: " +
person.getAge());
}
em.close();


     */
}