package se.webinfostudio.game.etheder.dao.building;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import se.webinfostudio.game.etheder.dao.AbstractManualDAO;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingManualDAO extends AbstractManualDAO<Building> {

	@Inject
	public BuildingManualDAO(final SessionFactory sessionFactory) {
		super(sessionFactory, Building.class);
	}

}
