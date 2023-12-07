package com.example.KafkaConsumerAppln_SB;


import org.springframework.core.serializer.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class EmployeeDeserializer implements Deserializer<Employee> {

       @Override
    public Employee deserialize(InputStream inputStream) throws IOException {
        return null;
    }

    @Override
    public Employee deserializeFromByteArray(byte[] data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee employee = null;
        try {
            employee = (Employee) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ois.close();
        bais.close();
        return employee;
    }

    public Employee deserialize(byte[] value) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(value);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee employee = null;
        try {
            employee = (Employee) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        ois.close();
        bais.close();
        return employee;
    }
}
