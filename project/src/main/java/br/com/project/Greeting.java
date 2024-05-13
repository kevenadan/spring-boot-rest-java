package br.com.project;

public class Greeting {

	private Long id;
	private String name;
	
	public Greeting(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
