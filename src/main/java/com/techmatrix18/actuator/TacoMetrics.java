package com.techmatrix18.actuator;

import com.techmatrix18.model.Ingredient;
import com.techmatrix18.model.Taco;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Add user's metric
 */
@Component
public class TacoMetrics extends AbstractRepositoryEventListener<Taco> {

    private MeterRegistry meterRegistry;

    public TacoMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    protected void onAfterCreate(Taco taco) {
        List<Ingredient> ingredients = taco.getIngredients();
        for (Ingredient ingredient : ingredients) {
            meterRegistry.counter("tacocloud", "ingredient", ingredient.getId()).increment();
        }
    }
}

