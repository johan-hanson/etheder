package se.webinfostudio.game.etheder.dataimport;

import java.util.List;

import se.webinfostudio.game.etheder.entity.AbstractDataEntity;

/**
 *
 * @author Johan Hanson
 *
 */
public interface ImportData<T extends AbstractDataEntity> {

	List<T> getImports() throws DataImportException;
}
