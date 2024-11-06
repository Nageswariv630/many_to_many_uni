package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PrintStudentsNameByBatchId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Batch Id:");
		int bid=sc.nextInt();
		Batch b=em.find(Batch.class, bid);
		List<Student>sl=b.getStudents();
		List<Batch>bl=em.createQuery("from Batch").getResultList();
		for(Batch bb:bl) {
			List<Student>ssl=bb.getStudents();
			if(ssl.containsAll(sl)) {
				System.out.println(bb.getName());
			}
		}
		
	}
	

}
