package se.webinfostudio.game.etheder.entity.util;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.building.BuildingRef;
import se.webinfostudio.game.etheder.entity.player.Army;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.player.PlayerRef;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.entity.research.ResearchRef;
import se.webinfostudio.game.etheder.entity.unit.Unit;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;
import se.webinfostudio.game.etheder.entity.unit.UnitType;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.entity.user.UserRef;

/**
 *
 * @author Johan Hanson
 */
public final class EntityTestFactory {

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
		return createBuilding(randomUUID(), "Barracks");
	}

	/**
	 * Creates a building instance.
	 *
	 * @param id   the id for the building
	 * @param name the name of building
	 * @return {@link Building}
	 */
	public static Building createBuilding(final UUID id, final String name) {
		final Building b = new Building();
		b.setId(id);
		b.setBuildingData(new BuildingData());
		b.getBuildingData().setId(1L);
		b.getBuildingData().setName(name);
		return b;
	}

	public static BuildingData createBuildingData() {
		return createBuildingData(Long.valueOf(1l), "Infantry", UnitType.INFANTRY);
	}

	/**
	 * Creates a building instance.
	 *
	 * @param id       the id for the building
	 * @param name     the name of building
	 * @param unitType the unittype of the building
	 * @return {@link Building}
	 */
	public static BuildingData createBuildingData(final Long id, final String name, final UnitType unitType) {
		final BuildingData buildingData = new BuildingData();
		buildingData.setId(id);
		buildingData.setName(name);
		buildingData.setUnitType(unitType);
		buildingData.setDescription("description");
		buildingData.setTicks(10);
		return buildingData;
	}

	/**
	 * Creates a buildingqueue instance.
	 *
	 * @return {@link BuildingQueue}
	 */
	public static BuildingQueue createBuildingQueue() {
		return createBuildingQueue(randomUUID(), randomUUID(), Long.valueOf(1l));
	}

	/**
	 * Creates a buildingqueue instance.
	 *
	 * @param queueId    a id for the queue
	 * @param cityId     a id for the {@link CityRef}
	 * @param buildingId a id for the {@link BuildingRef}
	 * @return {@link BuildingQueue}
	 */
	public static BuildingQueue createBuildingQueue(final UUID queueId, final UUID cityId, final Long buildingId) {
		final BuildingQueue bq = new BuildingQueue();
		bq.setId(queueId);
		bq.setTicks(10);
		bq.setCity(new CityRef(cityId));
		bq.setBuilding(createBuildingData(buildingId, "inf", UnitType.INFANTRY));
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
		return city;
	}

	/**
	 * Creates a player instance.
	 *
	 * @return {@link Player}
	 */
	public static Player createPlayer() {
		return createPlayer(UUID.randomUUID(), "Johan");
	}

	/**
	 * Creates a player instance.
	 *
	 * @param id      the id for the player
	 * @param country the country for the player
	 * @return {@link Player}
	 */
	public static Player createPlayer(final UUID id, final String country) {
		final Player player = new Player();
		player.setId(id);
		player.setCountry(country);
		player.setMyUser(new UserRef(randomUUID()));
		return player;
	}

	/**
	 * Creates a research instance.
	 *
	 * @return {@link Research}
	 */
	public static Research createResearch() {
		return createResearch(Long.valueOf(1L), "Barracks upgrade", UnitType.INFANTRY);
	}

	/**
	 * Creates a research instance.
	 *
	 * @param id       the id for the research
	 * @param name     the name of the research
	 * @param unitType the unitType of the research
	 * @return {@link Research}
	 */
	public static Research createResearch(final Long id, final String name, final UnitType unitType) {
		final Research r = new Research();
		r.setId(id);
		r.setName(name);
		r.setUnitType(unitType);
		r.setLevel(2);
		return r;
	}

	/**
	 * Creates a buildingqueue instance.
	 *
	 * @return {@link ResearchQueue}
	 */
	public static ResearchQueue createResearchQueue() {
		return createResearchQueue(randomUUID(), randomUUID(), Long.valueOf(1L));
	}

	/**
	 * Creates a buildingqueue instance.
	 *
	 * @param queueId    a id for the queue
	 * @param playerId   a id for the playerref
	 * @param researchId a id for the buildingref
	 * @return {@link ResearchQueue}
	 */
	public static ResearchQueue createResearchQueue(final UUID queueId, final UUID playerId, final Long researchId) {
		final ResearchQueue rq = new ResearchQueue();
		rq.setId(queueId);
		rq.setTicks(10);
		rq.setPlayer(new PlayerRef(playerId));
		rq.setResearch(new ResearchRef(researchId));
		return rq;
	}

	/**
	 * Creates an unit instance.
	 *
	 * @return {@link Unit}
	 */
	public static Unit createUnit() {
		return createUnit(UUID.randomUUID(), "Barracks", UnitType.INFANTRY);
	}

	/**
	 * Creates an unit instance.
	 *
	 * @param id       the id for the unit
	 * @param name     the name of the unit
	 * @param unitType the unittype of the unit
	 * @return {@link Unit}
	 */
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

	/**
	 * Creates a unitqueue instance.
	 *
	 * @return {@link UnitQueue}
	 */
	public static UnitQueue createUnitQueue() {
		return createUnitQueue(UUID.randomUUID(), UUID.randomUUID());
	}

	/**
	 * Creates a buildingqueue instance.
	 *
	 * @param queueId a id for the queue
	 * @param cityId  a id for the cityref
	 * @return {@link UnitQueue}
	 */
	public static UnitQueue createUnitQueue(final UUID queueId, final UUID cityId) {
		final UnitQueue unitQueue = new UnitQueue();
		unitQueue.setId(queueId);
		unitQueue.setTicks(10);
		unitQueue.setNrOfUnits(10);
		unitQueue.setCity(new CityRef(cityId));
		unitQueue.setUnit(new UnitData());
		return unitQueue;
	}

	public static User createUser() {
		return UserTestFactory.newBuilder().build();
	}

	private EntityTestFactory() {

	}
}
