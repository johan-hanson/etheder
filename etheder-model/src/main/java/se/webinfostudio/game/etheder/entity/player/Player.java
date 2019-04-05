package se.webinfostudio.game.etheder.entity.player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;
import se.webinfostudio.game.etheder.entity.unit.UnitType;
import se.webinfostudio.game.etheder.entity.user.UserRef;
import se.webinfostudio.game.etheder.entity.util.Predicates;

/**
 *
 * @author Johan Hanson
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Player.findByCity", query = "select p from Player p join p.cityList l WHERE l.cityId=?1") })
public class Player extends AbstractGameEntity implements HasReference<PlayerRef> {

	private static final long serialVersionUID = -6185373648803217614L;

	private String country;

	@NotNull
	@Embedded
	private UserRef user;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Player_CITYLIST", joinColumns = @JoinColumn(name = "playerid"))
	private Set<CityRef> cityList = new HashSet<>();

	@Min(0)
	private Long food = 1000L;
	@Min(0)
	private Long wood = 1000L;
	@Min(0)
	private Long gold = 1000L;
	@Min(0)
	private Long iron = 1000L;
	@Min(0)
	private Long stone = 1000L;
	@Min(0)
	private Integer infantryTechLevel = 0;
	@Min(0)
	private Integer cavalryTechLevel = 0;
	@Min(0)
	private Integer archerTechLevel = 0;
	@Min(0)
	private Integer siegeTechLevel = 0;

	public void addTechLevel(final UnitType unitType) {
		switch (unitType) {
		case INFANTRY:
			infantryTechLevel++;
			break;
		case CAVALRY:
			cavalryTechLevel++;
			break;
		case ARCHER:
			archerTechLevel++;
			break;
		case SIEGE:
			siegeTechLevel++;
			break;
		default:
			throw new IllegalArgumentException("Unknown " + unitType);
		}
	}

	public Optional<CityRef> findCity(final CityRef cityRef) {
		return cityList.stream().filter(Predicates.findByCityRef(cityRef)).findAny();
	}

	public Integer getArcherTechLevel() {
		return archerTechLevel;
	}

	public Integer getCavalryTechLevel() {
		return cavalryTechLevel;
	}

	public Set<CityRef> getCityList() {
		return cityList;
	}

	public String getCountry() {
		return country;
	}

	public Long getFood() {
		return food;
	}

	public Long getGold() {
		return gold;
	}

	public Integer getInfantryTechLevel() {
		return infantryTechLevel;
	}

	public Long getIron() {
		return iron;
	}

	public UserRef getUser() {
		return user;
	}

	public Integer getSiegeTechLevel() {
		return siegeTechLevel;
	}

	public Long getStone() {
		return stone;
	}

	public Integer getTechLevel(final UnitType unitType) {
		Integer techLevel;
		switch (unitType) {
		case INFANTRY:
			techLevel = infantryTechLevel;
			break;
		case CAVALRY:
			techLevel = cavalryTechLevel;
			break;
		case ARCHER:
			techLevel = archerTechLevel;
			break;
		case SIEGE:
			techLevel = siegeTechLevel;
			break;
		case NOT_SPCIFIED:
		default:
			techLevel = 0;
		}
		return techLevel;
	}

	public Long getWood() {
		return wood;
	}

	public void setArcherTechLevel(final Integer archerTechLevel) {
		this.archerTechLevel = archerTechLevel;
	}

	public void setCavalryTechLevel(final Integer cavalryTechLevel) {
		this.cavalryTechLevel = cavalryTechLevel;
	}

	public void setCityList(final Set<CityRef> cityList) {
		this.cityList = cityList;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public void setFood(final Long food) {
		this.food = food;
	}

	public void setGold(final Long gold) {
		this.gold = gold;
	}

	public void setInfantryTechLevel(final Integer infantryTechLevel) {
		this.infantryTechLevel = infantryTechLevel;
	}

	public void setIron(final Long iron) {
		this.iron = iron;
	}

	public void setUser(final UserRef myUser) {
		user = myUser;
	}

	public void setSiegeTechLevel(final Integer siegeTechLevel) {
		this.siegeTechLevel = siegeTechLevel;
	}

	public void setStone(final Long stone) {
		this.stone = stone;
	}

	public void setWood(final Long wood) {
		this.wood = wood;
	}

	@Override
	public PlayerRef toRef() {
		return new PlayerRef(id);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(11).append("Player: ").append(id);
		return sb.toString();
	}
}
