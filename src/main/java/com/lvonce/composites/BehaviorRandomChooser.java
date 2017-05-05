package com.lvonce.composites;

import java.util.Random;
import com.lvonce.interfaces.IBehaviorChooser;

public class BehaviorRandomChooser implements IBehaviorChooser {
    private int value;
    private final Random random;

    private int count;
    private final int countLimit;

    private float weight;
    private final float weightLimit;

    private float[] weightLimits;
    private final float[] weights;



    public BehaviorRandomChooser(float[] weightList, int chooseCount) {
        assert chooseCount > 0;
        assert weightList.length >= chooseCount;

        this.random = new Random(System.nanoTime());

        this.count = 0;
        this.countLimit = chooseCount;

        this.weights = new float[weightList.length];
        this.weightLimits = new float[weightList.length];

        for (int i=0; i<weightList.length; ++i) {
            this.weight += weightList[i];
            this.weights[i] = weightList[i];
            this.weightLimits[i] = weightList[i];
        }
        this.weightLimit = this.weight;
        this.value = unchosen();
    }

    public int unchosen() {
        return -1;
    }

    @Override
    public int next() {
        if (this.count < this.countLimit) {
            ++ this.count;
            float rand = this.random.nextFloat() * this.weight;
            for (int i = 0; i < this.weights.length; ++i) {
                rand -= this.weights[i];
                if (rand < 0.0f) { // choose this one
                    this.weight -= this.weights[i];
                    this.weights[i] = 0.0f;
                    this.value = i;
                    return this.value;
                }
            }
            this.value = this.weights.length - 1;
        } else if (count == countLimit) {
            ++ count;
            value = weights.length;
        }
        return value;
    }

    @Override
    public int current() {
        return value;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int limit() {
        return countLimit;
    }

    @Override
    public void clear() {
        count = 0;
        value = unchosen();
        weight = weightLimit;
        for (int i=0; i<weights.length; ++i) {
            weights[i] = weightLimits[i];
        }
    }
}
