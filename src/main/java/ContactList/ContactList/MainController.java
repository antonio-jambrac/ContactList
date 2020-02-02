package ContactList.ContactList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private ContactDAO contactDao;
	
	@GetMapping(value="/")
	public String welcomPage(ModelMap model) {
		List<Contact> listContact = contactDao.list();
		model.put("listContact", listContact);
		return "index";
	}
	
	@GetMapping(value = "/new")
	public String newContact(ModelMap model) {
		model.addAttribute("listContact", new Contact());
		return "contactForm";
	}
	
	@PostMapping(value = "/save")
	public String returnForm(@ModelAttribute Contact listContact) {
		if(listContact.getId() == null) {
			contactDao.save(listContact);
		} else {
			contactDao.update(listContact);
		}
		return "redirect:/";
	}
	
	@GetMapping(value = "/edit")
	public String editContact(HttpServletRequest request, ModelMap model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDao.get(id);
		model.put("listContact", contact);
		return "contactForm";
	}
	
	@GetMapping (value = "/delete")
	public String deleteContact(@RequestParam int id) {
		contactDao.delete(id);
		return "redirect:/";
	}
}
