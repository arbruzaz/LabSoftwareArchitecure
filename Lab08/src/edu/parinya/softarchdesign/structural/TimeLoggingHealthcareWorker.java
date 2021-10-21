package edu.parinya.softarchdesign.structural;

import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{
    public TimeLoggingHealthcareWorker(String name, double price) {
        super(name, price);
    }

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName() + " with TimeLogging.");
    }

    @Override
    public void service() {
        System.out.print(new Date() + ": ");
        super.service();
    }
}
