package com.lab_2;

import java.util.Arrays;

public class Problem {
    private com.lab_2.Source[] sources;
    private com.lab_2.Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];
    ;
    public Problem() {
    }
    public Destination[] getDestinations() {
        return destinations;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", cost=" + Arrays.toString(cost[0]) +Arrays.toString(cost[1])+Arrays.toString(cost[2])+
                '}';
    }
}
