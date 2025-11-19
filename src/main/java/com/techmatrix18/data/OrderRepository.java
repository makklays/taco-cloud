package com.techmatrix18.data;

import com.techmatrix18.model.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder order);

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrderByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    @Query("SELECT o FROM TacoOrder o WHERE o.deliveryCity='Seattle'")
    List<TacoOrder> readOrderDeliveredInSeattle();

    void deleteAll();
}

