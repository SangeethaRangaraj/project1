package com.proj.loginproj;

import javax.servlet.http.HttpServlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class UserDataBase extends HttpServlet {

	static DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	public static boolean createOrUpdate(String username, String firstname,
			String lastname, String password, String phonenumber, String email) {

		Entity user = new Entity("user", username);
		com.google.appengine.api.datastore.Key key = KeyFactory.createKey(
				"user", username);

		user.setProperty("username", username);
		user.setProperty("firstname", firstname);
		user.setProperty("lastname", lastname);
		user.setProperty("password", password);
		user.setProperty("phonenumber", phonenumber);
		user.setProperty("email", email);
		datastore.put(user);
		return true;
	}

	public static boolean loginUser(String username, String password)
			throws EntityNotFoundException {
		System.out.println("userpassword" + password + "username" + username);
		String uname = null;
		String pwd = null;

		Entity user = new Entity("user", username);
		com.google.appengine.api.datastore.Key key = KeyFactory.createKey(
				"user", username);
		Entity newEnt = datastore.get(key);

		pwd = (String) newEnt.getProperty("password");
		System.out.println("the pwdd is" + pwd);
		if (pwd.equalsIgnoreCase(password)) {
			return true;
		}
		return false;

		

	}

	public static void deleteUser(String name) {
		System.out.println("inside delete method");
		com.google.appengine.api.datastore.Key user = KeyFactory.createKey(
				"user", name);
		datastore.delete(user);
	}
}
