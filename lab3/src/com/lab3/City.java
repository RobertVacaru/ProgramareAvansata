package com.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class City {
    private List<Location> nodes;

    public City() {
        nodes = new ArrayList<>();
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void displayLocations() {
        int find=0;
        if (nodes == null || nodes.size() == 0) {
            System.out.println("Blank list");
        }
        List<Location> sortedlist = new ArrayList<>(nodes);
        Collections.sort(sortedlist);
        System.out.println("\nLocations that are visitable and are not payable:");
        for (int i = 0, n = sortedlist.size(); i <n; i++) {
            if ((sortedlist.get(i) instanceof Visitable) && !(sortedlist.get(i) instanceof Payable)) {
                System.out.println(nodes.get(i+1));find++;
            }
        }
        if(find==0)
        System.out.println("There aren't any locations that are visitable and are not payable\n");

    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
