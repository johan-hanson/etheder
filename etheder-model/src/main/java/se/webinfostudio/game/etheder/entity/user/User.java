package se.webinfostudio.game.etheder.entity.user;

import static java.lang.String.format;

import java.util.UUID;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;

/**
 *
 * @author Johan Hanson
 */
public class User extends AbstractGameEntity implements HasReference<UserRef> {

	private static final long serialVersionUID = 7089932666191926795L;

	private UUID loginId;

	private String firstName;
	private String lastName;
	private String country;
	private Integer age;
	private String email;

	public Integer getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public UUID getLoginId() {
		return loginId;
	}

	public String getName() {
		return format("%s %s", firstName, lastName);
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setLoginId(final UUID loginId) {
		this.loginId = loginId;
	}

	@Override
	public UserRef toRef() {
		return new UserRef(this);
	}

}
