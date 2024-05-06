package com.mirea.kachalovaa.employeedb;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;

        // запись сотрудников в базу
        employeeDao.insert(employee);

        // Загрузка всех работников
        List<Employee> employees = employeeDao.getAll();

        // Получение определенного работника с id = 1
        employee = employeeDao.getById(1);

        // Обновление полей объекта
        employee.salary = 20000;
        employeeDao.update(employee);

        Log.d("DATABASE SIGNAL", employee.name + " " + employee.salary);
    }
}