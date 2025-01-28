package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Road;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Director<D extends Dispatch<D,R>,R extends Road<D,R>> {

    protected final R road;

    public Director(R road) {
        this.road = road;
    }

    public R getRoad() {
        return road;
    }

    public static class Network extends Director<Dispatch.Network, Road.Network> {

        public Network(Road.Network road) {
            super(road);
        }
    }

}
