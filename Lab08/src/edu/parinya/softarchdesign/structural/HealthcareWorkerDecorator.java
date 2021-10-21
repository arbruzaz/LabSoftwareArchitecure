package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker{
    protected HealthcareWorker worker;

    public HealthcareWorkerDecorator(String name, double price) {
        super(name, price);
    }

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);
        this.worker = worker;
    }

    @Override
    public void service(){
        worker.service();
    };

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
