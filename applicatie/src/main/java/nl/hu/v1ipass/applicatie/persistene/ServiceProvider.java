package nl.hu.v1ipass.applicatie.persistene;

public class ServiceProvider {
	private static Service service = new Service();
	
	public static Service getService() {
		return service;
	}
}