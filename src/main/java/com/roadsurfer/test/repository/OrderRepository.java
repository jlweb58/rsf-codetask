package com.roadsurfer.test.repository;

import com.roadsurfer.test.model.RentalOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<RentalOrder, Long> {


}
