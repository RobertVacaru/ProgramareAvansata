package com.lab5;

import java.util.Map;

public class Song extends Item{

    public Song(String id, String name, String location) {
        super(id, name, location);
    }

    @Override
    public void addTag(String key, Object obj) {
        super.addTag(key, obj);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public void setTags(Map<String, Object> tags) {
        super.setTags(tags);
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
