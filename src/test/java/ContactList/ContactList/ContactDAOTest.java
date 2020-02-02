package ContactList.ContactList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class ContactDAOTest {
	
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/contactdv");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		
		dao = new ContactDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Contact contact = new Contact("Marko Polo", "onBoath@see.com", "deck 001", "pigin 16");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(5, "Marko Polo", "onBoath@see.com", "deck 001", "pigeon 16");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 5;
		Contact contact = dao.get(id);
		
		if(contact != null)
			System.out.println(contact);
		
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 5;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listContacts = dao.list();
		
		for(Contact aContact : listContacts ) {
			System.out.println(aContact);
		}
		assertTrue(!listContacts.isEmpty());
	}

}
