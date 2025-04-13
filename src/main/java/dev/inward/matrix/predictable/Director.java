/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Road;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Director {

    protected Road defaultRoad;

    protected final Map<String,Road> roadByMatrixKeyPath = new WeakHashMap<>();

    public Director(Road defaultRoad) {
        if (defaultRoad == null) {
            Dispatch dispatch = new Dispatch(null, "defaultDirector", "The default director", 2, 100, 10, TimeUnit.SECONDS, 0);
            this.defaultRoad = new Road(dispatch, new LinkedBlockingQueue<>(), new Dispatch.DriverFactory(dispatch, "defaultRoad"));
        }
        else {
            this.defaultRoad = defaultRoad;
        }
    }
    /**
     *
     * @return the default road for this domain
     */
    public Road getDefaultRoad() {
        return defaultRoad;
    }
    /**
     *
     * @param matrixKey the matrixKey for which the Complication will be tied, this implementation will only use it for the uri string value if a road is chosen
     * @param chosenRoad it will associate the road with the MatrixKey for as long as it stays in bureau
     * @return the road to use
     * @param <K> MatrixKey
     * @param <I> MatrixItem
     */
    public <PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> Road getRoad(K matrixKey, Road chosenRoad) {
        String keyValue = matrixKey.toUri().toString();
        this.roadByMatrixKeyPath.put(keyValue, chosenRoad);
        return chosenRoad;
    }

    /**
     *
     * @param matrixKey the matrixKey
     * @return a road which had been set for that matrixKey URI, if it exists
     * @param <K> matrixKey
     * @param <I> matrixItem
     */
    public <PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> Road getRoad(K matrixKey) {
        return this.roadByMatrixKeyPath.get(matrixKey.toUri().toString());
    }
    public <PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> void close(K matrixKey) {
        Road road = this.getRoad(matrixKey);
        if (road != null) {
            road.close();
        }
    }
    public void closeAll() {
        for (String matrixKeyPath: this.roadByMatrixKeyPath.keySet()) {
            this.roadByMatrixKeyPath.get(matrixKeyPath).close();
            this.roadByMatrixKeyPath.remove(matrixKeyPath);
        }
        defaultRoad.close();
    }
}
