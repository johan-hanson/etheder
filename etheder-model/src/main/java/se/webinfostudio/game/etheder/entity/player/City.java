package se.webinfostudio.game.etheder.entity.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingRef;

/**
 * Class representing a city in the game
 *
 * @author Johan Hanson
 */
public class City extends AbstractGameEntity implements HasReference<CityRef> {

	private static final long serialVersionUID = 9221556338368338916L;

	private String name;

	@NotNull
	private UUID playerId;

	private Set<BuildingRef> buildingList = new HashSet<>();

	/**
	 * Default army where new units will be added to.
	 */
	private UUID defaultArmy;

	private Set<ArmyRef> armyList = new HashSet<>();

	@Min(0)
	private Integer farmers = 1;
	@Min(0)
	private Integer ironminers = 0;
	@Min(0)
	private Integer merchants = 0;
	@Min(0)
	private Integer stonemasons = 0;
	@Min(0)
	private Integer lumberjacks = 1;
	@Min(0)
	private Long population = 500L;
	@Min(0)
	private Integer acres = 20;

	private CityLevel cityLevel = CityLevel.LEVEL1;

	public void addArmy(final ArmyRef aRef) {
		armyList.add(aRef);
	}

	public void addBuilding(final Building building) {
		buildingList.add(building.toRef());
	}

	public Integer getAcres() {
		return acres;
	}

	public Set<ArmyRef> getArmyList() {
		return armyList;
	}

	public Set<BuildingRef> getBuildingList() {
		return buildingList;
	}

	public CityLevel getCityLevel() {
		return cityLevel;
	}

	public UUID getDefaultArmy() {
		return defaultArmy;
	}

	public Integer getFarmers() {
		return farmers;
	}

	public Integer getIronminers() {
		return ironminers;
	}

	public Integer getLevel() {
		return cityLevel.getLevel();
	}

	public Integer getLumberjacks() {
		return lumberjacks;
	}

	public Integer getMerchants() {
		return merchants;
	}

	public String getName() {
		return name;
	}

	public PlayerRef getPlayer() {
		return new PlayerRef(playerId);
	}

	public Long getPopulation() {
		return population;
	}

	public Integer getStonemasons() {
		return stonemasons;
	}

	public Integer getWorkers() {
		return farmers + ironminers + lumberjacks + merchants + stonemasons;
	}

	public void setAcres(final Integer acres) {
		this.acres = acres;
	}

	public void setArmyList(final Set<ArmyRef> armyList) {
		this.armyList = armyList;
	}

	public void setBuildingList(final Set<BuildingRef> buildingList) {
		this.buildingList = buildingList;
	}

	public void setCityLevel(final CityLevel cityLevel) {
		this.cityLevel = cityLevel;
	}

	public void setDefaultArmy(final UUID defaultArmy) {
		this.defaultArmy = defaultArmy;
	}

	public void setFarmers(final Integer farmers) {
		this.farmers = farmers;
	}

	public void setIronminers(final Integer ironminers) {
		this.ironminers = ironminers;
	}

	public void setLumberjacks(final Integer lumberjacks) {
		this.lumberjacks = lumberjacks;
	}

	public void setMerchants(final Integer merchants) {
		this.merchants = merchants;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPopulation(final Long population) {
		this.population = population;
	}

	public void setStonemasons(final Integer stonemasons) {
		this.stonemasons = stonemasons;
	}

	@Override
	public CityRef toRef() {
		return new CityRef(id);
	}

	public UUID getPlayerId() {
		return playerId;
	}

	public void setPlayerId(final UUID playerId) {
		this.playerId = playerId;
	}
}
