package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveStudentFromAllBatchesByStudentId {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Id:"); 
		int sid=sc.nextInt();
		Student std=em.find(Student.class, sid);
		if(std==null) {
			System.out.println("Invalid Student Id:");
			return;
		}
		List<Batch>bl=em.createQuery("from Batch").getResultList();
		for(Batch b:bl) {
		   List<Student>sl=b.getStudents();
		   if(sl.contains(std)) {
			   
			   sl.remove(std);
		   }
		   b.setStudents(sl);
		   et.begin();
		   em.merge(b);
		   et.commit();
		}
		System.out.println("Done");
	}

}
//concurrent modification exception