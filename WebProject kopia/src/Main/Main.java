package Main;

import java.sql.SQLException;

import se.web_project.*;
import se.web_project.categories.*;
import se.web_project.categories.Categories.*;
import se.web_project.Data.*;
import se.web_project.products.Products.*;
import se.web_project.shoppingbasket.*;
import se.web_project.shoppingbasket.Shoppingbasket.*;
import se.web_project.user.*;
import se.web_project.eCommerceService.*;
import se.web_project.eCommerceService.ECommerceService.*;
import se.web_project.user.User.*;

public class Main {

	public static void main(String args[]) {
		UsersRepository usersRepository = new MySQLUsersRepository();
		UsersRepository eCommerceServiceUser = new ECommerceService(usersRepository);
		

		User Katarina = new User(15);
		Katarina.setFirstName("mark");
		Katarina.setLastName("Lund");
		Katarina.setEMail("katarina.thebeuty2@comhem.se");
		Katarina.setPassword("Asianliger23");
		Katarina.setStreetAddress("Bjursatragatan37");
		Katarina.setCity("Bandhagen");
		Katarina.setPostcode("19867");
		Katarina.setPhoneNumber("08-453 5667");
		// eCommerceServiceUser.createUser(Katarina);

		User Annie = new User(14);
		Annie.setFirstName("Annie");
		Annie.setLastName("Lomnas");
		Annie.setEMail("annie.lomnas1@comhem.se");
		Annie.setPassword("Coimbatore86");
		Annie.setStreetAddress("Bjursatragatan37");
		Annie.setCity("Bandhagen");
		Annie.setPostcode("12536");
		Annie.setPhoneNumber("08-897 6976");
		// eCommerceServiceUser.createUser(Annie);

		User Peter = new User(13);
		Peter.setFirstName("Peter");
		Peter.setLastName("Jarn");
		Peter.setEMail("Peter.Jarn1@comhem.se");
		Peter.setPassword("Peter.jarneke@86");
		Peter.setStreetAddress("Hornsgatan45");
		Peter.setCity("Stockholm");
		Peter.setPostcode("11454");
		Peter.setPhoneNumber("08-675 2341");
		// eCommerceServiceUser.createUser(Peter);

		User Martin = new User(12);
		Martin.setFirstName("Martin");
		Martin.setLastName("Saving");
		Martin.setEMail("martin_saving1@gmail.com");
		Martin.setPassword("martin89saving15");
		Martin.setStreetAddress("BuckinghamPalace");
		Martin.setCity("London");
		Martin.setPostcode("32454");
		Martin.setPhoneNumber("0044-1234 2341");
		// eCommerceServiceUser.createUser(Martin);

		User Bertil = new User(11);
		Bertil.setFirstName("Bertil");
		Bertil.setLastName("Bengtsson");
		Bertil.setEMail("bengan_kokos@gmail.com");
		Bertil.setPassword("bengtmajskorv");
		Bertil.setStreetAddress("Soffliggargatan1");
		Bertil.setCity("Tumba");
		Bertil.setPostcode("12458");
		Bertil.setPhoneNumber("08-865 8943");
		// eCommerceServiceUser.createUser(Bertil);

		User Anki = new User(16);
		Anki.setFirstName("Anki");
		Anki.setLastName("Andersson");
		Anki.setEMail("ankan_kokos@gmail.com");
		Anki.setPassword("korvfia_mobils");
		Anki.setStreetAddress("Sopprotsvagen55");
		Anki.setCity("Tullinge");
		Anki.setPostcode("16522");
		Anki.setPhoneNumber("08-899 2213");
		// eCommerceServiceUser.createUser(Anki);

		User Tina = new User(18);
		Tina.setFirstName("Tina");
		Tina.setLastName("Bertilsson");
		Tina.setEMail("tiina78_kokosbabe@gmail.com");
		Tina.setPassword("tiinaMumbai");
		Tina.setStreetAddress("Dannemoragatan32");
		Tina.setCity("Stockholm");
		Tina.setPostcode("11354");
		Tina.setPhoneNumber("08-34 6574");
		// eCommerceServiceUser.createUser(Tina);

		User Sandra = new User(19);
		Sandra.setFirstName("Sandra");
		Sandra.setLastName("Huldt");
		Sandra.setEMail("sandra78_teatere@gmail.com");
		Sandra.setPassword("allianceteater");
		Sandra.setStreetAddress("Hornsgatan32");
		Sandra.setCity("Stockholm");
		Sandra.setPostcode("11323");
		Sandra.setPhoneNumber("08-34 2132");
		// eCommerceServiceUser.createUser(Sandra);

		// ********************************************************
		// Delete method is ready.
		//eCommerceServiceUser.deleteUser(28);
		// ********************************************************
		// UPDATE!
		Katarina.getUserId();
		Katarina.setFirstName("Katarina");
		Katarina.setLastName("Lund");
		Katarina.setEMail("Katarina.bandhagenflower3@comhem.se");
		Katarina.setPassword("Asianliger23");
		Katarina.setStreetAddress("Bjursatragatan37");
		Katarina.setCity("Bandhagen");
		Katarina.setPostcode("19867");
		Katarina.setPhoneNumber("08-453 5667");
		// eCommerceServiceUser.updateUser(Katarina);
		
		//eCommerceServiceUser.getAllUsers();
		System.out.println(eCommerceServiceUser.getAllUsers());

		// **********************************************************************
		ProductsRepository productsRepository = new MySQLProductsRepository();
		ECommerceService eCommerceServiceProducts = new ECommerceService(
				productsRepository);

		// *********************************
		// CREATE!
		
		Products Horse = new Products(7);
		Horse.getProductId();
		Horse.setProductName("Adventure");
		Horse.setDescription("Pet");
		Horse.setCost(1200);
		Horse.setRrp(2300);
		
		//eCommerceServiceProducts.createProduct(Horse);

		Products Shoe = new Products(6);
		Shoe.getProductId();
		Shoe.setProductName("High_Class");
		Shoe.setDescription("Coctail_Shoes");
		Shoe.setCost(120);
		Shoe.setRrp(200);

		// eCommerceServiceProducts.createProduct(Shoe);

		Products Gardening = new Products(8);
		Gardening.getProductId();
		Gardening.setProductName("Your best guide to the perfect garden");
		Gardening.setDescription("Books");
		Gardening.setCost(80);
		Gardening.setRrp(170);

		// eCommerceServiceProducts.createProduct(Gardening);
		
		Products Pool = new Products(9);
		Pool.getProductId();
		Pool.setProductName("All year round");
		Pool.setDescription("Pool");
		Pool.setCost(1300);
		Pool.setRrp(2000);
		
		//eCommerceServiceProducts.createProduct(Pool);
		
		Products Swing = new Products(10);
		Swing.getProductId();
		Swing.setProductName("To the sky");
		Swing.setDescription("Toy");
		Swing.setCost(150);
		Swing.setRrp(230);
		
		//eCommerceServiceProducts.createProduct(Swing);
		
		
		// ******************************************
		// UPDATE!
		//Gardening.getProductId();
		Gardening.setProductName("The book for your garden");
		Gardening.setDescription("New book");
		Gardening.setCost(90);
		Gardening.setRrp(190);

		//eCommerceServiceProducts.updateProduct(Gardening);
		//***********************************************
		//DELETE!!
		//eCommerceServiceProducts.deleteProduct(7);
		
		
		//eCommerceServiceProducts.getAllProducts();
		
		
		//******************************************************************************
		CategoriesRepository categoriesRepository = new MySQLCategoriesRepository();
		CategoriesRepository eCommerceServiceCategories = new ECommerceService(categoriesRepository);
		
		//CREATE
		Categories Music = new Categories(12);
		Music.getCategoryId();
		Music.setCategoryName("Music");
		Music.setStaffId("27");
		//eCommerceServiceCategories.createCategories(Music);
		
		Categories Entertainment = new Categories(13);
		Entertainment.getCategoryId();
		Entertainment.setCategoryName("Home_Entertainment");
		Entertainment.setStaffId("27");
		//eCommerceServiceCategories.createCategories(Entertainment);
		
		//UPDATE
		Music.getCategoryId();
		Music.setCategoryName("PopMusic");
		Music.setStaffId("68");
		//eCommerceServiceCategories.updateCategories(Music);
		
		//DELETE
		//eCommerceServiceCategories.deleteCategories(13);
		
		

	}
}
