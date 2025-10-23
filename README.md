**project1-hibernate-basics**

. Hibernate setup (Maven/Gradle)

. Configuration with hibernate.cfg.xml or application.properties

. SessionFactory and Session

. Basic CRUD template for a single entity

. Show SQL and refactor

**project2-hibernate-crud**

. Create, Read, Update, Delete operations

. Using persist(), find(), merge(), remove()

. Transaction management - except for find()

. @Table, @Column, @Transient

**project3-hibernate-relationships**

. @Embeddable (Student table has laptop details merged) ==> 1 table gets created (student)

. One-to-One mapping (student table will have laptop id) ==> 2 tables gets created (student, laptop)

. One-to-Many /Many-to-One mapping (each table will remain same columns & creates third new table) ==> 3 tables gets created (student, laptop, student_laptop)
                       As laptop table can have alien_id, we can remove third table by using mappedby)

. Many-to-Many mapping (total 4 tables will be created) ==> student, laptop, student_laptop, laptop_student
                      We can remove one extra table by using mappedby either on any side.

. Eager & Lazy (Hibernate by-default provides lazy fetch)
