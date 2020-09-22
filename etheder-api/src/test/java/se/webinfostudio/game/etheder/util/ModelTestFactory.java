package se.webinfostudio.game.etheder.util;

import static java.util.UUID.randomUUID;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.api.model.user.UserTokenModel;

/**
 *
 * @author Johan Hanson
 *
 */
public final class ModelTestFactory {

	public static BuildingModel createBuildingModel() {
		return BuildingModel.newBuilder()
				.withBuildingId(randomUUID().toString())
				.withName("Barrack")
				.build();
	}

	public static BuildingQueueModel createBuildingQueueModel() {
		return BuildingQueueModel.newBuilder()
				.withBuildingName("Barrack")
				.withBuildingQueueId(randomUUID().toString())
				.withCityId(randomUUID().toString())
				.withDescription("Can create infantry")
				.build();
	}

	public static CityModel createCityModel() {
		return createCityModel(randomUUID().toString());
	}

	public static CityModel createCityModelNew() {
		return createCityModel(null);
	}

	public static LoginModel createLoginModel() {
		return LoginModel.newBuilder()
				.withUserName("userName")
				.withPassword("qwerty1234")
				.build();
	}

	public static PlayerModel createPlayerModel() {
		return createPlayerModel(randomUUID().toString());
	}

	public static PlayerModel createPlayerModelNew() {
		return createPlayerModel(null);
	}

	public static UserModel createUserModel() {
		return createUserModel(randomUUID().toString());
	}

	public static UserModel createUserModelNew() {
		return createUserModel(null);
	}

	public static UserTokenModel createUserTokenModel() {
		return UserTokenModel.newBuilder()
				.withToken(randomUUID().toString())
				.withUserName("userName")
				.build();
	}

	private static CityModel createCityModel(final String id) {
		return CityModel.newBuilder()
				.withCityId(id)
				.withName("Stockholm")
				.withPlayerId(randomUUID().toString())
				.build();
	}

	private static PlayerModel createPlayerModel(final String id) {
		return PlayerModel.newBuilder()
				.withCountry("Spain")
				.withName("John")
				.withPlayerId(id)
				.withUserId(randomUUID().toString())
				.build();
	}

	private static UserModel createUserModel(final String id) {
		return UserModel.newBuilder()
				.withAge(40)
				.withCountry("Sweden")
				.withEmail("user@example.org")
				.withFirstName("Johan")
				.withLastName("Hanson")
				.withUserId(id)
				.withUserName("slayer")
				.build();
	}

	private ModelTestFactory() {

	}
}
