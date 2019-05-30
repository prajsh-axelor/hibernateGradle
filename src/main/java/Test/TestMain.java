package Test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<FavFoodDetail> food = new ArrayList<>();
		food.add(new FavFoodDetail("puri",22));
		food.add(new FavFoodDetail("puri",23));
		food.add(new FavFoodDetail("puri",24));
		food.add(new FavFoodDetail("puri",25));
		food.add(new FavFoodDetail("puri",26));
		food.add(new FavFoodDetail("puri",27));
		
		List<Person> list = new ArrayList<>();
		list.add(new Person(19,"Prajjwal","Singh",23));
		list.add(new Person(13,"Prajjwal","Singh",24));
		list.add(new Person(14,"Prajjwal","Singh",25));
		list.add(new Person(15,"Prajjwal","Singh",26));
		list.add(new Person(16,"Prajjwal","Singh",27));
		list.add(new Person(17,"Prajjwal","Singh",28));
		list.add(new Person(18,"Prajjwal","Singh",29));
		
		SessionFactory factory = new Configuration().configure("hibernate_test.cfg.xml").addAnnotatedClass(Person.class)
				.addAnnotatedClass(FavFoodDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
				
		try {
			
			
			session.beginTransaction();
			list.stream().forEach(obj -> session.save(obj));
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}

	}

}

@Entity
@Table(name="person")
class Person {
	@Id
	@Column(name="id")
	private int roll;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="age")
	private int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="menu")
	private FavFoodDetail favFood;
	
	public Person() {}

	public Person(int roll, String firstName, String lastName, int age) {
		super();
		this.roll = roll;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public FavFoodDetail getFavFood() {
		return favFood;
	}

	public void setFavFood(FavFoodDetail favFood) {
		this.favFood = favFood;
	}
	
	
}

@Entity
@Table(name="favfooddetail")
class FavFoodDetail {
	@Id
	@Column
	private String menu;
	@Column
	private int price;
//	private List<String> lst;
	
	public FavFoodDetail() {
		
	}
	public FavFoodDetail(String menu, int price) {
		super();
		this.menu = menu;
		this.price = price;
//		this.lst = getList();
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//	public List<String> getLst() {
//		return lst;
//	}
//	public void setLst(List<String> lst) {
//		this.lst = lst;
//	}
//	
//	private List<String> getList() {
//		return Arrays.asList("A","B","C","D","E","F");
//	} 
	
}