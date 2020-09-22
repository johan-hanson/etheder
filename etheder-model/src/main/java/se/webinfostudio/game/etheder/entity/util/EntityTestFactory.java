package se.webinfostudio.game.etheder.entity.util;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.player.Army;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.entity.unit.Unit;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 */
public final class EntityTestFactory {

	public static BuildingDataTestFactory.Builder buildBuildingData() {
		return BuildingDataTestFactory.newBuilder();
	}

	public static LoginTestFactory.Builder buildLogin() {
		return LoginTestFactory.newBuilder();
	}

	public static PlayerTestFactory.Builder buildPlayer() {
		return PlayerTestFactory.newBuilder();
	}

	public static ResearchTestFactory.Builder buildResearch() {
		return ResearchTestFactory.newBuilder();
	}

	public static UnitDataTestFactory.Builder buildUnitData() {
		return UnitDataTestFactory.newBuilder();
	}

	public static UserTestFactory.Builder buildUser() {
		return UserTestFactory.newBuilder();
	}

	public static Army createArmy() {
		final Army army = new Army();
		army.setId(UUID.randomUUID());
		army.setName(Army.DEFAULT_NAME);
		army.setNrOfInfantry(10);
		army.setNrOfArcher(10);
		return army;
	}

	/**
	 * Creates a building instance.
	 *
	 * @return {@link Building}
	 */
	public static Building createBuilding() {
		return createBuilding(randomUUID());
	}

	public static Building createBuilding(final UUID id) {
		final Building b = new Building();
		b.setId(id);
		b.setBuildingDataId(1L);
		return b;
	}

	public static BuildingData createBuildingData() {
		return BuildingDataTestFactory.newBuilder().build();
	}

	public static BuildingData createBuildingData(final Long id, final String name, final UnitType unitType) {
		return buildBuildingData()
				.withId(id)
				.withName(name)
				.withUnitType(unitType)
				.withDescription("description")
				.withTicks(10)
				.build();
	}

	public static BuildingQueue createBuildingQueue() {
		return createBuildingQueue(randomUUID(), randomUUID(), Long.valueOf(1l));
	}

	public static BuildingQueue createBuildingQueue(final UUID queueId, final UUID cityId, final Long buildingId) {
		final BuildingQueue bq = new BuildingQueue();
		bq.setId(queueId);
		bq.setTicks(10);
		bq.setCityId(cityId);
		bq.setBuildingId(buildingId);
		return bq;
	}

	public static City createCity() {
		return createCity(UUID.randomUUID(), "Paris");
	}

	public static City createCity(final UUID id, final String name) {
		final City city = new City();
		city.setId(id);
		city.setName(name);
		city.setAcres(20);
		city.setFarmers(20);
		city.setIronminers(20);
		city.setMerchants(20);
		city.setStonemasons(20);
		city.setPopulation(500L);
		city.setPlayerId(id);
		return city;
	}

	public static Login createLogin() {
		return LoginTestFactory.newBuilder().build();
	}

	public static Player createPlayer() {
		return PlayerTestFactory.newBuilder().build();
	}

	public static Research createResearch() {
		return ResearchTestFactory.newBuilder().build();
	}

	public static Research createResearch(final Long id, final String name, final Integer level,
			final UnitType unitType) {
		return buildResearch()
				.withId(id)
				.withName(name)
				.withLeveel(level)
				.withUnitType(unitType)
				.build();
	}

	public static ResearchQueue createResearchQueue() {
		return createResearchQueue(randomUUID(), randomUUID(), Long.valueOf(1L));
	}

	public static ResearchQueue createResearchQueue(final UUID queueId, final UUID playerId, final Long researchId) {
		final ResearchQueue rq = new ResearchQueue();
		rq.setId(queueId);
		rq.setTicks(10);
		rq.setPlayerId(playerId);
		rq.setResearchId(researchId);
		return rq;
	}

	public static Unit createUnit() {
		return createUnit(UUID.randomUUID(), "Barracks", UnitType.INFANTRY);
	}

	public static Unit createUnit(final UUID id, final String name, final UnitType unitType) {
		final Unit u = new Unit();
		u.setId(id);
		u.setUnitData(new UnitData());
		u.getUnitData().setName(name);
		u.getUnitData().setUnitType(unitType);
		return u;
	}

	public static UnitData createUnitData() {
		return createUnitData("Infantry", UnitType.INFANTRY);
	}

	public static UnitData createUnitData(final String name, final UnitType unitType) {
		final UnitData unitData = new UnitData();
		unitData.setId(1L);
		unitData.setName(name);
		unitData.setUnitType(unitType);
		return unitData;
	}

	public static UnitQueue createUnitQueue() {
		return createUnitQueue(randomUUID(), randomUUID(), 1L);
	}

	public static UnitQueue createUnitQueue(final UUID queueId, final UUID cityId, final Long unitDataId) {
		final UnitQueue unitQueue = new UnitQueue();
		unitQueue.setId(queueId);
		unitQueue.setTicks(10);
		unitQueue.setNrOfUnits(10);
		unitQueue.setCity(new CityRef(cityId));
		unitQueue.setUnit(buildUnitData().withId(unitDataId).build());
		return unitQueue;
	}

	public static User createUser() {
		return UserTestFactory.newBuilder().build();
	}

	private EntityTestFactory() {

	}
}
