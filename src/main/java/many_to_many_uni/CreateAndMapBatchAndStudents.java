package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapBatchAndStudents {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student s1=new Student(0,"nageswari","nageswariv630@gmail.com");
		Student s2=new Student(0,"nasrin","nasrin@gmail.com");
		Student s3=new Student(0,"nandini","nandini@gmail.com");
		Student s4=new Student(0,"puji","puji@gmail.com");
		Student s5=new Student(0,"shaima","shaima@gmail.com");
		List<Student>students=new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		Batch b1=new Batch(0,"Advance Java","JHE-JFFADD-M6",students);
		Batch b2=new Batch(0,"Core Java","JHE-JFFADD-M7",students);
		Batch b3=new Batch(0,"Sql","JHE-JFFADD-M8",students);
		Batch b4=new Batch(0,"WebTech","JHE-JFFADD-M9",students);
		Batch b5=new Batch(0,"React","JHE-JFFADD-M5",students);
		
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		et.commit();
		System.out.println("Done..");
	}

}
