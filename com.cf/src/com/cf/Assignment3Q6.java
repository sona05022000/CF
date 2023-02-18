package com.cf;

import java.util.*;

class Chatroom {
	private String name;
	private Set<String> username;
	private List<String> messages;

	public Chatroom(String name) {
		this.name = name;
		this.username = new HashSet<>();
		this.messages = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public boolean addUser(String username) {
		return this.username.add(username);
	}

	public boolean removeUser(String username) {
		return this.username.remove(username);
	}

	public boolean addMessage(String message) {
		return messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}

	public Set<String> getUsers() {
		return username;
	}
}

class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

class ChatApplication {

	private Map<String, Chatroom> chatrooms = new HashMap<>();
	private Map<String, User> users = new HashMap<>();
	private Set<String> loggedInUsers = new HashSet<>();

	public boolean isChatroomNameValid(String name) {
		return name != null && !name.trim().isEmpty() && !chatrooms.containsKey(name);
	}

	public boolean isUsernameExists(String username) {
		return users.containsKey(username);
	}

	public boolean authenticateUser(String username, String password) {
		if (users.containsKey(username)) {
			User user = users.get(username);
			return user.getPassword().equals(password);
		}
		return false;
	}

	public void createChatroom() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter chatroom name: ");
		String name = scanner.nextLine();
		if (isChatroomNameValid(name)) {
			Chatroom chatroom = new Chatroom(name);
			chatrooms.put(name, chatroom);
			System.out.println("Chatroom created successfully.");
		} else {
			System.out.println("Invalid chatroom name. Please try again.");
		}
	}

	public void addNewUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		if (isUsernameExists(username)) {
			System.out.println("Username already exists. Please try again.");
			return;
		}
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		System.out.println("Enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lastName = scanner.nextLine();
		User user = new User(username, password, firstName, lastName);
		users.put(username, user);
		System.out.println("User added successfully.");
	}

	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		if (authenticateUser(username, password)) {
			loggedInUsers.add(username);
			System.out.println("Login successful.");
			return true;
		} else {
			System.out.println("Invalid username or password. Please try again.");
			return false;
		}
	}

	public void sendMessage() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter chatroom name: ");
		String chatroomName = scanner.nextLine();
		if (!chatrooms.containsKey(chatroomName)) {
			System.out.println("Chatroom does not exist. Please try again.");
			return;
		}
		System.out.println("Enter message: ");
		String message = scanner.nextLine();
		Chatroom chatroom = chatrooms.get(chatroomName);
		chatroom.addMessage(message);
		System.out.println("Message sent successfully.");
	}

	public void printMessages() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter chatroom name: ");
		String chatroomName = scanner.nextLine();
		if (!chatrooms.containsKey(chatroomName)) {
			System.out.println("Chatroom does not exist. Please try again.");
			return;
		}
		Chatroom chatroom = chatrooms.get(chatroomName);
		List<String> messages = chatroom.getMessages();
		System.out.println("Messages in chatroom " + chatroomName + ":");
		for (String message : messages) {
			System.out.println(message);
		}
	}

	public void listUsersFromChatroom() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter chatroom name: ");
		String chatroomName = scanner.nextLine();
		if (!chatrooms.containsKey(chatroomName)) {
			System.out.println("Chatroom does not exist. Please try again.");
			return;
		}
		Chatroom chatroom = chatrooms.get(chatroomName);
		Set<String> users = chatroom.getUsers();
		System.out.println("Users in chatroom " + chatroomName + ":");
		for (String user : users) {
			System.out.println(user);
		}
	}

	public void logout() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		if (!loggedInUsers.contains(username)) {
			System.out.println("User is not logged in. Please try again.");
			return;
		}
		loggedInUsers.remove(username);
		System.out.println("User logged out successfully.");
	}

	public void deleteUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		if (!users.containsKey(username)) {
			System.out.println("User does not exist. Please try again.");
			return;
		}
		users.remove(username);
		System.out.println("User deleted successfully.");
	}

	public void deleteChatroom() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter chatroom name: ");
		String chatroomName = scanner.nextLine();
		if (!chatrooms.containsKey(chatroomName)) {
			System.out.println("Chatroom does not exist. Please try again.");
			return;
		}
		chatrooms.remove(chatroomName);
		System.out.println("Chatroom deleted successfully.");
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Options:");
			System.out.println("A) Create a chatroom");
			System.out.println("B) Add a user");
			System.out.println("C) User login");
			System.out.println("D) Send a message");
			System.out.println("E) Display the messages from a specific chatroom");
			System.out.println("F) List down all users belonging to the specified chat room");
			System.out.println("G) Logout");
			System.out.println("H) Delete a user");
			System.out.println("I) Delete the chat room");
			System.out.println("Please enter your option:");
			String option = scanner.nextLine();
			switch (option) {
			case "A":
				createChatroom();
				break;
			case "B":
				addNewUser();
				break;
			case "C":
				login();
				break;
			case "D":
				sendMessage();
				break;
			case "E":
				printMessages();
				break;
			case "F":
				listUsersFromChatroom();
				break;
			case "G":
				logout();
				break;
			case "H":
				deleteUser();
				break;
			case "I":
				deleteChatroom();
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}

public class Assignment3Q6 {
	public static void main(String[] args) {
		ChatApplication chatApplication = new ChatApplication();
		chatApplication.menu();
	}
}