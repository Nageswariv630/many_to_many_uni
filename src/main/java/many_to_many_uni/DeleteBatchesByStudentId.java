package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteBatchesByStudentId {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Id:"); 
		int sid=sc.nextInt();
		Student std=em.find(Student.class, sid);
		List<Batch>bl=em.createQuery("from Batch").getResultList();
		for(Batch b:bl) {
			List<Student>sl=b.getStudents();
			if(sl.contains(std)) {
				//b.setStudents(null);
				et.begin();
				em.remove(b);
				et.commit();
			}
			
		}
		System.out.println("Done");
	}

}
