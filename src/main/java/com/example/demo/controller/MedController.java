package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.Meddetail;
import com.example.demo.repositories.MedUserRepository;
import com.example.demo.repositories.UserRepository;



@Controller
public class MedController {

	// @GetMapping("/signup")
	// public String signupAction(Model model) {
	// model.addAttribute("message", "Enter Your Details");
	// return "signup";
	// }

	@Autowired
	private MedUserRepository userRepository;

	// @PostMapping("/signup")
	// public String signupActionProcess(Users userData,Model model) {

	// Users n = new Users();
	// n.setMedicinename(userData.getMedicinename());
	// n.setMedicinedetail(userData.getMedicinedetail());
	// n.setPrice(userData.getPrice());
	// userRepository.save(n);

	// model.addAttribute("message", "The user details entered successfully");
	// return "signup";
	// }

	@GetMapping("/all")
	public String getAllUsers(Model model) {
		Iterable<Meddetail> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "list";
	}

	@GetMapping("/select-by-id/{id}")
	public String getSpecificUserById(@PathVariable("id") Integer id, Model model) {
		Optional<Meddetail> userData = userRepository.findById(id);
		Meddetail userDetails = userData.get();
		model.addAttribute("userdetails", userDetails);
		return "userDetails";
	}

	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable(value = "id") Integer id, Model model) {
		Optional<Meddetail> optionaluserdetails = userRepository.findById(id);
		Meddetail userdetails = optionaluserdetails.get();

		model.addAttribute("id", id);
		model.addAttribute("userdetails", userdetails);
		return "update";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @RequestParam("medicinename") String medicinename,
			@RequestParam("medicinedetail") String medicinedetail, Model model) {

		Optional<Meddetail> optionaluserdetails = userRepository.findById(id);
		Meddetail userdetails = optionaluserdetails.get();
		userdetails.setMedicinename(medicinename);
		userdetails.setMedicinedetail(medicinedetail);

		userRepository.save(userdetails);
		return "redirect:/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(value = "id") Integer id, Model model) {
		Optional<Meddetail> optionaluserdetails = userRepository.findById(id);
		Meddetail userdetails = optionaluserdetails.get();

		model.addAttribute("id", id);
		model.addAttribute("userdetails", userdetails);
		return "delete";
	}

	@PostMapping("/delete/{id}")
	public String deleteUserById(@PathVariable("id") Integer id, Model model) {
		Optional<Meddetail> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			userRepository.deleteById(id);
			return "redirect:/all";
		} else {
			return "delete"; 
		}
	}

	@PostMapping("/search")
	public String searchMedicineByName(@RequestParam("keyword") String keyword, Model model) {
		List<Meddetail> users = userRepository.findByMedicinenameStartingWith(keyword);
		model.addAttribute("users", users);
		return "list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("user", new Meddetail());
		return "add";
	}

	@PostMapping("/add")
	public String addUser(Meddetail user, RedirectAttributes redirectAttributes) {
	    userRepository.save(user);
	    redirectAttributes.addFlashAttribute("message", "User added successfully");
	    return "redirect:/all";
	}


}