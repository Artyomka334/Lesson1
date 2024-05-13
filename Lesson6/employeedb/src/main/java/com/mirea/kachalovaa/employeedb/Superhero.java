package com.mirea.kachalovaa.employeedb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Superhero {
    @PrimaryKey (autoGenerate = true)
    public long id;
    public String nickname;
    public int height;
    public int weight;
    public String ability;
    public int age;
}
