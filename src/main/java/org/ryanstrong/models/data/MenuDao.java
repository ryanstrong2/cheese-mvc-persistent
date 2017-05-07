package org.ryanstrong.models.data;

import org.ryanstrong.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by ryanstrong on 4/12/17.
 */

@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {}