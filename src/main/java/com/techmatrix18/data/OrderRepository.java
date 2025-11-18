package com.techmatrix18.data;

import com.techmatrix18.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
