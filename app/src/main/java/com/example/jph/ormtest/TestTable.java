package com.example.jph.ormtest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jph on 03.09.2015.
 */
@DatabaseTable(tableName = "test")
public class TestTable {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String description;

    TestTable() {
    }

    TestTable(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
