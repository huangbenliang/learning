package $01;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {


	private Customer customer;
	private Movie movieXiao;
	private Movie movieDaMing;

	@BeforeAll
	 void init() {
		customer = new Customer("小明");
		movieXiao = new Movie("肖申克的救赎", Movie.NEW_RELEASE);
		movieDaMing = new Movie("大明风华", Movie.REGULAR);
	}

	@Test
	@DisplayName("测试statement")
	public void customerTest() {
		customer.addRental(new Rental(movieXiao, 2));
		customer.addRental(new Rental(movieDaMing, 2));

		Assertions.assertEquals(customer.statement(), "Rental Record for小明\n" +
				"\t肖申克的救赎\t6.0\n" +
				"\t大明风华\t2.0\n" +
				"Amount owed is 8.0\n" +
				"Your earned 3 frequent renter points");
	}
}
