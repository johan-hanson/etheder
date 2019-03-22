package se.webinfostudio.game.etheder.engine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueEngineServiceTest {

//    @Mock
//    private UnitRepository unitRepository;
//
//    @Mock
//    private UnitQueueRepository unitQueueRepository;
//
//    @Mock
//    private CityRepository cityRepository;
//
//    @Mock
//    private ArmyRepository armyRepository;

	@InjectMocks
	private UnitQueueEngineService sut;

	@BeforeEach
	void setUp() throws Exception {
//		sut = new UnitQueueEngineService();
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testUpdateAllQueuesAndBuildBuildings() {

//        when(unitQueueRepository.insertUpdateNamedQuery(Matchers.anyString())).thenReturn(2);
//        final List<UnitQueue> list = new LinkedList<>();
//        final UnitQueue unitQueue = new UnitQueue();
//        unitQueue.setCity(new CityRef(1L));
//        unitQueue.setUnit(ethederTestFactory.createUnitData());
//        unitQueue.setNrOfUnits(100);
//        list.add(unitQueue);
//        when(unitQueueRepository.findAllFinished()).thenReturn(list);
//        final City city = createCity();
//        city.addArmy(new ArmyRef(1L));
//        when(cityRepository.findByRef(Matchers.any(CityRef.class))).thenReturn(city);
//        final Army army = new Army();
//        army.setDefaultArmy(Boolean.TRUE);
//        when(armyRepository.findByRef(Matchers.any(ArmyRef.class))).thenReturn((army));
//        Unit unit = new Unit();
//        unit.setUnitData(new UnitData());
//        unit.getUnitData().setUnitType(UnitType.INFANTRY);
//        when(unitRepository.findByRef(Matchers.any(UnitRef.class))).thenReturn(unit);
//
//        sut.updateAllQueuesAndCreateUnits();

//		Mockito.verify(armyRepository, times(1)).update(Matchers.any(Army.class));
	}

}
