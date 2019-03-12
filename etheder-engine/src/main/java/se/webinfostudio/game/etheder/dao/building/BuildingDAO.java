package se.webinfostudio.game.etheder.dao.building;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.Building;

public class BuildingDAO extends AbstractDAO<Building> {

	@Inject
	public BuildingDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public UUID create(final Building entity) {
		return persist(entity).getId();
	}

	@SuppressWarnings("unchecked")
	public List<Building> findAll() {
		return list(currentSession().createQuery("from building"));
	}

	public Building findById(final UUID buildingId) {
		return currentSession().find(Building.class, buildingId);
	}
}
