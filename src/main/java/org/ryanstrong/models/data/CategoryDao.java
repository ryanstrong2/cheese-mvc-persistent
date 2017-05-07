package org.ryanstrong.models.data;

import org.ryanstrong.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {}