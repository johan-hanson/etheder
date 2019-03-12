package se.webinfostudio.game.etheder.engine.service;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Workers;

/**
 *
 * @author Johan Hanson
 */
@Named
public class PlayerEngineService {

//    @Inject
//    private CityRepository cityRepository;
//
//    @Inject
//    private CityService cityService;
//
//    @Inject
//    private PlayerRepository playerRepository;

	private static final int RESOURCE_A_PEASANT = 20;

	/**
	 * Updates all players with new resources found by pesants.
	 */
	public void updateResources() {
//		final List<Player> players = playerRepository.findAll();
//		for (final Player player : players) {
//			final List<City> cities = cityRepository.findAllByPlayer(player);
//			final Workers workers = new Workers();
//			for (final City city : cities) {
//				updateResources(city, workers);
//			}
//			player.setFood(player.getFood() + (workers.getFarmers() * RESOURCE_A_PEASANT));
//			player.setWood(player.getWood() + (workers.getLumberjacks() * RESOURCE_A_PEASANT));
//			player.setIron(player.getIron() + (workers.getIronminers() * RESOURCE_A_PEASANT));
//			player.setStone(player.getStone() + (workers.getStonemasons() * RESOURCE_A_PEASANT));
//			player.setGold(player.getGold() + (workers.getMerchants() * RESOURCE_A_PEASANT));
//
//			playerRepository.update(player);
//		}
	}

	private void updateResources(final City city, final Workers workers) {
		workers.addFarmers(city.getFarmers());
		workers.addLumberjacks(city.getLumberjacks());
		workers.addIronminers(city.getIronminers());
		workers.addStonemasons(city.getStonemasons());
		workers.addMerchants(city.getMerchants());

//		city.setPopulation(cityService.calculateNewPopulation(city));
//		city.setCityLevel(cityService.checkCityLevel(city));
//
//		cityRepository.update(city);
	}

}
